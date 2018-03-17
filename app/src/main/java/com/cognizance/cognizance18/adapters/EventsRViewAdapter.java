package com.cognizance.cognizance18.adapters;

import android.content.Context;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cognizance.cognizance18.EventDetails;
import com.cognizance.cognizance18.R;

import com.cognizance.cognizance18.models.Events;
import com.squareup.picasso.Picasso;


import java.util.List;


public class EventsRViewAdapter extends RecyclerView.Adapter<EventsRViewAdapter.EventRViewHolder> {

    private List<Events> list;

    private Context context;


    public EventsRViewAdapter(List<Events> eventList,Context context) {
        this.list = eventList;
        this.context=context;

    }

    @Override
    public EventRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_carousels, parent, false);
        return new EventRViewHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(EventRViewHolder holder, int position) {
        Events event = list.get(position);
        Picasso.with(context).load(event.getThumbnail()).into(holder.eventimage);

        holder.eventimage.setOnClickListener(view -> {
            Context ct=holder.eventimage.getContext();
            Intent intent=new Intent(ct,EventDetails.class);
            ct.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    class EventRViewHolder extends RecyclerView.ViewHolder {

        ImageView eventimage;

        EventRViewHolder(View itemView) {
            super(itemView);
            eventimage = itemView.findViewById(R.id.event_image);
            
        }
    }
}
