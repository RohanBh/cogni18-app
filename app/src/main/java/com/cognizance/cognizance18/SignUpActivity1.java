package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.cognizance.cognizance18.interfaces.ApiInterface;
import com.cognizance.cognizance18.models.LoginResponse;
import com.cognizance.cognizance18.models.SignUpUser;
import com.cognizance.cognizance18.utilities.StateWiseCollegeProvider;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity1 extends AppCompatActivity {

    private TextInputEditText emailEditText;
    private TextInputEditText nameEditText;
    private TextInputEditText mobileEditText;
    private TextInputEditText passwordEditText;
    private TextInputEditText otherCollegeEditText;
    private TextInputEditText roomEditText;
    private TextInputEditText cityEditText;
    private TextInputEditText PINCodeEditText;
    private TextInputEditText branchText;
    private Spinner stateSpinner;
    private Spinner collegeSpinner;
    private Spinner yearSpinner;
    private AppCompatButton signUpButton;
    private ArrayList<String> states;
    private final String BASE_URL = "https://api.cognizance.org.in/";
    private final String LOG_TAG = "SignUpActivity1 :";
    private ArrayList<String> colleges;
    private StateWiseCollegeProvider mCollegeProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);

        mCollegeProvider = new StateWiseCollegeProvider();

        //initialising login views
        initViews();

        //views setup
        setupViews();
        // set click listeners
        setClickListeners();
    }

    private void initViews() {
        emailEditText = findViewById(R.id.email_edit_text);
        mobileEditText = findViewById(R.id.mobile_number_edit_text);
        nameEditText = findViewById(R.id.name_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        signUpButton = findViewById(R.id.sign_up_button);
        otherCollegeEditText = findViewById(R.id.other_collge_edit_text);
        roomEditText = findViewById(R.id.room_hostel_edit_text);
        cityEditText = findViewById(R.id.city_edit_text);
        PINCodeEditText = findViewById(R.id.pincode_edit_text);
        branchText = findViewById(R.id.branch_edit_text);

        stateSpinner = findViewById(R.id.collge_state_spinner);
        collegeSpinner = findViewById(R.id.college_spinner);
        yearSpinner = findViewById(R.id.year_spinner);
    }

    private void setupViews() {
        // college state spinner
        states = mCollegeProvider.getStateList(this);
        if (states != null) {
            ArrayAdapter stateAdapter = new ArrayAdapter(this, R.layout.spinner_dropdown_item, states);
            stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            stateSpinner.setAdapter(stateAdapter);
        }
    }

    private void setClickListeners() {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = mobileEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String mobile = mobileEditText.getText().toString();
                SignUpUser signUpUser = new SignUpUser(email, password, mobile, name, "remote");
                signUpFromAPI(signUpUser);
            }
        });

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setupCollegeSpinner(states.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void setupCollegeSpinner(String state) {
        colleges = mCollegeProvider.getCollegesFromState(this, state);
        if (colleges != null) {
            ArrayAdapter collegeAdapter = new ArrayAdapter(this, R.layout.spinner_dropdown_item, colleges);
            collegeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            collegeSpinner.setAdapter(collegeAdapter);
        }

        collegeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String college = colleges.get(i);
                if (college.equals("Other")) {
                    otherCollegeEditText.setEnabled(true);
                } else {
                    otherCollegeEditText.setText("");
                    otherCollegeEditText.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void signUpFromAPI(SignUpUser signUpUser) {

        ApiInterface apiInterface = this.getInterfaceService();
        Call<LoginResponse> service = apiInterface.signUp(signUpUser);
        service.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse response1 = response.body();
                if (response1 == null)
                    Log.v(LOG_TAG, response.body().toString() + "...");
                else
                    Log.v(LOG_TAG, "Hooray" + response1.getEmail());
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
