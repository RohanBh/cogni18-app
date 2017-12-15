package com.cognizance.cognizance18.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.models.Event;

import java.util.ArrayList;

/**
 * Created by arihant on 12/12/17.
 */

public class CarouselRViewAdapter extends RecyclerView.Adapter<CarouselRViewAdapter.EventRHolder> {

    private Context ctx;
    private ArrayList<Event> list;

    public CarouselRViewAdapter(Context ctx, ArrayList<Event> list){
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public EventRHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_spot_light, parent, false);
        return new EventRHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(EventRHolder holder, int position) {
        holder.title.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.isEmpty()?0:list.size();
    }

    class EventRHolder extends RecyclerView.ViewHolder{
        TextView title;
        public EventRHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title_text);
        }
    }
}
