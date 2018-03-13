package com.cognizance.cognizance18.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cognizance.cognizance18.R;

import java.util.ArrayList;

/**
 * Created by rohit on 13/3/18.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.Holder> {

    private ArrayList<String[]> scheduleList;

    public class Holder extends RecyclerView.ViewHolder {
        public TextView title, time, location;

        public Holder(View view) {
            super(view);
            title = view.findViewById(R.id.tV);
            time = view.findViewById(R.id.time);
            location = view.findViewById(R.id.location);
        }

        public void bindingFunc(String[] txtArr) {
            title.setText(txtArr[0]);
            time.setText(txtArr[1]);
            location.setText(txtArr[2]);
        }
    }

    public ScheduleAdapter(ArrayList<String[]> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_item, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bindingFunc(scheduleList.get(position));
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }
}