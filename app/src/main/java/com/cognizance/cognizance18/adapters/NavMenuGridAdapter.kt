package com.cognizance.cognizance18.adapters

import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.models.NavMenuGridItem
import kotlinx.android.synthetic.main.item_nav_menu.view.*


/**
 * Created by rohan on 18/1/18.
 */
class NavMenuGridAdapter(val menuItems: List<NavMenuGridItem>, val rowHeight: Int = 0) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.item_nav_menu, parent, false)
        /*val lp = AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, rowHeight)
        row.layoutParams = lp*/

        Log.d("$this", "pos : $position, text : ${menuItems[position].text}")
        row.item_text.text = menuItems[position].text

        menuItems[position].imageResource?.let {
            row.ic_item.setImageDrawable(ContextCompat.getDrawable(parent.context, it))
        }
        return row
    }

    override fun getItem(position: Int) = menuItems[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = menuItems.size

}
