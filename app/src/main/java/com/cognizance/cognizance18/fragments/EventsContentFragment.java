package com.cognizance.cognizance18.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.adapters.SubEventsRViewAdapter;
import com.cognizance.cognizance18.models.Event;
import com.cognizance.cognizance18.models.EventCategory;

import java.util.ArrayList;

public class EventsContentFragment extends Fragment {

    private RecyclerView recyclerView;
    private String categoryName;

    public EventsContentFragment() {
        // Required empty public constructor
    }

    public static EventsContentFragment newInstance(String categoryName) {
        EventsContentFragment fragment = new EventsContentFragment();
        Bundle args = new Bundle();
        args.putString("category", categoryName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryName = getArguments().getString("category");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events_content, container, false);
        initViews(view);
        setupViews();
        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.sub_events_r_view);
    }

    private void setupViews() {
        ArrayList<EventCategory> list;
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Event> eventList;
            eventList = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                Event event = new Event();
                event.setName("Event Name " + (j + 1));
                eventList.add(event);
            }
            EventCategory eventCategory = new EventCategory();
            eventCategory.setName(categoryName + " Category " + (i + 1));
            eventCategory.setEventList(eventList);
            list.add(eventCategory);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new SubEventsRViewAdapter(getContext(), list));
    }
}
