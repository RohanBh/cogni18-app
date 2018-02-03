package com.cognizance.cognizance18.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.database.EventPreview;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class EventsRViewAdapter extends RecyclerView.Adapter<EventsRViewAdapter.EventRViewHolder> {

    private AbstractList<EventPreview> list;

    private OnEventCLickListener mListener;

    public EventsRViewAdapter(AbstractList<EventPreview> eventList, Context ctx) {
        this.list = eventList;
        this.mListener = (OnEventCLickListener) ctx;
    }

    @Override
    public EventRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_carousels, parent, false);
        return new EventRViewHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(EventRViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(v -> {
            if(mListener!=null){
                mListener.click(list.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    class EventRViewHolder extends RecyclerView.ViewHolder {

        TextView name, category;

        EventRViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.event_title_text_view);
            category = itemView.findViewById(R.id.chip1);
        }
    }

    private interface OnEventCLickListener{
        void click(int eventID);
    }
}
