package in.welldoc.ui.login;

import android.widget.EditText;

import in.welldoc.ui.base.BasePresenter;
import in.welldoc.ui.base.BaseView;


public interface LoginContract {

    interface View extends BaseView<Presenter> {
            void showSuccessfulMessage(String message);
            void showFailedMessage(String message);
            void navigateTo(String email);
    }

    interface Presenter extends BasePresenter {
            boolean validateLoginFields(EditText[] fields);
    }

}
