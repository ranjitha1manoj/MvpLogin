package in.welldoc.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import in.welldoc.MainActivity;
import in.welldoc.MvpApp;
import in.welldoc.R;
import in.welldoc.data.local.DataManager;
import in.welldoc.utils.CommonUtils;

public class LoginActivity extends AppCompatActivity implements LoginMvpView{
    LoginPresenter loginPresenter;

    TextInputEditText   editTextEmail,editTextPassword;

    Button button;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DataManager dataManager = ((MvpApp) getApplication()).getDataManager();
        loginPresenter = new LoginPresenter(dataManager);

        loginPresenter.onAttach(this);
        editTextEmail = (TextInputEditText) findViewById(R.id.EditTextLoginEmail);
        editTextPassword = (TextInputEditText) findViewById(R.id.EditTextLoginPassword);

        button = (Button) findViewById(R.id.loginBotton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClick();
            }
        });

    }

    @Override
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginButtonClick() {
        String emailId = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (!CommonUtils.isEmailValid(emailId)) {
            Toast.makeText(this, "Enter correct Email", Toast.LENGTH_LONG).show();
            return;
        }

        if (password == null || password.isEmpty()) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_LONG).show();
            return;
        }

        loginPresenter.startLogin(emailId);

    }
    }
