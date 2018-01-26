package com.cognizance.cognizance18

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.cognizance.cognizance18.adapters.NavMenuGridAdapter
import com.cognizance.cognizance18.models.NavMenuGridItem
import kotlinx.android.synthetic.main.activity_more.*

/**
 * Created by rohan on 19/1/18.
 */
class MoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)
        nav_menu.adapter = NavMenuGridAdapter(listOf(
                NavMenuGridItem("Home"),
                NavMenuGridItem("Events"),
                NavMenuGridItem("Workshop"),
                NavMenuGridItem("Spotlights"),
                NavMenuGridItem("Home"),
                NavMenuGridItem("Home"),
                NavMenuGridItem("Home")
        ))
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