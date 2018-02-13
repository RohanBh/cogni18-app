package com.cognizance.cognizance18

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.cognizance.cognizance18.Services.DataServices
import com.cognizance.cognizance18.adapters.NavMenuGridAdapter
import com.cognizance.cognizance18.fragments.EventsFragment
import com.cognizance.cognizance18.fragments.HomeFragment
import com.cognizance.cognizance18.fragments.SpotlightFragment
import com.cognizance.cognizance18.fragments.WorkshopsFragment
import com.cognizance.cognizance18.models.NavMenuGridItem
import kotlinx.android.synthetic.main.activity_more.*

/**
 * Created by rohan on 19/1/18.
 * Modified by rohit on 9/2/18.
 */
class MoreActivity : AppCompatActivity() {

    lateinit var adapter: NavMenuGridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)
//        nav_menu.adapter = NavMenuGridAdapter(listOf(
//                NavMenuGridItem("Home"),
//                NavMenuGridItem("Events"),
//                NavMenuGridItem("Workshop"),
//                NavMenuGridItem("Spotlights"),
//                NavMenuGridItem("Home"),
//                NavMenuGridItem("Home"),
//                NavMenuGridItem("Home")
//        ))

        adapter = NavMenuGridAdapter(this@MoreActivity, DataServices.categories) { category ->
            when (category.title) {
                "Home" -> {
                    finish()
                    startActivity(Intent(this@MoreActivity, MainActivity::class.java))
                }
                "Events" -> {
                    finish()
                    startActivity(Intent(this@MoreActivity, MainActivity::class.java))
                }
                "Workshop" -> {
                    finish()
                    startActivity(Intent(this@MoreActivity, MainActivity::class.java))
                }
                "Spotlights" -> {
                    finish()
                    startActivity(Intent(this@MoreActivity, MainActivity::class.java))
                }
                "Exhibitions" -> {
                    finish()
                    startActivity(Intent(this@MoreActivity, MainActivity::class.java))
                }
                "Social" -> {
                    finish()
                    startActivity(Intent(this@MoreActivity, MainActivity::class.java))
                }
            }
        }
        nav_menu.adapter = adapter

        val layoutManager = GridLayoutManager(this@MoreActivity, 3)
        nav_menu.layoutManager = layoutManager
        nav_menu.setHasFixedSize(true)

        close_button.setOnClickListener {
            finish()
            setResult(Activity.RESULT_OK)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_OK)
    }

}
