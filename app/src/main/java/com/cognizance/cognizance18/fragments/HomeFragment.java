package com.cognizance.cognizance18.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.SessionManager;
import com.cognizance.cognizance18.adapters.SpotLightRViewAdapter;
import com.cognizance.cognizance18.adapters.TrendingRViewAdapter;
import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener;
import com.cognizance.cognizance18.models.SpotLight;
import com.cognizance.cognizance18.models.TrendingList;
import com.cognizance.cognizance18.models.Trendings;
import com.cognizance.cognizance18.utilities.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private OnFragmentAddedListener mListener;

    private RecyclerView spotLightsRecyclerView;
    private RecyclerView eventsRecyclerView;
    private RecyclerView workshopsRecyclerView;
    private RecyclerView techtainmentRView;
    private RecyclerView speakersRView;

    private Realm realm;
    private SessionManager session;

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
        realm = Realm.getDefaultInstance();
        session = new SessionManager(context);
        session.checkLogin();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        setupViews();
        setListeners();
        mListener.onFragmentAdd(2);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Call<TrendingList> call = ApiUtils.getInterfaceService().getTrendings(session.getToken());
        call.enqueue(
                new Callback<TrendingList>() {
                    @Override
                    public void onResponse(@NonNull Call<TrendingList> call,
                                           @NonNull Response<TrendingList> response) {
                        if (response.isSuccessful()) {
                            realm.executeTransaction(
                                    realm -> {
                                        if (response.body() != null &&
                                                response.body().getEvents() != null) {
                                            realm.copyToRealmOrUpdate(response.body().getEvents());
                                        }
                                        setupViews();
                                    }
                            );
                        } else {
                            Toast.makeText(getActivity(), "Error : " + response.toString(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<TrendingList> call, Throwable t) {
                        Toast.makeText(getActivity(), "Failed to fetch data: " + t.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void initViews(View view) {
        spotLightsRecyclerView = view.findViewById(R.id.spot_light_recycler_view);
        eventsRecyclerView = view.findViewById(R.id.events_recycler_view);
        workshopsRecyclerView = view.findViewById(R.id.workshops_recycler_view);
        techtainmentRView = view.findViewById(R.id.techtainment_2017_r_view);
        speakersRView = view.findViewById(R.id.speakers_2017_r_view);
    }

    private void setupViews() {

        List<Trendings> spotlightList = realm.where(Trendings.class)
                .equalTo("type", "spotlight").findAll();
        List<Trendings> workshopList = realm.where(Trendings.class)
                .equalTo("type", "workshop").findAll();
        List<Trendings> eventList = realm.where(Trendings.class)
                .equalTo("type", "spotlight").findAll();
        if (spotlightList != null) {
            spotLightsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                    , LinearLayoutManager.HORIZONTAL, false));
            spotLightsRecyclerView.setAdapter(new TrendingRViewAdapter(spotlightList));
        }
        if (workshopList != null) {
            workshopsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                    , LinearLayoutManager.HORIZONTAL, false));
            workshopsRecyclerView.setAdapter(new TrendingRViewAdapter(workshopList));
        }
        if (eventList != null) {
            eventsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                    , LinearLayoutManager.HORIZONTAL, false));
            eventsRecyclerView.setAdapter(new TrendingRViewAdapter(eventList));
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
