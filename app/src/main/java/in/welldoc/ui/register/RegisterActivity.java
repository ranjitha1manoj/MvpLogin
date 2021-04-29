package in.welldoc.ui.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;


import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.OnClick;
import in.welldoc.R;
import in.welldoc.data.local.User;
import in.welldoc.ui.base.BaseActivity;
import in.welldoc.ui.home.HomeActivity;
import in.welldoc.ui.login.LoginActivity;
import in.welldoc.utils.CommonUtils;

import static androidx.core.util.Preconditions.checkNotNull;

public class RegisterActivity extends BaseActivity implements RegisterContract.View {
    @BindView(R.id.textInputEditTextfirstName)
    TextInputEditText reg_first_name;

    @BindView(R.id.textInputEditTextlastName)
    TextInputEditText reg_last_name;

    @BindView(R.id.textInputEditTextDob)
    TextInputEditText reg_dob;

    @BindView(R.id.textInputEditTextMobile)
    TextInputEditText reg_phone_num;

    @BindView(R.id.textInputEditTextEmail)
    TextInputEditText reg_email_address;

    @BindView(R.id.textInputEditTextPassword)
    TextInputEditText reg_password;
    @BindView(R.id.textInputEditTextconfirmPassword)
    TextInputEditText reg_confirm_password;
    @BindView(R.id.textLogin)
    TextView textLogin;
    @BindView(R.id.btn_continue)
    Button btn_continue;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.rdMale)
    RadioButton rdMale;
    @BindView(R.id.rdFeMale)
    RadioButton rdFemale;
    RegisterContract.Presenter mPresenter;
    RegisterPresenter registerPresenter;
    String gender="";
    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void onPanelClosed(int featureId, @NonNull Menu menu) {
        super.onPanelClosed(featureId, menu);
    }

    @Override
    public void showSuccessfulRegister(String message) {
        showMessageToast(message);
        navigateTo();
    }

    @Override
    public void showErrorRegister(String message) {
        showMessageToast(message);
    }
    @Override
    public void showMessageToast(String message) {
        super.showMessageToast(message);
    }


    @Override
    public void navigateTo() {
        CommonUtils.startActivity(this, LoginActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
    @OnClick({R.id.btn_continue, R.id.textLogin})
    public void buttonClicked(View v) {

        /*if (rdMale.isChecked()) {
            gender = rdMale.getText().toString();
        } else if (rdFemale.isChecked()) {
            gender = rdFemale.getText().toString();
        }
        else
        {
            Toast.makeText(getApplicationContext(), gender, Toast.LENGTH_LONG).show();
        }*/
        switch (v.getId()) {
            case R.id.textLogin:
                CommonUtils.startActivity(this,
                        LoginActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.btn_continue:
                mPresenter.validateRegisterFields(new TextInputEditText[]{reg_first_name, reg_last_name, reg_dob, reg_phone_num,
                        reg_email_address, reg_password});
               //createAccount();
                break;
        }
    }

    private void createAccount() {
            boolean isValidFirstNameNames = CommonUtils.validateNames(reg_first_name);
            boolean isValidlastName = CommonUtils.validateNames(reg_last_name);
            boolean isValidPhone =  CommonUtils.isValidPhoneNumber(reg_phone_num);
            boolean isValidEmail = CommonUtils.isValidEmail(reg_email_address);
            boolean isPasswordValid = CommonUtils.validatePassword(reg_password);
            boolean doesPasswordMatch = CommonUtils.doesPasswordMatch(reg_password, reg_confirm_password);
          /*  if (isValidEmail && isPasswordValid && isValidPhone && isValidFirstNameNames && isValidlastName && doesPasswordMatch) {
                User user = new User(reg_first_name.getText().toString(), reg_last_name.getText().toString(), reg_dob.getText().toString(),
                        reg_phone_num.getText().toString(), reg_email_address.getText().toString(), reg_password.getText().toString());
            }*/
                 if (!isValidFirstNameNames) {
                   reg_first_name.requestFocus();
                } else if (!isValidlastName) {
                    reg_last_name.requestFocus();
                } else if (!isValidPhone) {
                    reg_phone_num.requestFocus();
                } else if (!isValidEmail) {
                    reg_email_address.requestFocus();
                } else if (!isPasswordValid) {
                    reg_password.requestFocus();
                } else if (!doesPasswordMatch) {
                    reg_confirm_password.requestFocus();
                }
                else
                {

                }
            }



    @Override
    protected void onResume() {
        super.onResume();
        registerPresenter = new RegisterPresenter(this, this);
        try {
            mPresenter.start();
        }
        catch (NullPointerException ee)
        {
            ee.printStackTrace();
        }
    }

}
