package com.cognizance.cognizance18.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cognizance.cognizance18.LoginActivity;
import com.cognizance.cognizance18.MainActivity;

/**
 * Created by Narendra on 7/2/18.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle saveInstanceState){

        super.onCreate(saveInstanceState);

        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);

        startActivity(intent);
        finish();

    }
}
