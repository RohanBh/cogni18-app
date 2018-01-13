package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener;

public class MainActivity extends AppCompatActivity implements OnFragmentAddedListener{

    private static final String HOME_TAG = "home_fragment";
    private static final String EVENTS_TAG = "event_fragment";
    private static final String PROFILE_TAG = "profile_fragment";
    private static final String WORKSHOP_TAG = "workshop_fragment";
    private static final String SPOTLIGHT_TAG = "spotlight_fragment";

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_activity);
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.getMenu().getItem(2).setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.action_home:
                            replaceFragment(HOME_TAG);
                            break;
                        case R.id.action_events:
                            replaceFragment(EVENTS_TAG);
                            break;
                        case R.id.action_profile:
                            replaceFragment(PROFILE_TAG);
                            break;
                        case R.id.action_workshops:
                            replaceFragment(WORKSHOP_TAG);
                            break;
                        case R.id.action_spotlight:
                            replaceFragment(SPOTLIGHT_TAG);
                            break;
                    }
                    return true;
                });
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance(), HOME_TAG)
                .commit();
    }


    @Override
    public void onFragmentAdd(int item) {
        bottomNavigationView.getMenu().getItem(item).setChecked(true);
    }

    private void replaceFragment(String fragmentTag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment selectedFragment = fragmentManager.findFragmentByTag(fragmentTag);
        if (selectedFragment == null) {
            selectedFragment = getDefaultFragment(fragmentTag);
        }
        fragmentManager.beginTransaction()
                .replace(R.id.container, selectedFragment, fragmentTag)
                .addToBackStack(null)
                .commit();
    }

    private Fragment getDefaultFragment(String fragmentTag) {
        switch (fragmentTag) {
            case HOME_TAG:
                return HomeFragment.newInstance();
            case EVENTS_TAG:
                return EventsFragment.newInstance();
            case PROFILE_TAG:
                return ProfileFragment.newInstance();
            case WORKSHOP_TAG:
                return WorkshopsFragment.newInstance();
            case SPOTLIGHT_TAG:
                return SpotlightFragment.newInstance();
            default:
                return null;
        }
    }

}

