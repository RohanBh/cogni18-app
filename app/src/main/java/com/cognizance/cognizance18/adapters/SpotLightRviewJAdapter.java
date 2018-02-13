package com.cognizance.cognizance18.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.models.SpotlightCard;

import java.util.List;

/**
 * Created by me on 12/2/18.
 */

public class SpotLightRviewJAdapter extends RecyclerView.Adapter<SpotLightRviewJAdapter.ViewHolder> {

    Context ctx;
    List<SpotlightCard> spotlightCardList;

    public SpotLightRviewJAdapter(Context ctx, List<SpotlightCard> spotlightCardList) {
        this.ctx = ctx;
        this.spotlightCardList = spotlightCardList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_spotlight, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SpotlightCard spotlightCard = spotlightCardList.get(position);
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
            imageView = itemView.findViewById(R.id.spot_image_view);
            textView = itemView.findViewById(R.id.spot_text_view);
        }
    }
}
