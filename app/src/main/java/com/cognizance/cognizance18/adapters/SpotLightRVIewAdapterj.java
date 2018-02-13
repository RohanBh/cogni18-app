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

import java.util.List;

/**
 * Created by Narendra on 11/2/18.
 */

public class SpotLightRVIewAdapterj extends RecyclerView.Adapter<SpotLightRVIewAdapterj.ViewHolder> {

    Context ctx;
    List<SpotLightCard> spotLightCardList;

    public SpotLightRVIewAdapterj(Context ctx, List<SpotLightCard> spotLightCardList) {
        this.ctx = ctx;
        this.spotLightCardList = spotLightCardList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_spotlight,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SpotLightCard spotLightCard = spotLightCardList.get(position);
        holder.textView.setText(spotLightCard.getName());
        holder.imageView.setImageResource(spotLightCard.getImageId());
    }

    @Override
    public int getItemCount() {
        return spotLightCardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.spot_image_view);
            textView = itemView.findViewById(R.id.spot_text_view);
        }
    }
}
