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
import com.cognizance.cognizance18.Services.DataServices;
import com.cognizance.cognizance18.SessionManager;
import com.cognizance.cognizance18.adapters.EventsRViewAdapter;
import com.cognizance.cognizance18.adapters.ExhibitionsRViewAdapter;
import com.cognizance.cognizance18.adapters.GSRViewAdapter;
import com.cognizance.cognizance18.adapters.SpotLightRVIewAdapterj;
import com.cognizance.cognizance18.adapters.SpotLightRviewJAdapter;
import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener;
import com.cognizance.cognizance18.models.SpotlightCard;
import com.cognizance.cognizance18.models.TrendingList;
import com.cognizance.cognizance18.utilities.ApiUtils;

import java.util.ArrayList;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private OnFragmentAddedListener mListener;

    private RecyclerView spotLightsRecyclerView;
    private RecyclerView eventsRecyclerView;
    private RecyclerView exhibitionsRecyclerView;
    private RecyclerView techtainmentRView;
    private RecyclerView speakersRView;
    private RecyclerView panelDiscussion1, panelDiscussion2;

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
        exhibitionsRecyclerView = view.findViewById(R.id.exhibitions_recycler_view);
        techtainmentRView = view.findViewById(R.id.techtainment_2017_r_view);
        speakersRView = view.findViewById(R.id.speakers_2017_r_view);
        panelDiscussion1 = view.findViewById(R.id.panel_discussion1);
        panelDiscussion2 = view.findViewById(R.id.panel_discussion2);
    }

    private void setupViews() {

        //techtainment
        spotLightsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.HORIZONTAL, false));
        spotLightsRecyclerView.setAdapter(new SpotLightRVIewAdapterj(getContext(), DataServices.INSTANCE.getTechtainments()));

        //exhibitions
        exhibitionsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.HORIZONTAL, false));
        exhibitionsRecyclerView.setAdapter(new ExhibitionsRViewAdapter(getContext(), DataServices.INSTANCE.getExhibitions()));

        //Guest Speakers
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.HORIZONTAL, false));
        eventsRecyclerView.setAdapter(new GSRViewAdapter(getContext(), DataServices.INSTANCE.getGuestSpeakers()));

        //Panel Discussion 1
        panelDiscussion1.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.HORIZONTAL, false ));
        panelDiscussion1.setAdapter(new GSRViewAdapter(getContext(), DataServices.INSTANCE.getPaneldiscussion1()));

        //Panel Discussion 2
        panelDiscussion2.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.HORIZONTAL,false));
        panelDiscussion2.setAdapter(new GSRViewAdapter(getContext(), DataServices.INSTANCE.getPaneldiscussion2()));

        //2017 speakers
        ArrayList<SpotlightCard> speakersList = new ArrayList<>();
        speakersList.add(new SpotlightCard(R.drawable.gsatheesh, "G.Satheesh Reddy"));
        speakersList.add(new SpotlightCard(R.drawable.ashok, "Ashok Soota"));
        speakersList.add(new SpotlightCard(R.drawable.anil, "Anil Kumar"));

        //2017 techtainment
        ArrayList<SpotlightCard> techsList = new ArrayList<>();
        techsList.add(new SpotlightCard(R.drawable.tvf, "The Viral Fever"));
        techsList.add(new SpotlightCard(R.drawable.sachinjigar, "Sachin-Jigar"));
        techsList.add(new SpotlightCard(R.drawable.papon, "Papon"));

        // guestSpeakers recycler view
        techtainmentRView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        techtainmentRView.setAdapter(new SpotLightRviewJAdapter(getContext(), techsList));

        // speakers recycler view
        speakersRView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        speakersRView.setAdapter(new SpotLightRviewJAdapter(getContext(), speakersList));
    }

    private void setListeners() {

    }
}
