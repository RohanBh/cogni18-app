package com.cognizance.cognizance18;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cognizance.cognizance18.models.GuestSpeakers;
import com.squareup.picasso.Picasso;

public class SpeakerDetails extends AppCompatActivity {

    private ImageView photo;
    private TextView name, desc, venue, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_details);

        photo = findViewById(R.id.guest_speaker_pic);
        name = findViewById(R.id.guest_speaker_name);
        desc = findViewById(R.id.guest_speaker_desc);
        venue = findViewById(R.id.guest_speaker_venue);
        time = findViewById(R.id.guest_speaker_time);

        Intent i = getIntent();
        GuestSpeakers guestSpeaker = (GuestSpeakers) i.getSerializableExtra("obj");
        if (guestSpeaker.getImageid() == 0){
            Picasso.with(SpeakerDetails.this).load(guestSpeaker.getImageUrl()).into(photo);
        }
        else {
            photo.setImageResource(guestSpeaker.getImageid());
        }
        name.setText(guestSpeaker.getName());
        desc.setText(guestSpeaker.getInfo());
        venue.setText(guestSpeaker.getVenue());
        time.setText(guestSpeaker.getTime());
    }

}
