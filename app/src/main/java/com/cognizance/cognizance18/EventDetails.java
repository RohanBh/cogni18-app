package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.adapters.CarouselRViewAdapter;
import com.cognizance.cognizance18.models.Event;

import java.util.ArrayList;

/**
 * Created by shashank on 12/1/18.
 */

public class EventDetails extends AppCompatActivity{

    private RelativeLayout intro,registration,rules,problem,contact;

    private TextView introText,registrationText,rulesText,problemText,contactText;

    private RecyclerView eventRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details_fragment);
        initializeViews();
        expandCardview();

    }


    private void expandCardview(){


        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (introText.getVisibility()==View.GONE){
                    introText.setVisibility(View.VISIBLE);
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


    private void setViews(){

        ArrayList<Event> eventsList;
        eventsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Event event = new Event();
            event.setName("Event" + (i + 1));
            eventsList.add(event);
        }

        eventRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()
                , LinearLayoutManager.HORIZONTAL, false));
        eventRecyclerView.setAdapter(new CarouselRViewAdapter(getApplicationContext(), eventsList));
    }

    private void initializeViews(){
        intro = (RelativeLayout)findViewById(R.id.introLayout);
        registration = (RelativeLayout)findViewById(R.id.registration);
        rules = (RelativeLayout)findViewById(R.id.rules);
        problem = (RelativeLayout)findViewById(R.id.problem);
        contact = (RelativeLayout)findViewById(R.id.contact);


        eventRecyclerView = (RecyclerView) findViewById(R.id.eventDetails);
        introText =(TextView)findViewById(R.id.info);
        registrationText = (TextView)findViewById(R.id.registrationProcedure);
        rulesText =(TextView)findViewById(R.id.rulesAndRegulation);
        problemText=(TextView)findViewById(R.id.problemStatment);
        contactText=(TextView)findViewById(R.id.contactDetails);
    }

}
