package com.cognizance.cognizance18.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.SessionManager;
import com.cognizance.cognizance18.adapters.WorkshopsAdapter;
import com.cognizance.cognizance18.interfaces.OnFragmentAddedListener;
import com.cognizance.cognizance18.models.TrendingList;
import com.cognizance.cognizance18.models.Workshop;
import com.cognizance.cognizance18.models.WorkshopModels.WorkshopResponse;
import com.cognizance.cognizance18.models.WorkshopModels.Workshops;
import com.cognizance.cognizance18.utilities.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shashank on 13/2/18.
 */

public class WorkshopFragment extends android.support.v4.app.Fragment {


    private RecyclerView recyclerView;
    private OnFragmentAddedListener mListener;
    private SessionManager session;
    private List<Workshops> workshopList;
    private WorkshopsAdapter workshopsAdapter;


    public static WorkshopFragment newInstance() {
        WorkshopFragment fragment = new WorkshopFragment();
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        return inflater.inflate(R.layout.fragment_workshops, container, false);
    }


    public void InitializeViews(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.workshop);

    }


    public void getWorkshopList() {

        Call<WorkshopResponse> call = ApiUtils.getInterfaceService().getWorkshopList(session.getToken());
        call.enqueue(new Callback<WorkshopResponse>() {
            @Override
            public void onResponse(Call<WorkshopResponse> call, Response<WorkshopResponse> response) {

                WorkshopResponse workshopResponse = response.body();
                if (response.isSuccessful()) {
                    workshopList.clear();
                    for (int i = 0; i < workshopResponse.getWorkshops().size(); i++) {
                        Workshops workshops = workshopResponse.getWorkshops().get(i);
                        workshopList.add(workshops);
                    }


                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10),true));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter();
                }
            }

            @Override
            public void onFailure(Call<WorkshopResponse> call, Throwable t) {

            }
        });
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
