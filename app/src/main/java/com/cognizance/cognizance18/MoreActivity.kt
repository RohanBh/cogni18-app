package com.cognizance.cognizance18

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.cognizance.cognizance18.Services.DataServices
import com.cognizance.cognizance18.adapters.NavMenuGridAdapter
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
                "Treasure Hunt" -> {
                    setResult(3005)
                    finish()
                }

            }
        }

        about_us_text.setOnClickListener {
            setResult(5001)
            finish()
        }

        sponsors.setOnClickListener {
            setResult(5000)
            finish()
        }

        feedback.setOnClickListener {
            setResult(5002)
            finish()
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
