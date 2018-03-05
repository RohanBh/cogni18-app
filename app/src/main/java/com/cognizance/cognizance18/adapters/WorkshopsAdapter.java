package com.cognizance.cognizance18.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.models.WorkshopModels.Workshops;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shashank on 14/2/18.
 */

public class WorkshopsAdapter extends RecyclerView.Adapter<WorkshopsAdapter.WorkshopsViewHolder> {

    private Context mcontext;
    private List<Workshops> workshopList;

    public WorkshopsAdapter(Context context, List<Workshops> WorkshopList) {
        this.mcontext = context;
        this.workshopList = WorkshopList;
    }

    @Override
    public WorkshopsAdapter.WorkshopsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.workshop_row, parent, false);
        return new WorkshopsAdapter.WorkshopsViewHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(WorkshopsAdapter.WorkshopsViewHolder holder, int position) {


        holder.Wspname.setText(workshopList.get(position).getName());

        String url = workshopList.get(position).getThumbnail();

        if (url != null)
            Picasso.with(mcontext).load(url).placeholder(R.drawable.button_background)
                    .into(holder.Wspimage);

        else {
            holder.Wspimage.setImageResource(R.drawable.button_background);
        }
    }

    @Override
    public int getItemCount() {
        return workshopList.size();
    }

    class WorkshopsViewHolder extends RecyclerView.ViewHolder {

        TextView Wspname;
        ImageView Wspimage;

        public WorkshopsViewHolder(View itemView) {
            super(itemView);
            Wspimage = itemView.findViewById(R.id.event_image);
            Wspname = itemView.findViewById(R.id.event_title_text_view);
        }
    }
}
