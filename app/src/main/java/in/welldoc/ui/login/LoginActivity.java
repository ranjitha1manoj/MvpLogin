package in.welldoc.ui.login;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.OnClick;
import in.welldoc.R;
import in.welldoc.ui.base.BaseActivity;
import in.welldoc.ui.home.HomeActivity;
import in.welldoc.utils.CommonUtils;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class LoginActivity extends BaseActivity implements LoginContract.View{
    @BindView(R.id.EditTextLoginEmail)
    TextInputEditText et_email;
    @BindView(R.id.EditTextLoginPassword)
    TextInputEditText et_pass;
    @BindView(R.id.loginBotton)
    Button loginBotton;

    LoginContract.Presenter mPresenter;
    LoginPresenter loginPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
    @Override
    public void setView() {
        super.setView();

    }
    @OnClick({ R.id.loginBotton})
    public void submitClicked() {
        loginPresenter.validateLoginFields(new  TextInputEditText[]{et_email, et_pass});

    }
    @Override
    public void showSuccessfulMessage(String message) {
        showMessageToast(message);
    }

    @Override
    public void showFailedMessage(String message) {
        showMessageToast(message);
    }

    @Override
    public void showMessageToast(String message) {
        super.showMessageToast(message);
    }

    @Override
    public void navigateTo(String email) {
        CommonUtils.startActivity(this,
                HomeActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP,
                email);
        finish();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter = new LoginPresenter(this, this);
    }
}
