package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cognizance.cognizance18.fragments.EventsContentFragment;

public class EventsFragment extends Fragment {

    private static final String CENTERSTAGE_TAG = "centerstage_fragment";
    private static final String DEPARTMENTAL_TAG = "department_fragment";

    private TextView centerstageTab;
    private TextView departmentalTab;
    private Fragment selectedEventFragment;

    public static EventsFragment newInstance() {
        EventsFragment fragment = new EventsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setupListeners();
        changeTab(centerstageTab, departmentalTab, CENTERSTAGE_TAG);
    }

    private void initViews(View view) {
        centerstageTab = view.findViewById(R.id.centerstage_tab);
        departmentalTab = view.findViewById(R.id.departmental_tab);
    }

    private void setupListeners() {
        centerstageTab.setOnClickListener(
                (v) -> changeTab(centerstageTab, departmentalTab, CENTERSTAGE_TAG)
        );
        departmentalTab.setOnClickListener(
                (v) -> changeTab(departmentalTab, centerstageTab, DEPARTMENTAL_TAG)
        );
    }

    private void changeTab(TextView selectedTab, TextView otherTab, String fragmentTag) {
        selectedTab.setSelected(true);
        selectedTab.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white, null));
        otherTab.setSelected(false);
        otherTab.setTextColor(ResourcesCompat.getColor(getResources(), R.color.dark_gray, null));

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        selectedEventFragment = fragmentManager.findFragmentByTag(fragmentTag);
        if (selectedEventFragment == null) {
            selectedEventFragment = EventsContentFragment.newInstance(selectedTab.getText().toString());
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.events_content_fragment, selectedEventFragment, fragmentTag);
        transaction.commit();
    }
}
