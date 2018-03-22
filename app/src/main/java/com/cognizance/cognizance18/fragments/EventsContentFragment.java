package com.cognizance.cognizance18.fragments;

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
import com.cognizance.cognizance18.adapters.SubEventsRViewAdapter;
import com.cognizance.cognizance18.adapters.SubEventsRViewAdapterS;
import com.cognizance.cognizance18.database.CategoryList;
import com.cognizance.cognizance18.database.CentralList;
import com.cognizance.cognizance18.models.CentralStage;
import com.cognizance.cognizance18.models.Departmental;
import com.cognizance.cognizance18.models.Example;
import com.cognizance.cognizance18.utilities.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsContentFragment extends Fragment {

    public static final String CATEGORY_KEY = "category";

    private RecyclerView recyclerView;
    private String categoryName;
    private Realm realm;
    private SessionManager session;

    private List<Example> eventList;

    private List<CentralStage> centralStageList;

    private List<Departmental> departmentalList;



    public EventsContentFragment() {
        // Required empty public constructor
    }

    public static EventsContentFragment newInstance(String categoryName) {
        EventsContentFragment fragment = new EventsContentFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY_KEY, categoryName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryName = getArguments().getString(CATEGORY_KEY);
        }
        session = new SessionManager(getActivity());

        realm = Realm.getDefaultInstance();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events_content, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Call<Example> call = ApiUtils.getInterfaceService().requestEvents(session.getToken());
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    if (response.body().getMessage().equalsIgnoreCase("Events Fetched.")){

                        Example EventResponse=response.body();

                        if (EventResponse.getCentralStage()!=null) {

                            for (int i = 0; i < EventResponse.getCentralStage().size(); i++) {

                                centralStageList.add(EventResponse.getCentralStage().get(i));

                            }
                        }

                        if (EventResponse.getDepartmental()!=null) {
                            for (int i = 0; i < EventResponse.getDepartmental().size(); i++) {

                                departmentalList.add(EventResponse.getDepartmental().get(i));

                            }
                        }
                       setupViews();


                    }

                } else {

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.sub_events_r_view);
        centralStageList = new ArrayList<>();
        departmentalList=new ArrayList<>();
    }

    private void setupViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (categoryName.equalsIgnoreCase(getString(R.string.centerstage_string))
                && centralStageList != null && !centralStageList.isEmpty()){
            recyclerView.setAdapter(new SubEventsRViewAdapterS(getContext(), centralStageList));

            //Toast.makeText(getActivity(), "Carpe Diem ",
                 //   Toast.LENGTH_SHORT).show();
        }

            if (categoryName.equalsIgnoreCase(getString(R.string.departmental_string))
                    && departmentalList != null && !departmentalList.isEmpty()) {
                recyclerView.setAdapter(new SubEventsRViewAdapter(getContext(), departmentalList));

            }


    }
}
