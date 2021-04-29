

package in.welldoc.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommonUtils {

    public static void startActivity(Context context, Intent intent){
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Class clazz,
                                     int flags){
        Intent intent = createIntentWithFlags(context, clazz, flags);
        startActivity(context, intent);
    }


    public static void startActivity(Context context, Class clazz,
                                     int flags, String wrapper){
        Intent intent = createIntentWithFlags(context, clazz, flags);
        intent.putExtra("detailWrapper", wrapper);
        startActivity(context, intent);
    }

    @NonNull
    public static Intent createIntentWithFlags(Context context, Class clazz,
                                               int flags){
        Intent intent = createIntent(context, clazz);
        intent.setFlags(flags);
        return intent;
    }

    @NonNull
    public static Intent createIntent(Context context, Class clazz){
        Intent intent = new Intent(context, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        return intent;
    }
    public static boolean isValidPhoneNumber(TextInputEditText phoneEditText) {
        if (phoneEditText != null && phoneEditText.getText() != null) {
            if (TextUtils.isEmpty(phoneEditText.getText().toString())) {
                phoneEditText.setError("Phone number cannot be empty");
                //phoneEditText.requestFocus();
                return false;
            } else if(phoneEditText.getText().toString().length()!=10) {
                phoneEditText.setError("Enter valid phone number");
                //phoneEditText.requestFocus();
                return false;
            } else {
                phoneEditText.setError(null);
                return true;
            }
        }
        return false;
    }

    public static boolean isValidEmail(TextInputEditText emailEditText) {
        if (emailEditText != null ) {
            String email = emailEditText.getText().toString();
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            if (email.isEmpty()) {
                emailEditText.setError("Field cannot be empty");
                return false;
            } else if (!email.matches(emailPattern)) {
                emailEditText.setError("Invalid email address");
                return false;
            } else {
                emailEditText.setError(null);
                //EditTextEmail.setErrorEnabled(false);
                return true;
            }
        }
        return false;
    }
    public static boolean validateNames(TextInputEditText firstName) {
        if (firstName != null) {
            if (TextUtils.isEmpty(firstName.getText())) {
                firstName.setError("First Name cannot be Blank");
                //firstName.requestFocus();
            }

            if (!TextUtils.isEmpty(firstName.getText())) {
                firstName.setError(null);
                return true;
            }
        }
        return false;
    }
    public static Boolean validatePassword(TextInputEditText passwordEditText) {
        if (passwordEditText != null && passwordEditText.getText() != null) {
            String password = passwordEditText.getText().toString();
            String passwordVal = "^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$";

            if (password.isEmpty()) {
                passwordEditText.setError("Field cannot be empty");
                return false;
            } else if (!password.matches(passwordVal)) {
                passwordEditText.setError("Password is too weak");
                return false;
            } else {
                passwordEditText.setError(null);
                // EditTextMobile.setErrorEnabled(false);
                return true;
            }
        }
        return false;
    }

    public static Boolean doesPasswordMatch(TextInputEditText passwordEditText, TextInputEditText confirmPassword) {
        if (passwordEditText != null && confirmPassword != null && passwordEditText.getText() != null && confirmPassword.getText() != null)
        {
            String password = passwordEditText.getText().toString();
            if (!TextUtils.isEmpty(password) && !password.equals(confirmPassword.getText().toString())) {
                confirmPassword.setError("Passwords doesn't match");
                return false;
            } else {
                confirmPassword.setError(null);
                // EditTextMobile.setErrorEnabled(false);
                return true;
            }
        }
        return false;
    }


}
