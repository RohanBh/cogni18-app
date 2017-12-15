package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognizance.cognizance18.fragments.EventsContentFragment;

public class EventsFragment extends Fragment {

    private TabLayout tabLayout;
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
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        initViews(view);
        setupViews();
        selectedEventFragment = EventsContentFragment.newInstance("Centerstage");
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.events_content_fragment, selectedEventFragment);
        transaction.commit();
        return view;
    }

    private void initViews(View view) {
        tabLayout = view.findViewById(R.id.sliding_tabs);
    }

    private void setupViews(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectedEventFragment = EventsContentFragment.newInstance(tab.getText().toString());
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.events_content_fragment, selectedEventFragment);
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
