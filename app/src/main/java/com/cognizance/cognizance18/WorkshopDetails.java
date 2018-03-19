package com.cognizance.cognizance18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cognizance.cognizance18.models.WorkshopModel;

public class WorkshopDetails extends AppCompatActivity {

    private TextView name;
    private RelativeLayout desc, benefits, rules, cost, team_limit,  schedule, contact_details;
    private TextView tDesc, tBenefits, tRules, tCost, tTeamLimit, tSchedule, tContactDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workshop_details);

        WorkshopModel workshop = (WorkshopModel) getIntent().getSerializableExtra("obj");

        name = findViewById(R.id.workshop_name);
        name.setText(workshop.getName());

        desc = findViewById(R.id.workshop_desc);
        tDesc = findViewById(R.id.workshop_desc_real);
        tDesc.setText(workshop.getDesc());
        desc.setOnClickListener(v -> {
            expandCard(desc, tDesc);
        });

        benefits = findViewById(R.id.workshop_benefits);
        tBenefits = findViewById(R.id.workshop_benefits_real);
        tBenefits.setText(workshop.getBeneftis());
        benefits.setOnClickListener(v -> {
            expandCard(benefits, tBenefits);
        });

        rules = findViewById(R.id.workshop_rules);
        tRules = findViewById(R.id.workshop_rules_real);
        tRules.setText(workshop.getRules());
        rules.setOnClickListener(v -> {
            expandCard(rules, tRules);
        });

        cost = findViewById(R.id.workshop_cost);
        tCost = findViewById(R.id.workshop_cost_real);
        tCost.setText(workshop.getCost());
        cost.setOnClickListener(v ->{
            expandCard(cost, tCost);
        });

        team_limit = findViewById(R.id.workshop_teamlimit);
        tTeamLimit = findViewById(R.id.workshop_teamlimit_real);
        tTeamLimit.setText(workshop.getTeamlimit());
        team_limit.setOnClickListener(v -> {
            expandCard(team_limit, tTeamLimit);
        });

        schedule = findViewById(R.id.workshop_schedule);
        tSchedule = findViewById(R.id.workshop_schedule_real);
        tSchedule.setText(workshop.getSchedule());
        schedule.setOnClickListener(v -> {
            expandCard(schedule, tSchedule);
        });

        contact_details = findViewById(R.id.workshop_contact_details);
        tContactDetails = findViewById(R.id.workshop_contact_details_real);
        tContactDetails.setText(workshop.getContactDetails());
        contact_details.setOnClickListener(v -> {
            expandCard(contact_details, tContactDetails);
        });
    }

    public void expandCard(RelativeLayout relativeLayout, TextView textView){
        if (textView.getVisibility() == View.GONE){
            textView.setVisibility(View.VISIBLE);
        }
        else {
            textView.setVisibility(View.GONE);
        }
    }

}
