package com.cognizance.cognizance18;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cognizance.cognizance18.adapters.EventsRViewAdapter;
import com.cognizance.cognizance18.database.EventPreview;
import com.cognizance.cognizance18.models.Event;
import com.cognizance.cognizance18.models.EventDetails.EventDescription;
import com.cognizance.cognizance18.models.Example;
import com.cognizance.cognizance18.utilities.ApiUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shashank on 12/1/18.
 */

public class EventDetails extends AppCompatActivity{

    private RelativeLayout intro,registration,rules,problem,contact;

    private TextView introText,registrationText,rulesText,problemText,contactText;

    private int PRIVATE_MODE = 0;

    EventDescription description;


    private static final String PREF_NAME = "LoginPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details_fragment);
        initializeViews();
        getEventDetails();

    }


    private void getEventDetails(){

        SharedPreferences pref = getBaseContext().getSharedPreferences(PREF_NAME,PRIVATE_MODE);

        int id= pref.getInt("id",0);

        String s= String.valueOf(id);


        Call<EventDescription> call = ApiUtils.getInterfaceService().getEventDetails(s);
        call.enqueue(new Callback<EventDescription>() {
            @Override
            public void onResponse(Call<EventDescription> call, Response<EventDescription> response) {
             if (response.isSuccessful()){

                 description = response.body();

                 expandCardview();
             }
            }

            @Override
            public void onFailure(Call<EventDescription> call, Throwable t) {

                Toast.makeText(getBaseContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void expandCardview(){


        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (introText.getVisibility()==View.GONE){
                    introText.setVisibility(View.VISIBLE);
                    introText.setText(description.getEvent().getDescription());
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
                    registrationText.setText("Go to www.ognizance.org.in and search for" +description.getEvent().getType()  );
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
                    rulesText.setText(description.getEvent().getRules() );
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

//
//    private void setViews(){
//
//        ArrayList<EventPreview> eventsList;
//        eventsList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            EventPreview event = new EventPreview();
//            event.setName("Event" + (i + 1));
//            eventsList.add(event);
//        }
//
//        eventRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()
//                , LinearLayoutManager.HORIZONTAL, false));
//
//    }

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
