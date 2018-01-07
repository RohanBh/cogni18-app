package com.cognizance.cognizance18;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.cognizance.cognizance18.models.LoginResponse;

/**
 * Created by samagra on 1/12/17.
 */

public class SessionManager {
    // Shared Preferences
    private SharedPreferences preferences;

    // Editor for Shared preferences
    private SharedPreferences.Editor editor;

    // Context
    private Context context;

    // Shared pref mode
    private int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "LoginPref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    private static final String KEY_USER_EMAIL = "email";

    private static final String MESSAGE = "message";
    private static final String TOKEN = "token";
    private static final String ROLE = "role";
    private static final String NAME = "name";



    public SessionManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);

    }

    /**
     * Create login session
     * */
    public void createLoginSession(LoginResponse response){
        // Storing login value as TRUE
        editor = preferences.edit();
        editor.putBoolean(IS_LOGIN, true);

        // Storing email in pref
        editor.putString(KEY_USER_EMAIL, response.getEmail());
        editor.putString(MESSAGE, response.getMessage());
        editor.putString(TOKEN , response.getToken());
        editor.putString(ROLE, response.getRole());
        editor.putString(NAME , response.getName());


        // commit changes
        editor.apply();
    }

    /**
     * Get stored session data
     * */
    public String getUserDetails(){

        // return user
        return preferences.getString(KEY_USER_EMAIL,null);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return preferences.getBoolean(IS_LOGIN, false);
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent intent = new Intent(context, LoginActivity.class);
            // Closing all the Activities
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            context.startActivity(intent);
            ((Activity) context).finish();
        }

    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor = preferences.edit();
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        context.startActivity(i);

    }
}
