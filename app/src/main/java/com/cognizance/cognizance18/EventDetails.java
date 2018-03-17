package com.cognizance.cognizance18;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cognizance.cognizance18.interfaces.Networkservices;
import com.cognizance.cognizance18.models.EventDetails.EventD;
import com.cognizance.cognizance18.models.EventDetails.EventDescription;
import com.cognizance.cognizance18.utilities.ApiUtils;
import com.cognizance.cognizance18.utilities.NetworkApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shashank on 12/1/18.
 */

public class EventDetails extends AppCompatActivity{

    private RelativeLayout intro,registration,rules,problem,contact;

    private TextView introText,registrationText,rulesText,problemText,contactText;


    private List<EventD> Details;
    EventDescription description;

    private Networkservices networkservices;


    private int PRIVATE_MODE = 0;

    private  SharedPreferences sharedPreferences;


    private static final String PREF_NAME = "LoginPref";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details_fragment);

        networkservices = NetworkApi.getNetworkService();

        initializeViews();

        getEvent();


    }





    private void getEvent(){

         sharedPreferences = getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        int eventId;
        eventId= sharedPreferences.getInt("id",0);

        String s = String.valueOf(eventId);





        networkservices.getEventDetails(s).enqueue(new Callback<EventDescription>() {
            @Override
            public void onResponse(Call<EventDescription> call, Response<EventDescription> response) {
                if (response.isSuccessful()){
                    description = response.body();
                    expandCardview();
                }
            }

            @Override
            public void onFailure(Call<EventDescription> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });







//        networkservices.getEventDetails(a).enqueue(new Callback<EventDescription>() {
//            @Override
//            public void onResponse(@NonNull Call<EventDescription> call, @NonNull Response<EventDescription> response) {
//                if (response.isSuccessful()){
//                    description=response.body();
//                    expandCardview();
//                    Toast.makeText(EventDetails.this, "Fetched", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<EventDescription> call, Throwable t) {
//
//                Toast.makeText(getBaseContext(),"Error"+ t.getMessage(),Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
    }

    private void expandCardview(){


        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (introText.getVisibility()==View.GONE){
                    introText.setVisibility(View.VISIBLE);
                    introText.setText(description.getEventD().getDescription());
                }
                else {
                    introText.setVisibility(View.GONE);
                }
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (registrationText.getVisibility()==View.GONE){
                    registrationText.setVisibility(View.VISIBLE);
                    registrationText.setText("Visit WWW.Cognizance.org.in and go to "+description.getEventD().getType());
                }
                else {
                    registrationText.setVisibility(View.GONE);
                }


            }
        });

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rulesText.getVisibility()==View.GONE){
                    rulesText.setVisibility(View.VISIBLE);
                    rulesText.setText(description.getEventD().getRules());
                }
                else {
                    rulesText.setVisibility(View.GONE);
                }
            }
        });

        problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (problemText.getVisibility()==View.GONE){
                    problemText.setVisibility(View.VISIBLE);
                }
                else {
                    problemText.setVisibility(View.GONE);
                }
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contactText.getVisibility()==View.GONE){
                    contactText.setVisibility(View.VISIBLE);
                }
                else {
                    contactText.setVisibility(View.GONE);
                }
            }
        });
    }



    private void initializeViews(){
        intro = (RelativeLayout)findViewById(R.id.introLayout);
        registration = (RelativeLayout)findViewById(R.id.registration);
        rules = (RelativeLayout)findViewById(R.id.rules);
        problem = (RelativeLayout)findViewById(R.id.problem);
        contact = (RelativeLayout)findViewById(R.id.contact);

        introText =(TextView)findViewById(R.id.info);
        registrationText = (TextView)findViewById(R.id.registrationProcedure);
        rulesText =(TextView)findViewById(R.id.rulesAndRegulation);
        problemText=(TextView)findViewById(R.id.problemStatment);
        contactText=(TextView)findViewById(R.id.contactDetails);
    }

}
