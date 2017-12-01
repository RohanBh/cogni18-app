package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText emailEditText;
    private TextInputEditText phoneEditText;
    private AppCompatButton getStartedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);

        //initialising login views
        initViews();

        // set click listeners
    }

    private void initViews(){
        emailEditText = findViewById(R.id.email_edit_text);
        phoneEditText = findViewById(R.id.mobile_number_edit_text);
        getStartedButton = findViewById(R.id.get_started_btn);

    }

    private void setClickListeners(){
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyFromAPI();
            }
        });
    }

    private void verifyFromAPI(){

    }
}
