package com.cognizance.cognizance18;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener;

public class MainActivity extends AppCompatActivity implements OnFragmentAddedListener {

    private static final String HOME_TAG = "home_fragment";
    private static final String EVENTS_TAG = "event_fragment";
    private static final String PROFILE_TAG = "profile_fragment";
    private static final String WORKSHOP_TAG = "workshop_fragment";
    private static final String SPOTLIGHT_TAG = "spotlight_fragment";
    private static final int MORE_ACTIVITY_RC = 129;

    private BottomNavigationView bottomNavigationView;

    SessionManager session;

    // logic variables
    private int prevNonDialogMenuItemId = -1;
    private boolean isFirstTransaction = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_activity);
        session = new SessionManager(getApplicationContext());
        Toast.makeText(this, "Logged in" + session.isLoggedIn(), Toast.LENGTH_SHORT).show();
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    if (prevNonDialogMenuItemId == item.getItemId()) {
                        return true;
                    }
                    switch (item.getItemId()) {
                        case R.id.action_events:
                            replaceFragment(EVENTS_TAG);
                            prevNonDialogMenuItemId = item.getItemId();
                            break;
                        case R.id.action_workshops:
                            replaceFragment(WORKSHOP_TAG);
                            prevNonDialogMenuItemId = item.getItemId();
                            break;
                        case R.id.action_home:
                            replaceFragment(HOME_TAG);
                            prevNonDialogMenuItemId = item.getItemId();
                            break;
                        case R.id.action_spotlight:
                            replaceFragment(SPOTLIGHT_TAG);
                            prevNonDialogMenuItemId = item.getItemId();
                            break;
                        case R.id.action_profile:
                            //replaceFragment(PROFILE_TAG);
                            startActivityForResult(
                                    new Intent(MainActivity.this, MoreActivity.class),
                                    MORE_ACTIVITY_RC
                            );
                            break;
                    }
                    return true;
                });
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }

    @Override
    public void onFragmentAdd(int itemIndex) {
        MenuItem item = bottomNavigationView.getMenu().getItem(itemIndex);
        item.setChecked(true);
        prevNonDialogMenuItemId = item.getItemId();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MORE_ACTIVITY_RC) {
            if (prevNonDialogMenuItemId != -1) {
                bottomNavigationView.setSelectedItemId(prevNonDialogMenuItemId);
            }
        }
    }

    private void replaceFragment(String fragmentTag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment selectedFragment = fragmentManager.findFragmentByTag(fragmentTag);
        if (selectedFragment == null) {
            selectedFragment = getDefaultFragment(fragmentTag);
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.container, selectedFragment, fragmentTag);
        if (!isFirstTransaction) {
            transaction.addToBackStack(null);
        } else {
            isFirstTransaction = false;
        }
        transaction.commit();

    }

    private Fragment getDefaultFragment(String fragmentTag) {
        switch (fragmentTag) {
            case EVENTS_TAG:
                return EventsFragment.newInstance();
            case WORKSHOP_TAG:
                return WorkshopsFragment.newInstance();
            case HOME_TAG:
                return HomeFragment.newInstance();
            case SPOTLIGHT_TAG:
                return SpotlightFragment.newInstance();
            case PROFILE_TAG:
                return ProfileFragment.newInstance();
            default:
                return null;
        }
    }
}

