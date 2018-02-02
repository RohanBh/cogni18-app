package com.cognizance.cognizance18.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.models.Trendings
import kotlinx.android.synthetic.main.item_carousels.view.*

/**
 * Created by rohan on 3/2/18.
 */
class TrendingRViewAdapter(val list: List<Trendings>) : RecyclerView.Adapter<TrendingRViewAdapter.TrendingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TrendingHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_carousels, parent, false)
        return TrendingHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TrendingHolder, position: Int) {
        holder.title.text = list[position].name
        list[position].apply {
            val tagsList = tags?.split(",")
            if (tagsList != null) {
                for ((index, value) in tagsList.withIndex()) {
                    if (index > 2) break
                    holder.chip[index].text = value
                }
            }
        }
    }

    class TrendingHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val title = item.event_title_text_view
        val chip = listOf(item.chip1, item.chip2, item.chip3)
    }
}