package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Narendra on 11/2/18.
 */

public class ProfileActivity extends AppCompatActivity {

    TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_profile_layout);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0){
                    eventsApi();
                }
                else if (tab.getPosition() == 1){
                    workshopApi();
                }
                else {
                    bookmarkedApi();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void eventsApi(){

    }

    public void workshopApi(){

    }

    public void bookmarkedApi(){

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);

    }

}
