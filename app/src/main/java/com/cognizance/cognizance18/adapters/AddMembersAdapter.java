package com.cognizance.cognizance18.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.models.UserDetails;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by me on 10/2/18.
 */

public class AddMembersAdapter extends RecyclerView.Adapter<AddMembersAdapter.ViewHolder> {

    Context ctx;
    List<UserDetails> userDetailsList;

    public AddMembersAdapter(Context ctx, List<UserDetails> userDetailsList) {
        this.ctx = ctx;
        this.userDetailsList = userDetailsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(ctx).inflate(R.layout.member_display,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserDetails userDetails = userDetailsList.get(position);

        holder.name.setText(userDetails.getName());
        holder.cogniId.setText(userDetails.getCogniId());
        if (!userDetails.getImageUrl().isEmpty()){
            Picasso.with(ctx).load(userDetails.getImageUrl()).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView,cross;
        private TextView cogniId, name;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.dotcard);
            cogniId = itemView.findViewById(R.id.cogniIdcard);
            name = itemView.findViewById(R.id.contestentcard);
            cross = itemView.findViewById(R.id.crosscard);
            cross.setOnClickListener(v -> delete());
        }
        public void crossbtn(){
            cross.setVisibility(View.VISIBLE);
        }
        public void delete(){

        }
    }
}
