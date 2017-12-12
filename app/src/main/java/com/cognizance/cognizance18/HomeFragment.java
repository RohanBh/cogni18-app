package com.cognizance.cognizance18;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognizance.cognizance18.adapters.EventsRViewAdapter;
import com.cognizance.cognizance18.models.Event;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private RecyclerView spotLightsRecyclerView, eventsRecyclerView, workshopsRecyclerView;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        setupViews();
        initListeners();
        return view;
    }
    private void initViews(View view) {
        spotLightsRecyclerView = view.findViewById(R.id.spot_light_recycler_view);
        eventsRecyclerView = view.findViewById(R.id.events_recycler_view);
        workshopsRecyclerView = view.findViewById(R.id.workshops_recycler_view);
    }

    private void setupViews() {
        ArrayList<Event> eventsList;
        eventsList = new ArrayList<>();
        for(int i=0;i<10;i++){
            Event event = new Event();
            event.setTitle("Event" + (i+1));
            eventsList.add(event);
        }
        spotLightsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                ,LinearLayoutManager.HORIZONTAL,false));
        spotLightsRecyclerView.setAdapter(new EventsRViewAdapter(getContext(),eventsList));

        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                ,LinearLayoutManager.HORIZONTAL,false));
        eventsRecyclerView.setAdapter(new EventsRViewAdapter(getContext(),eventsList));

        workshopsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                ,LinearLayoutManager.HORIZONTAL,false));
        workshopsRecyclerView.setAdapter(new EventsRViewAdapter(getContext(),eventsList));
    }

    private void initListeners() {

    }
}
