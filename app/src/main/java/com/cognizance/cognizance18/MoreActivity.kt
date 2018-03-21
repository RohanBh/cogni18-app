package com.cognizance.cognizance18

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.cognizance.cognizance18.R.string.contact_us
import com.cognizance.cognizance18.Services.DataServices
import com.cognizance.cognizance18.adapters.NavMenuGridAdapter
import com.cognizance.cognizance18.models.Category
import com.cognizance.cognizance18.models.NavMenuGridItem
import kotlinx.android.synthetic.main.activity_more.*

/**
 * Created by rohan on 19/1/18.
 * Modified by rohit on 9/2/18.
 */
class MoreActivity : AppCompatActivity() {

    fun MoreActivity() {

    }

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

//        adapter = NavMenuGridAdapter(this@MoreActivity, Datadapter = NavMenuGridAdapter(this@MoreActivity, DataServices.categories, {})aServices.categories, {})
        adapter = NavMenuGridAdapter(this@MoreActivity, DataServices.categories) { item ->
            when (item.title) {
                "Home" -> {
                    setResult(3000)
                    finish()
                }
                "Events" -> {
                    setResult(3001)
                    finish()
                }
                "Workshop" -> {
                    setResult(3002)
                    finish()
                }
                "Spotlights" -> {
                    setResult(3003)
                    finish()
                }
                "Schedule" -> {
                    setResult(3004)
                    finish()
                }
                "Nearby Events" -> {
                    setResult(3005)
                    finish()
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

        sponsors.setOnClickListener{
            setResult(5000)
            finish()
        }

        about_us_text.setOnClickListener {
            setResult(5001)
            finish()
        }

        contact_us.setOnClickListener {
            setResult(5002)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_OK)
    }

}
