package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;

import com.cognizance.cognizance18.models.LoginResponse;
import com.cognizance.cognizance18.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText emailEditText;
    private TextInputEditText phoneEditText;
    private AppCompatButton getStartedButton;
    private final String BASE_URL = "https://api.cognizance.org.in/";
    private final String LOG_TAG = "LoginActivity :";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);

        //initialising login views
        initViews();

        // set click listeners
        setClickListeners();
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
                verifyFromAPI("mastertester456@gmail.com", "password123");
            }
        });
    }

    private void verifyFromAPI(String email, String password){
        User user = new User(email,password);
        ApiInterface apiInterface = this.getInterfaceService();
        Call<LoginResponse> service = apiInterface.authenticate(user);
        service.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse response1 = response.body();
                if (response1 == null)
                Log.v(LOG_TAG,response.body().toString() + "...");
                else
                    Log.v(LOG_TAG,"Hooray" + response1.getEmail());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }

    private ApiInterface getInterfaceService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiInterface.class);
    }
}
