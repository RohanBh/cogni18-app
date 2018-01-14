package com.cognizance.cognizance18

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import com.cognizance.cognizance18.fragments.OnboardingFragment
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_onboarding)
        onboarding_pager.adapter = OnboardingPagerAdapter(supportFragmentManager)
    }

    override fun onBackPressed() {
        if (onboarding_pager.currentItem == 0) {
            super.onBackPressed()
        } else {
            onboarding_pager.currentItem -= 1
        }
    }

    private class OnboardingPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int) = OnboardingFragment()

        override fun getCount() = 3

    }

}
