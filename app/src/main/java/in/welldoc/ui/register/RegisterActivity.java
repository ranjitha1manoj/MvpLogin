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
    @BindView(R.id.textLogin)
    TextView textLogin;
    @BindView(R.id.btn_continue)
    Button btn_continue;
    RegisterContract.Presenter mPresenter;
    RegisterPresenter registerPresenter;
    @BindView(R.id.rdMale)
    RadioButton rdMale;
    @BindView(R.id.rdFeMale)
    RadioButton rdFemale;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

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
        //boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()) {

            case R.id.textLogin:
                CommonUtils.startActivity(this,
                        LoginActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        break;
            case R.id.btn_continue:
                mPresenter.validateRegisterFields(new TextInputEditText[]{reg_first_name, reg_last_name, reg_dob, reg_phone_num,
                        reg_email_address, reg_password});
                       break;
           /* case R.id.rdFeMale:
                if (checked)
                    gender= "female";
                break;
            case R.id.rdMale:
                if (checked)
                    gender = "male";
                break;*/
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
