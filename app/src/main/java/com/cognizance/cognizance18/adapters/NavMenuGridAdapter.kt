package com.cognizance.cognizance18.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.models.Category


/**
 * Created by rohan on 18/1/18.
 * Modified by rohit on 9/2/18.
 */
//class NavMenuGridAdapter(val menuItems: List<NavMenuGridItem>, val rowHeight: Int = 0) : BaseAdapter() {
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val row = LayoutInflater.from(parent.context).inflate(R.layout.item_nav_menu, parent, false)
//        /*val lp = AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, rowHeight)
//        row.layoutParams = lp*/
//
//        Log.d("$this", "pos : $position, text : ${menuItems[position].text}")
//        row.item_text.text = menuItems[position].text
//
//        menuItems[position].imageResource?.let {
//            row.ic_item.setImageDrawable(ContextCompat.getDrawable(parent.context, it))
//        }
//        return row
//    }
//
//    override fun getItem(position: Int) = menuItems[position]
//
//    override fun getItemId(position: Int) = position.toLong()
//
//    override fun getCount() = menuItems.size
//
//}
class NavMenuGridAdapter(val ctx: Context, val categories: List<Category>, val itemClick: (Category) -> Unit) : RecyclerView.Adapter<NavMenuGridAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.category_list_item, null, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindCategory(categories[position], ctx)
    }

    inner class Holder(itemView: View?, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView?.findViewById<ImageView>(R.id.profileImage)
        val categoryTxt = itemView?.findViewById<TextView>(R.id.profileTxt)

        fun bindCategory(category: Category, ctx: Context) {
            val resId = ctx.resources.getIdentifier(category.image, "drawable", ctx.packageName)
            categoryImage?.setImageResource(resId)
            categoryTxt?.text = category.title
            itemView.setOnClickListener { itemClick(category) }
        }
    }
}