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
import android.widget.Toast;

import com.cognizance.cognizance18.R;
import com.cognizance.cognizance18.Services.DetailWorkshop;
import com.cognizance.cognizance18.WorkshopDetails;
import com.cognizance.cognizance18.models.WorkshopModels.Workshops;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shashank on 14/2/18.
 */

public class WorkshopsAdapter extends RecyclerView.Adapter<WorkshopsAdapter.WorkshopsViewHolder> {

    private Context mcontext;
    private List<Workshops> workshopList;

    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "LoginPref";

    public WorkshopsAdapter(Context context, List<Workshops> WorkshopList) {
        this.mcontext = context;
        this.workshopList = WorkshopList;
    }

    @Override
    public WorkshopsAdapter.WorkshopsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_carousels, parent, false);
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

        holder.Wspimage.setOnClickListener(v -> {
            Context ct = v.getContext();

            SharedPreferences shared = ct.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
            SharedPreferences.Editor editor = shared.edit();

            int id = workshopList.get(position).getId();

            editor.putInt("id",id);
            editor.apply();


            Intent intent = new Intent(ct, WorkshopDetails.class);

            switch (id ){
                case 83:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(0));
                    break;
                case 12:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(1));
                    break;
                case 16:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(2));
                    break;
                case 28:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(3));
                    break;
                case 68:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(4));
                    break;
                case 103:intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(5));
                    break;
                case 14:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(6));
                    break;
                case 20:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(7));
                    break;
                case 21:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(8));
                    break;
                case 22:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(9));
                    break;
                case 90:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(10));
                    break;
                case 24:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(11));
                    break;
                case 19:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(12));
                    break;
                case 25:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(13));
                    break;
                case 23:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(14));
                    break;
                case 18:
                    intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(15));
                    break;
                case 27:intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(16));
                    break;
                case 133:intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(17));
                    break;
                default:
                    Toast.makeText(mcontext,"invalid",Toast.LENGTH_SHORT).show();

            }
           // intent.putExtra("obj", DetailWorkshop.INSTANCE.getWorkshops().get(position));

            ct.startActivity(intent);
        });


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
            Wspname = itemView.findViewById(R.id.item_carousel_name);
        }
    }
}
