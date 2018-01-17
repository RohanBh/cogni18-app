package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.cognizance.cognizance18.fragments.BottomSheetFragment;
import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener;

public class MainActivity extends AppCompatActivity implements OnFragmentAddedListener,
        BottomSheetFragment.OnBottomSheetCancelledListener {

    private static final String HOME_TAG = "home_fragment";
    private static final String EVENTS_TAG = "event_fragment";
    private static final String PROFILE_TAG = "profile_fragment";
    private static final String WORKSHOP_TAG = "workshop_fragment";
    private static final String SPOTLIGHT_TAG = "spotlight_fragment";
    private static final String BOTTOM_SHEET_TAG = "bottom_sheet_fragment";

    private BottomNavigationView bottomNavigationView;
    private BottomSheetFragment bottomSheetFragment;

    SessionManager session;

    private int prevNonDialogMenuItemId = -1;
    private boolean isFirstTransaction = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_activity);
        session = new SessionManager(getApplicationContext());
        Toast.makeText(this, "Logged in"+ session.isLoggedIn(), Toast.LENGTH_SHORT).show();
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    if (prevNonDialogMenuItemId == item.getItemId()) {
                        return true;
                    }
                    switch (item.getItemId()) {
                        case R.id.action_events:
                            replaceFragment(EVENTS_TAG);
                            dismissBottomSheet(item.getItemId());
                            break;
                        case R.id.action_workshops:
                            replaceFragment(WORKSHOP_TAG);
                            dismissBottomSheet(item.getItemId());
                            break;
                        case R.id.action_home:
                            replaceFragment(HOME_TAG);
                            dismissBottomSheet(item.getItemId());
                            break;
                        case R.id.action_spotlight:
                            replaceFragment(SPOTLIGHT_TAG);
                            dismissBottomSheet(item.getItemId());
                            break;
                        case R.id.action_profile:
                            //replaceFragment(PROFILE_TAG);
                            bottomSheetFragment = new BottomSheetFragment();
                            bottomSheetFragment.show(getSupportFragmentManager(), BOTTOM_SHEET_TAG);
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
    public void onBottomSheetCancel() {
        if (prevNonDialogMenuItemId != -1) {
            bottomNavigationView.setSelectedItemId(prevNonDialogMenuItemId);
        }
    }

    private void dismissBottomSheet(int itemId) {
        prevNonDialogMenuItemId = itemId;
        if (bottomSheetFragment != null) {
            bottomSheetFragment.dismiss();
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

