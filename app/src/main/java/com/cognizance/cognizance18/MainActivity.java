package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.cognizance.cognizance18.database.CategoryCenterStage;
import com.cognizance.cognizance18.database.CategoryDepartmental;
import com.cognizance.cognizance18.database.CentralList;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = "MainActivity";

    BottomNavigationView bottomNavigationView;
    List<CategoryCenterStage> centerStageList;
    List<CategoryDepartmental> departmentalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_activity);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.getMenu().getItem(2).setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        android.support.v4.app.Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                selectedFragment = HomeFragment.newInstance();
                                break;
                            case R.id.action_events:
                                selectedFragment = EventsFragment.newInstance();
                                break;
                            case R.id.action_profile:
                                selectedFragment = ProfileFragment.newInstance();
                                break;
                            case R.id.action_workshops:
                                selectedFragment = WorkshopsFragment.newInstance();
                                break;
                            case R.id.action_spotlight:
                                selectedFragment = SpotlightFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.container, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, HomeFragment.newInstance());
        transaction.commit();
        Realm.init(this);

        Realm realm = Realm.getDefaultInstance();
        RealmResults<CentralList> centralLists = realm.where(CentralList.class).findAll();
        for (CentralList centralList : centralLists){
            centerStageList = centralList.getCentralStage();
            departmentalList = centralList.getDepartmental();
        }
        Log.v(LOG_TAG,centerStageList==null ? "empty":Integer.toString(centerStageList.size()));

    }
}

