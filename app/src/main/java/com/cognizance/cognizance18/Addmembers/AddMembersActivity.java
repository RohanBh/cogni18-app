package com.cognizance.cognizance18.Addmembers;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.cognizance.cognizance18.R;

/**
 * Created by shashank on 9/2/18.
 */

public class AddMembersActivity extends AppCompatActivity {


    private ImageView close;
    private FrameLayout viewPager;
    android.support.v4.app.Fragment selectedFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_members_page);

        InitializeViews();
        setupViews();


        selectedFragment = MembersFragment.newInstance();
    }


    private void setupViews(){

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frame, selectedFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        return;

    }

    public void InitializeViews(){
        close = (ImageView)findViewById(R.id.cross);
        viewPager = findViewById(R.id.frame);
    }


}
