package com.cognizance.cognizance18.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.adapters.CarouselRViewAdapter;
import com.cognizance.cognizance18.adapters.SpotLightRViewAdapter;
import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener;
import com.cognizance.cognizance18.models.Event;
import com.cognizance.cognizance18.models.SpotLight;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private OnFragmentAddedListener mListener;

    private RecyclerView spotLightsRecyclerView;
    private RecyclerView eventsRecyclerView;
    private RecyclerView workshopsRecyclerView;
    private RecyclerView techtainmentRView;
    private RecyclerView speakersRView;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentAddedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnFragmentAddedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        setupViews();
        setListeners();
        mListener.onFragmentAdd(2);
        return view;
    }

    private void initViews(View view) {
        spotLightsRecyclerView = view.findViewById(R.id.spot_light_recycler_view);
        eventsRecyclerView = view.findViewById(R.id.events_recycler_view);
        workshopsRecyclerView = view.findViewById(R.id.workshops_recycler_view);
        techtainmentRView = view.findViewById(R.id.techtainment_2017_r_view);
        speakersRView = view.findViewById(R.id.speakers_2017_r_view);
    }

    private void setupViews() {

        // fake list for events, workshops and spotlights
        ArrayList<Event> eventsList;
        eventsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Event event = new Event();
            event.setName("Event" + (i + 1));
            eventsList.add(event);
        }

        // fake list for guest speakers 2017

        ArrayList<SpotLight> speakersList;
        speakersList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SpotLight spotLight = new SpotLight("G S Name");
            speakersList.add(spotLight);
        }

        // fake list for guest techtainments 2017

        ArrayList<SpotLight> techsList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SpotLight spotLight = new SpotLight("Tech Name");
            techsList.add(spotLight);
        }

        spotLightsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.HORIZONTAL, false));
        spotLightsRecyclerView.setAdapter(new CarouselRViewAdapter(getContext(), eventsList));

        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.HORIZONTAL, false));
        eventsRecyclerView.setAdapter(new CarouselRViewAdapter(getContext(), eventsList));

        workshopsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.HORIZONTAL, false));
        workshopsRecyclerView.setAdapter(new CarouselRViewAdapter(getContext(), eventsList));

        // techtainment recycler view
        techtainmentRView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        techtainmentRView.setAdapter(new SpotLightRViewAdapter(techsList));

        // speakers recycler view
        speakersRView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        speakersRView.setAdapter(new SpotLightRViewAdapter(speakersList));
    }

    private void setListeners() {

    }
}
