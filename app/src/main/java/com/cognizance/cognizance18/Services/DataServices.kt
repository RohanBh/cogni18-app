package com.cognizance.cognizance18.Services

import com.cognizance.cognizance18.models.Category

/**
 * Created by rohit on 10/2/18.
 */
object DataServices {
    val categories = listOf<Category>(
            Category("Home","ic_home"),
            Category("Events","ic_event"),
            Category("Workshop","ic_workshop"),
            Category("Spotlights","ic_spotlight"),
            Category("Exhibitions","ic_exhibition"),
            Category("Social","ic_social")
    )
}