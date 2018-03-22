package com.cognizance.cognizance18;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class TreasureHunt extends AppCompatActivity {

    private LinearLayout clue;
    private LinearLayout timell;
    private RelativeLayout timerl;
    private long time;
    private long FIVE, SIX;
    private int clueno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.treasure_hunt);

        time = System.currentTimeMillis();

        if (time < FIVE){
            timell = findViewById(R.id.before_time);
            timell.setVisibility(View.VISIBLE);
        }
        else if (time > FIVE && time < SIX){
            if (clueno == 1) {
                timerl = findViewById(R.id.start_time)
                timerl.setVisibility(View.VISIBLE);
            }
            else if (clueno > 0){
                timerl = findViewById(R.id.treasure_hunt);
                timerl.setVisibility(View.VISIBLE);
            }
        }
        else if (time > SIX){
            timerl = findViewById(R.id.after_time);
            timerl.setVisibility(View.VISIBLE);
        }
    }

    public void showHospital(){
        clue = findViewById(R.id.ll_hospital);
        ImageView imageView = findViewById(R.id.ll_hospital1);
        imageView.setImageResource(R.drawable.clue_hospital);
        ImageView imageView1 = findViewById(R.id.ll_hospital2);
        imageView1.setImageResource(R.drawable.clue_hospital1);
    }

    public void showOat(){
        clue = findViewById(R.id.ll_oat);
        ImageView imageView = findViewById(R.id.ll_oat_img);
        imageView.setImageResource(R.drawable.clue_oat1);
        VideoView videoView = findViewById(R.id.ll_oat_video);
        MediaController controller = new MediaController(this);
        controller.setAnchorView(videoView);
        videoView.setMediaController(controller);
        videoView.requestFocus();
        videoView.start();
        //set videoview uri
    }
}
