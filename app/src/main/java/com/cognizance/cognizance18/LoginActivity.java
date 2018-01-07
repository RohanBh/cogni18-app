package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText emailEditText;
    private TextInputEditText phoneEditText;
    private AppCompatButton getStartedButton;
    private final String BASE_URL = "base_url";

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
                String email = emailEditText.getText().toString();
                String password = phoneEditText.getText().toString();
                verifyFromAPI(email, password);
            }
        });
    }

    private void verifyFromAPI(String email, String password){
        loginProcessWithRetrofit(email, password);

    }

    private void loginProcessWithRetrofit(String email, String password) {
        ApiInterface mApiService = this.getInterfaceService();
        Call<String> mService = mApiService.authenticate(email, password);
        mService.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String responseCode = response.body();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                call.cancel();
                Toast.makeText(LoginActivity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();

            }
        });
    }

    private ApiInterface getInterfaceService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
        final ApiInterface mInterfaceService = retrofit.create(ApiInterface.class);
        return mInterfaceService;
    }
}
