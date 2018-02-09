package com.cognizance.cognizance18.activities;

/**
 * Created by s4mr4t on 9/2/18.
 */


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.cognizance.cognizance18.HelperClass.SampleSlide;
import com.cognizance.cognizance18.R;
import com.github.paolorotolo.appintro.AppIntro;

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(SampleSlide.newInstance(R.layout.slide1));
        addSlide(SampleSlide.newInstance(R.layout.slide2));
        addSlide(SampleSlide.newInstance(R.layout.slide3));

        setColorDoneText(getResources().getColor(R.color.black));
        setColorSkipButton(getResources().getColor(R.color.black));
        setIndicatorColor(getResources().getColor(R.color.black), getResources().getColor(R.color.gray));
        setNextArrowColor(getResources().getColor(R.color.black));


        setNavBarColor(R.color.peach);

        setFadeAnimation();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }

}
