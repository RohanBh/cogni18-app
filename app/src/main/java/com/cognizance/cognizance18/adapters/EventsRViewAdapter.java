package com.cognizance.cognizance18.adapters;

import android.content.Context;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cognizance.cognizance18.EventDetails;
import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.database.EventPreview;

import com.cognizance.cognizance18.models.EventDetails.EventDescription;
import com.cognizance.cognizance18.models.Events;
import com.cognizance.cognizance18.utilities.ApiUtils;
import com.squareup.picasso.Picasso;

import com.cognizance.cognizance18.MainActivity;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EventsRViewAdapter extends RecyclerView.Adapter<EventsRViewAdapter.EventRViewHolder> {

    private List<Events> list;

    private Context context;

    private int PRIVATE_MODE = 0;
   private EventDescription description;


   public String b;
   public String c;
   public String d;

    private static final String PREF_NAME = "LoginPref";


    public EventsRViewAdapter(List<Events> eventList,Context context) {
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
        Events event = list.get(position);
        holder.name.setText(event.getName());
        Picasso.with(context).load(event.getThumbnail()).into(holder.eventimage);

        holder.eventimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context ct=holder.eventimage.getContext();
                int a= list.get(position).getId();
                Intent intent=new Intent(ct,EventDetails.class);
                SharedPreferences shared = ct.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putInt("id",a);
                editor.apply();

                ct.startActivity(intent);
            }
        });

       
        

    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    class EventRViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        ImageView eventimage;


        EventRViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.event_title_text_view);
            eventimage = itemView.findViewById(R.id.event_image);
            
        }
    }
}
