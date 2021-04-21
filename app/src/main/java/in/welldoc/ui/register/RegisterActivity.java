package in.welldoc.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.welldoc.MainActivity;
import in.welldoc.R;
import in.welldoc.data.local.DBHelper;
import in.welldoc.ui.home.HomeActivity;

public class RegisterActivity extends AppCompatActivity {
    private Button registerBtn;
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private EditText FirstName,LastName,Dob,Email,Phone,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        openHelper = new DBHelper(this);

        registerBtn = findViewById(R.id.btn_logout);
        FirstName = findViewById(R.id.textInputEditTextfirstName);
        LastName=findViewById(R.id.textInputEditTextlastName);
        Dob=findViewById(R.id.textInputEditTextDob);
        Phone = findViewById(R.id.textInputEditTextMobile);
        Email = findViewById(R.id.textInputEditTextEmail);
        Password = findViewById(R.id.textInputEditTextPassword);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String fname =  FirstName.getText().toString().trim();
                String lname =  LastName.getText().toString().trim();
                String dob =  Dob.getText().toString().trim();
                String fPhone = Phone.getText().toString().trim();
                String femail =Email.getText().toString().trim();
                String fPassword = Password.getText().toString().trim();
                if (fname.isEmpty() ||lname.isEmpty()|| dob.isEmpty() || fPhone.isEmpty()|| femail.isEmpty() || fPassword.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                } else {
                    insertData(fname,lname,dob,fPhone,femail,fPassword);
                    Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent iintent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(iintent);
                }
            }
        });


    }
    public void insertData(String fname,String lname,String dob,String fPhone,String femail,String fPassword){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COL_2,fname);
        contentValues.put(DBHelper.COL_3,lname);
        contentValues.put(DBHelper.COL_4,dob);
        contentValues.put(DBHelper.COL_5,fPhone);
        contentValues.put(DBHelper.COL_6,femail);
        contentValues.put(DBHelper.COL_7,fPassword);

        long id = db.insert(DBHelper.TABLE_NAME,null,contentValues);
    }
    }
