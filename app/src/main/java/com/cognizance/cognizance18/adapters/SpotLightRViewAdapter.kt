package com.cognizance.cognizance18.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.models.SpotLight
import kotlinx.android.synthetic.main.item_spotlight.view.*

/**
 * Created by arihant on 19/1/18.
 */

class SpotLightRViewAdapter(
        val spotList: List<SpotLight>
) : RecyclerView.Adapter<SpotLightRViewAdapter.SpotItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotItemHolder {
        return SpotItemHolder(LayoutInflater.from(parent.context).
                inflate(R.layout.item_spotlight, parent, false))
    }

    override fun onBindViewHolder(holder: SpotItemHolder, position: Int) {
        val spot = spotList[position]
        holder.spotName.text = spot.name
        spot.imageId?.let { holder.spotImage.setImageResource(it) }
    }

    override fun getItemCount() = spotList.size

    class SpotItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        val spotName = view.spot_text_view
        val spotImage = view.spot_image_view

        // initializer code
        init {

        }
    }

}