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
import com.cognizance.cognizance18.database.CategoryList;
import com.cognizance.cognizance18.database.CentralList;
import com.cognizance.cognizance18.utilities.ApiUtils;

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
        Call<CentralList> call = ApiUtils.getInterfaceService().requestEvents(session.getToken());
        call.enqueue(new Callback<CentralList>() {
            @Override
            public void onResponse(Call<CentralList> call, Response<CentralList> response) {
                if (response.isSuccessful()) {
                    realm.executeTransaction(
                            realm -> {
                                if (response.body() != null) {
                                    realm.copyToRealmOrUpdate(response.body());
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
            public void onFailure(Call<CentralList> call, Throwable t) {
                Toast.makeText(getActivity(), "Failed to fetch data: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.sub_events_r_view);
    }

    private void setupViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CentralList centralList = realm.where(CentralList.class).findFirst();
        if (centralList != null) {
            List<CategoryList> centralCategories = centralList.getCentralStage();
            List<CategoryList> departmentalCategories = centralList.getDepartmental();
            if (categoryName.equals(getString(R.string.centerstage_string))
                    && centralCategories != null && !centralCategories.isEmpty()) {
                recyclerView.setAdapter(new SubEventsRViewAdapter(getContext(), centralCategories));
            } else if (categoryName.equals(getString(R.string.departmental_string))
                    && departmentalCategories != null && !departmentalCategories.isEmpty()) {
                recyclerView.setAdapter(new SubEventsRViewAdapter(getContext(), departmentalCategories));
            } else {
                // Nothing to show
            }
        }
    }
}
