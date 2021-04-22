package in.welldoc.ui.register;

import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import in.welldoc.ui.base.BasePresenter;
import in.welldoc.ui.base.BaseView;


public interface RegisterContract {

    interface View extends BaseView<Presenter> {
        void showSuccessfulRegister(String message);
        void showErrorRegister(String message);
        void navigateTo();
    }

    interface Presenter extends BasePresenter {
        boolean validateRegisterFields(EditText[] fields);
    }

}
