package com.cognizance.cognizance18.interfaces;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by shashank on 11/2/18.
 */

public interface NetworkConstants {

     String PREF_NAME = "LoginPref";

     int PRIVATE_MODE = 0;



    String REST_BASE_URL ="http://api.cognizance.org.in/";


    String REST_EVENTS = "api/android/events";

    String REST_TRENDING = "api/trending";

    String REST_WORKSHOPS = "api/android/workshops";

    String REST_EVENTDETAILS = "/api/android/event/{eventId}";





}
