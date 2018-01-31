package com.cognizance.cognizance18.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cognizance.cognizance18.R
import kotlinx.android.synthetic.main.item_workshop.view.*

/**
 * Created by rohan on 23/12/17.
 */
class WorkshopsRViewAdapter(
        //val eventList: List<Event>
) : RecyclerView.Adapter<WorkshopsRViewAdapter.WorkshopItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkshopItemHolder {
        return WorkshopItemHolder(LayoutInflater.from(parent.context).
                inflate(R.layout.item_workshop, parent, false))
    }

    override fun onBindViewHolder(holder: WorkshopItemHolder, position: Int) {
        //val event = eventList[position]
        /*holder.eventTitleText.text = event.name
        holder.eventDescriptionText.text = event.description*/
        //holder.eventDateText.text = event.date
    }

    override fun getItemCount() = 0

    class WorkshopItemHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        val eventTitleText = view.event_title
        val eventDescriptionText = view.event_description
        val eventDateText = view.event_date
        val eventDetailsButton = view.details_button

        // initializer code
        init {
            eventDetailsButton.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            // TODO
        }
    }

}
