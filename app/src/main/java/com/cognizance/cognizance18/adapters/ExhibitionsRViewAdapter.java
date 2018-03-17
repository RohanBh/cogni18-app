package com.cognizance.cognizance18.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.models.Events;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by narendra on 15/3/18.
 */

public class ExhibitionsRViewAdapter extends RecyclerView.Adapter<ExhibitionsRViewAdapter.ViewHolder> {

    private Context context;
    private List<Events> eventsList;

    public ExhibitionsRViewAdapter(Context context, List<Events> eventsList) {
        this.context = context;
        this.eventsList = eventsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_carousels, parent, false);
        return new ViewHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Events event = eventsList.get(position);
        holder.name.setText(event.getName());
        Picasso.with(context).load(event.getThumbnail()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.event_image);
            name = itemView.findViewById(R.id.item_carousel_name);

        }
    }
}
