package com.cognizance.cognizance18.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.database.CategoryList;
import com.cognizance.cognizance18.models.CentralStage;

import java.util.List;

/**
 * Created by shashank on 9/3/18.
 */

public class SubEventsRViewAdapterS extends RecyclerView.Adapter<SubEventsRViewAdapterS.RViewHolder> {



    private final RecyclerView.RecycledViewPool viewPool;
    private Context ctx;
    private List<CentralStage> list;

    public SubEventsRViewAdapterS(Context ctx, List<CentralStage> list){
        viewPool = new RecyclerView.RecycledViewPool();
        this.ctx = ctx;
        this.list = list;
    }


    @Override
    public SubEventsRViewAdapterS.RViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_sub_events, parent, false);
        return new RViewHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(SubEventsRViewAdapterS.RViewHolder holder, int position) {

        holder.rView.setRecycledViewPool(viewPool);
        holder.category.setText(list.get(position).getName());
        holder.rView.setLayoutManager(new LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false));
        holder.rView.setAdapter(new EventsRViewAdapter(list.get(position).getEvents(),ctx));

    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    class RViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rView;
        TextView category;

        private RViewHolder(View itemView) {
            super(itemView);
            rView = itemView.findViewById(R.id.event_list__r_view);
            category = itemView.findViewById(R.id.sub_cat_text);
        }
    }

}
