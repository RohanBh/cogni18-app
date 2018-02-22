package com.cognizance.cognizance18.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.database.EventPreview;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventsRViewAdapter extends RecyclerView.Adapter<EventsRViewAdapter.EventRViewHolder> {

    private List<EventPreview> list;

    private Context context;


    public EventsRViewAdapter(List<EventPreview> eventList,Context context) {
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
        holder.name.setText(list.get(position).getName());

        String url= list.get(position).getThumbnail();

        if(url!=null)

            Picasso.with(context).load(url).placeholder(R.drawable.button_background)
                    .into(holder.eventimage);
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    class EventRViewHolder extends RecyclerView.ViewHolder {

        TextView name, category;
        ImageView eventimage;


        EventRViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.event_title_text_view);
            category = itemView.findViewById(R.id.chip1);
            eventimage = itemView.findViewById(R.id.event_image);
        }
    }
}
