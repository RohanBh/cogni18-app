package com.cognizance.cognizance18;

import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.VideoView;

import com.facebook.share.Share;

public class TreasureHunt extends AppCompatActivity {

    private LinearLayout clue;
    private LinearLayout timell;
    private RelativeLayout timerl;
    private Button button;
    private long time;
    private long FIVE, SIX;
    private int clueno;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.treasure_hunt);

        time = System.currentTimeMillis();
        FIVE = 1521804600000L;
        SIX = 1521808200000L;
        sharedPreferences = getSharedPreferences("Treasure_hunt", MODE_PRIVATE);
        clueno = sharedPreferences.getInt("CLUE_NO", 1);
        editor = sharedPreferences.edit();

        if (time < FIVE) {
            timell = findViewById(R.id.before_time);
            timell.setVisibility(View.VISIBLE);
        } else if (time > FIVE && time < SIX) {
            if (clueno == 1) {
                timerl = findViewById(R.id.start_time);
                timerl.setVisibility(View.VISIBLE);
                Button button = findViewById(R.id.go_forward_btn);
                button.setOnClickListener(v -> {
                    button.setEnabled(false);
                    EditText editText = findViewById(R.id.start_route);
                    switch (editText.getText().toString().toLowerCase().trim()) {
                        case "green":
                            increaseClueNo();
                            timerl = findViewById(R.id.treasure_hunt);
                            timerl.setVisibility(View.VISIBLE);
                            showTpo();
                            break;
                        case "red":
                            increaseClueNo();
                            timerl = findViewById(R.id.treasure_hunt);
                            timerl.setVisibility(View.VISIBLE);
                            showTpo();
                            break;
                        case "blue":
                            increaseClueNo();
                            timerl = findViewById(R.id.treasure_hunt);
                            timerl.setVisibility(View.VISIBLE);
                            showOldHostel();
                            break;
                        default:
                            editText.setError("TRY AGAIN");
                            button.setEnabled(true);
                    }
                });
            } else if (clueno > 1) {
                timerl = findViewById(R.id.treasure_hunt);
                timerl.setVisibility(View.VISIBLE);
                Button button = findViewById(R.id.clue_btn);
                button.setOnClickListener(v -> {
                    //check beacon
                    //clue == invisible
                    //call method
                });
            }
        } else if (time > SIX) {
            timerl = findViewById(R.id.after_time);
            timerl.setVisibility(View.VISIBLE);
        }
    }

    public void increaseClueNo() {
        clueno++;
        editor.putInt("CLUE_NO", clueno);
        editor.apply();
    }

    public void showHospital() {
        clue = findViewById(R.id.ll_hospital);
        clue.setVisibility(View.VISIBLE);
        ImageView imageView = findViewById(R.id.ll_hospital1);
        imageView.setImageResource(R.drawable.clue_hospital);
        ImageView imageView1 = findViewById(R.id.ll_hospital2);
        imageView1.setImageResource(R.drawable.clue_hospital1);
        editor.putString("LOCATION", "hospital");
        editor.apply();
    }

    public void showOat() {
        clue = findViewById(R.id.ll_oat);
        clue.setVisibility(View.VISIBLE);
        ImageView imageView = findViewById(R.id.ll_oat_img);
        imageView.setImageResource(R.drawable.clue_oat1);
        VideoView videoView = findViewById(R.id.ll_oat_video);
        MediaController controller = new MediaController(this);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.oats));
        videoView.setMediaController(controller);
        controller.setAnchorView(videoView);
        videoView.start();
        editor.putString("LOCATION", "oat");
        editor.apply();
    }

    public void showTpo() {
        clue = findViewById(R.id.ll_tpo);
        clue.setVisibility(View.VISIBLE);
        VideoView videoView = findViewById(R.id.ll_tpo1);
        MediaController controller = new MediaController(this);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tpo));
        videoView.setMediaController(controller);
        controller.setAnchorView(videoView);
        videoView.start();
        editor.putString("LOCATION", "tpo");
        editor.apply();
    }

    public void showFineArts() {
        clue = findViewById(R.id.ll_finearts);
        clue.setVisibility(View.VISIBLE);
        ImageView imageView = findViewById(R.id.ll_finearts1);
        imageView.setImageResource(R.drawable.clue_finearts);
        imageView = findViewById(R.id.ll_finearts2);
        imageView.setImageResource(R.drawable.clue_finearts1);
        editor.putString("LOCATION", "finearts");
        editor.apply();
    }

    public void showJd() {
        clue.setVisibility(View.GONE);
        clue = findViewById(R.id.ll_jd);
        ImageView imageView = findViewById(R.id.ll_jd1);
        imageView.setImageResource(R.drawable.clue_jd);
        imageView = findViewById(R.id.ll_jd2);
        imageView.setImageResource(R.drawable.clue_jd1);
        editor.putString("LOCATION", "jdgate");
        editor.apply();
    }

    public void showNcc() {
        clue = findViewById(R.id.ll_ncc);
        clue.setVisibility(View.VISIBLE);
        editor.putString("LOCATION", "ncc");
        editor.apply();
    }

    public void showAzad() {
        clue = findViewById(R.id.ll_azad);
        clue.setVisibility(View.VISIBLE);
        ImageView imageView = findViewById(R.id.ll_azad1);
        imageView.setImageResource(R.drawable.clue_azad);
        editor.putString("LOCATION", "azad");
        editor.apply();
    }

    public void showAlpahar() {
        clue = findViewById(R.id.ll_alpahar);
        ImageView imageView = findViewById(R.id.ll_alpahar1);
        imageView.setImageResource(R.drawable.clue_alpahar);
        editor.putString("LOCATION", "alpahar");
        editor.apply();
    }

    public void showOldHostel() {
        clue = findViewById(R.id.ll_oldhostel);
        clue.setVisibility(View.VISIBLE);
        ImageView imageView = findViewById(R.id.ll_oldhostel1);
        imageView.setImageResource(R.drawable.clue_oldhostel);
        imageView = findViewById(R.id.ll_oldhostel2);
        imageView.setImageResource(R.drawable.clue_oldhostel1);
        editor.putString("LOCATION", "oldhostel");
        editor.apply();
    }

    public void showNesci() {
        clue = findViewById(R.id.ll_nesci);
        clue.setVisibility(View.VISIBLE);
        editor.putString("LOCATION", "nesci");
        editor.apply();
    }
}
