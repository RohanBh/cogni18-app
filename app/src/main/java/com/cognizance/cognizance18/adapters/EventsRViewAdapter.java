package com.cognizance.cognizance18.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.models.Event;

import java.util.ArrayList;

public class EventsRViewAdapter extends RecyclerView.Adapter<EventsRViewAdapter.EventRViewHolder>{

    private ArrayList<Event> list;

    EventsRViewAdapter(ArrayList<Event> eventList) {
        this.list = eventList;
    }

    @Override
    public EventRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_event, parent, false);
        return new EventRViewHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(EventRViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.isEmpty()?0:list.size();
    }

    class EventRViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        EventRViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.event_name_text);
        }
    }
}
