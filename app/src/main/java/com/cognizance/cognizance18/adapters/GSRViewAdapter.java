package com.cognizance.cognizance18.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cognizance.cognizance18.HelperClass.CircleImageView;
import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.SpeakerDetails;
import com.cognizance.cognizance18.models.GuestSpeakers;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by narendra on 14/3/18.
 */

public class GSRViewAdapter extends RecyclerView.Adapter<GSRViewAdapter.ViewHolder> {

    private Context ctx;
    private List<GuestSpeakers> guestSpeakersList;

    public GSRViewAdapter(Context ctx, List<GuestSpeakers> guestSpeakersList) {
        this.ctx = ctx;
        this.guestSpeakersList = guestSpeakersList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_spotlight, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GuestSpeakers guestSpeakers = guestSpeakersList.get(position);
        holder.textView.setText(guestSpeakers.getName());
        if (guestSpeakers.getImageid() == 0)
            Picasso.with(ctx).load(guestSpeakers.getImageUrl()).transform(new CircleImageView()).into(holder.imageView);
        else {
            holder.imageView.setImageResource(guestSpeakers.getImageid());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(dptopx(20));
            holder.imageView.setBackground(gradientDrawable);
        }
        holder.imageView.setOnClickListener(v -> {
            Context ct = holder.imageView.getContext();
            Intent intent = new Intent(ct, SpeakerDetails.class);
            intent.putExtra("obj", guestSpeakers);
            ct.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return guestSpeakersList.size();
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

    private float dptopx(float dp){
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return dp*displayMetrics.densityDpi/160f;
    }
}
