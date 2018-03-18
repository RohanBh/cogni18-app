package com.cognizance.cognizance18;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cognizance.cognizance18.HelperClass.BottomNavigationViewHelper;
import com.cognizance.cognizance18.activities.ScheduleActivity;
import com.cognizance.cognizance18.database.CategoryList;
import com.cognizance.cognizance18.database.CentralList;
import com.cognizance.cognizance18.fragments.EventsFragment;
import com.cognizance.cognizance18.fragments.HomeFragment;
import com.cognizance.cognizance18.fragments.ProfileFragment;
import com.cognizance.cognizance18.fragments.SpotlightFragment;
import com.cognizance.cognizance18.fragments.WorkshopFragment;
import com.cognizance.cognizance18.fragments.WorkshopsFragment;
import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements OnFragmentAddedListener {

    private static final String HOME_TAG = "home_fragment";
    private static final String EVENTS_TAG = "event_fragment";
    private static final String PROFILE_TAG = "profile_fragment";
    private static final String WORKSHOP_TAG = "workshop_fragment";
    private static final String SPOTLIGHT_TAG = "spotlight_fragment";
    private static final int MORE_ACTIVITY_RC = 129;


    SessionManager session;

    // logic variables
    private int prevNonDialogMenuItemId = -1;
    private boolean isFirstTransaction = true;

    private static String LOG_TAG = "MainActivity";

    BottomNavigationView bottomNavigationView;
    List<CategoryList> centerStageList;
    List<CategoryList> departmentalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_activity);
        session = new SessionManager(getApplicationContext());
       // Toast.makeText(this, "Logged in" + session.isLoggedIn(), Toast.LENGTH_SHORT).show();

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
                            startActivity(new Intent(MainActivity.this, ScheduleActivity.class));
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
        Realm.init(this);

        Realm realm = Realm.getDefaultInstance();
        RealmResults<CentralList> centralLists = realm.where(CentralList.class).findAll();
        for (CentralList centralList : centralLists) {
            centerStageList = centralList.getCentralStage();
            departmentalList = centralList.getDepartmental();
        }
        Log.v(LOG_TAG, centerStageList == null ? "empty" : Integer.toString(centerStageList.size()));

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);

        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            // set your height here
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, displayMetrics);
            // set your width here
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }
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
        if (requestCode == MORE_ACTIVITY_RC && resultCode == RESULT_OK) {
            if (prevNonDialogMenuItemId != -1) {
                bottomNavigationView.setSelectedItemId(prevNonDialogMenuItemId);
            }
        }
        if (resultCode == 3000 && requestCode == MORE_ACTIVITY_RC) {
            replaceFragment(HOME_TAG);
            prevNonDialogMenuItemId = R.id.action_home;
        } else if (resultCode == 3001) {
            replaceFragment(EVENTS_TAG);
            bottomNavigationView.setSelectedItemId(R.id.action_events);
        } else if (resultCode == 3002) {
            replaceFragment(WORKSHOP_TAG);
            bottomNavigationView.setSelectedItemId(R.id.action_workshops);
        } else if (resultCode == 3003) {
            replaceFragment(SPOTLIGHT_TAG);
            bottomNavigationView.setSelectedItemId(R.id.action_spotlight);
        } else if (resultCode == 3004) {
            startActivity(new Intent(MainActivity.this, ScheduleActivity.class));
            bottomNavigationView.setSelectedItemId(R.id.action_spotlight);
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
                return WorkshopFragment.newInstance();
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

