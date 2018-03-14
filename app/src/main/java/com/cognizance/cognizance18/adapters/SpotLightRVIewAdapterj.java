package com.cognizance.cognizance18.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.models.SpotLight;
import com.cognizance.cognizance18.models.SpotLightCard;
import com.cognizance.cognizance18.models.SpotlightCard;

import java.util.List;

/**
 * Created by Narendra on 11/2/18.
 */

public class SpotLightRVIewAdapterj extends RecyclerView.Adapter<SpotLightRVIewAdapterj.ViewHolder> {

    Context ctx;
    List<SpotLightCard> spotlightCardList;

    public SpotLightRVIewAdapterj(Context ctx, List<SpotLightCard> spotlightCardList) {
        this.ctx = ctx;
        this.spotlightCardList = spotlightCardList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.workshop_row, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SpotLightCard spotlightCard = spotlightCardList.get(position);
        holder.textView.setText(spotlightCard.getName());
        holder.imageView.setImageResource(spotlightCard.getImageid());
    }

    @Override
    public int getItemCount() {
        return spotlightCardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.event_image);
            textView = itemView.findViewById(R.id.chip1);
        }
    }
}
