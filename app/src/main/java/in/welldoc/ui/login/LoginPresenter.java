package in.welldoc.ui.login;

import android.content.Context;

import android.widget.EditText;

import androidx.annotation.NonNull;

import in.welldoc.R;
import in.welldoc.data.local.SqliteController;


public class LoginPresenter implements LoginContract.Presenter{

    @NonNull
    LoginContract.View mView;
    Context mContext;
    String email, pass;
    SqliteController sqliteController;

    public LoginPresenter(@NonNull LoginContract.View view, Context context){
        mView = view;
        mView.setPresenter(this);
        mContext = context;
        sqliteController = new SqliteController(context);
    }

    @Override
    public boolean validateLoginFields(EditText[] fields) {
        for (EditText field: fields){
            if (field.getText().toString().isEmpty()){
                field.setError("Provide the required field!");
                return false;
            }
        }
        validated(fields);
        return true;
    }

    private void validated(EditText[] fields){
        email = fields[0].getText().toString();
        pass = fields[1].getText().toString();
        checkCredentials(email, pass);
    }


    private void checkCredentials(String email, String pass){
       if (sqliteController.checkUserCredentials(email, pass)){
           mView.showSuccessfulMessage(mContext.getString(R.string.success_valid_email_password));
           mView.navigateTo(email);
       }else{
           mView.showFailedMessage(mContext.getString(R.string.error_valid_email_password));
       }
    }

    @Override
    public void start() {}

}
