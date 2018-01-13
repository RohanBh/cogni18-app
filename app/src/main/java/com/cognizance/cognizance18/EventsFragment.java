package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cognizance.cognizance18.fragments.EventsContentFragment;

public class EventsFragment extends Fragment {

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
        centerstageTab = view.findViewById(R.id.centerstage_tab);
        departmentalTab = view.findViewById(R.id.departmental_tab);
    }

    private void setupViews() {
        centerstageTab.setOnClickListener(
                (v) -> {
                    v.setSelected(true);
                    centerstageTab.setTextColor(getResources().getColor(R.color.white));
                    departmentalTab.setSelected(false);
                    departmentalTab.setTextColor(getResources().getColor(R.color.dark_gray));
                    selectedEventFragment = EventsContentFragment.newInstance("Centerstage");
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.events_content_fragment, selectedEventFragment);
                    transaction.commit();
                }
        );
        departmentalTab.setOnClickListener(
                (v) -> {
                    v.setSelected(true);
                    departmentalTab.setTextColor(getResources().getColor(R.color.white));
                    centerstageTab.setSelected(false);
                    centerstageTab.setTextColor(getResources().getColor(R.color.dark_gray));
                    selectedEventFragment = EventsContentFragment.newInstance("Departmental");
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.events_content_fragment, selectedEventFragment);
                    transaction.commit();
                }
        );
    }
}
