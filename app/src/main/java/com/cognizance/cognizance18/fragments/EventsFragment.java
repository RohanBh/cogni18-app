package com.cognizance.cognizance18.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.SessionManager;
import com.cognizance.cognizance18.interfaces.Networkservices;
import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener;
import com.cognizance.cognizance18.models.Events;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsFragment extends Fragment {

    private static final String CENTERSTAGE_TAG = "centerstage_fragment";
    private static final String DEPARTMENTAL_TAG = "department_fragment";

    private OnFragmentAddedListener mListener;


    private TextView centerstageTab;
    private TextView departmentalTab;
    public   Fragment selectedEventFragment;
    private SharedPreferences sharedPrefrences;


    private Networkservices networkservices;


    public static EventsFragment newInstance() {
        EventsFragment fragment = new EventsFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentAddedListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement OnFragmentAddedListener");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setupListeners();
        changeTab(centerstageTab, departmentalTab, CENTERSTAGE_TAG);
        mListener.onFragmentAdd(0);
    }

    private void initViews(View view) {
        centerstageTab = view.findViewById(R.id.centerstage_tab);
        departmentalTab = view.findViewById(R.id.departmental_tab);
    }

    private void setupListeners() {
//        centerstageTab.setOnClickListener(
//                v -> changeTab(centerstageTab, departmentalTab, CENTERSTAGE_TAG)
//        );
        centerstageTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTab(centerstageTab,departmentalTab,CENTERSTAGE_TAG);
            }
        });
        departmentalTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTab(departmentalTab,centerstageTab,DEPARTMENTAL_TAG);
            }
        });
    }

    private void changeTab(TextView selectedTab, TextView otherTab, String fragmentTag) {
        selectedTab.setSelected(true);
        selectedTab.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white, null));
        otherTab.setSelected(false);
        otherTab.setTextColor(ResourcesCompat.getColor(getResources(), R.color.dark_gray, null));

        FragmentManager fragmentManager = getChildFragmentManager();
        selectedEventFragment = fragmentManager.findFragmentByTag(fragmentTag);
        if (selectedEventFragment == null) {
            selectedEventFragment = EventsContentFragment.newInstance(selectedTab.getText().toString());
        }

        fragmentManager.beginTransaction()
                .replace(R.id.events_content_fragment, selectedEventFragment, fragmentTag)
                .addToBackStack(null)
                .commit();
    }


}
