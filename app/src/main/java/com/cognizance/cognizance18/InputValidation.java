package com.cognizance.cognizance18;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by samagra on 1/12/17.
 */

public class InputValidation {
    private Context context;

    public InputValidation(Context context) {
        this.context = context;
    }

    public boolean isInputEditTextFilled(TextInputEditText textInputEditText,
                                         TextInputLayout textInputLayout, String message){
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()){
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        }
        else textInputLayout.setErrorEnabled(false);
        return true;
    }

    private void hideKeyboardFrom(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


    public boolean isInputEditTextEmail(TextInputEditText textInputEditText,
                                        TextInputLayout textInputLayout, String message){
        String email = textInputEditText.getText().toString().trim();
        if (isEmailValid(email)){
            textInputLayout.setErrorEnabled(false);
            return true;
        }
        else{
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        }

    }
    /**
     * method is used for checking valid email id format.
     *
     * @param email
     * @return boolean true for valid false for invalid
     */
    private boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
