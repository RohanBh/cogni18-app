package com.cognizance.cognizance18.adapters;

import android.content.Context;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cognizance.cognizance18.EventDetails;
import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.SessionManager;
import com.cognizance.cognizance18.database.EventPreview;

import com.cognizance.cognizance18.models.Events;
import com.squareup.picasso.Picasso;

import com.cognizance.cognizance18.MainActivity;


import java.util.List;


public class EventsRViewAdapter extends RecyclerView.Adapter<EventsRViewAdapter.EventRViewHolder> {

    private List<Events> list;

    private Context context;

    private SharedPreferences sharedPreferences;

    private SharedPreferences.Editor editor;

    private int PRIVATE_MODE = 0;

    String USER_ID= "eventId"
;

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
        holder.name.setText(list.get(position).getName());

        String url= list.get(position).getThumbnail();


        if(url!=null) {
            Picasso.with(context).load(url).placeholder(R.drawable.button_background)
                    .into(holder.eventimage);

        }

        holder.eventimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int a=list.get(position).getId();
                Context ct=holder.eventimage.getContext();
                Intent intent=new Intent(ct,EventDetails.class);
                ct.startActivity(intent);

                sharedPreferences =  ct.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
                editor=sharedPreferences.edit();
                editor.putInt("id",a);
                editor.commit();


            }
        });

       
        

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
