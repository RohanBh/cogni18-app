package com.cognizance.cognizance18.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.models.WorkshopModels.WorkshopResponse;

import java.util.List;

/**
 * Created by shashank on 14/2/18.
 */

public class WorkshopsAdapter extends RecyclerView.Adapter<WorkshopsAdapter.WorkshopsViewHolder> {


    private Context mcontext;

    private List<WorkshopResponse> workshopList;



    public WorkshopsAdapter(Context context, List<WorkshopResponse> WorkshopList){
        this.mcontext =context;
        this.workshopList= WorkshopList;


    }



    @Override
    public WorkshopsAdapter.WorkshopsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.workshop_row, parent, false);
        return new WorkshopsAdapter.WorkshopsViewHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(WorkshopsAdapter.WorkshopsViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 0;
    }



    class WorkshopsViewHolder extends RecyclerView.ViewHolder {



        public WorkshopsViewHolder(View itemView) {
            super(itemView);
            
        }
    }
}
