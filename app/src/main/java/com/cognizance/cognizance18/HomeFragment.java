package com.cognizance.cognizance18;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognizance.cognizance18.adapters.CarouselRViewAdapter;
import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener;
import com.cognizance.cognizance18.models.Event;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private OnFragmentAddedListener mListener;

    private RecyclerView spotLightsRecyclerView;
    private RecyclerView eventsRecyclerView;
    private RecyclerView workshopsRecyclerView;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
    }

    private void setupViews() {
        ArrayList<Event> eventsList;
        eventsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Event event = new Event();
            event.setName("Event" + (i + 1));
            eventsList.add(event);
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
    }

    private void setListeners() {

    }
}
