package com.cognizance.cognizance18.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cognizance.cognizance18.EventDetails;
import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.database.EventPreview;
import com.cognizance.cognizance18.MainActivity;

import java.util.List;


public class EventsRViewAdapter extends RecyclerView.Adapter<EventsRViewAdapter.EventRViewHolder> {

    private List<EventPreview> list;

    public EventsRViewAdapter(List<EventPreview> eventList) {
        this.list = eventList;
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
        holder.imageView.setOnClickListener(v -> {
            Context ctx = holder.imageView.getContext();
            Intent intent = new Intent(ctx, EventDetails.class);
            ctx.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    class EventRViewHolder extends RecyclerView.ViewHolder {

        TextView name, category;
        ImageView imageView;

        EventRViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.event_title_text_view);
            category = itemView.findViewById(R.id.chip1);
            imageView = itemView.findViewById(R.id.event_image);
        }
    }
}
