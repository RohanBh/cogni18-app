package com.cognizance.cognizance18.Services

import com.cognizance.cognizance18.models.Category
import com.cognizance.cognizance18.models.WorkshopModels.ScheduleEvents

/**
 * Created by rohit on 10/2/18.
 */
object DataServices {
    val categories = listOf<Category>(
            Category("Home","ic_home"),
            Category("Events","ic_event"),
            Category("Workshop","ic_exhibition"),
            Category("Spotlights","ic_spotlight"),
            Category("Schedule","ic_social"),
            Category("Map","ic_workshop")
    )

    val schedule = arrayListOf<ScheduleEvents>(
            ScheduleEvents("Hello", "09:00-11:30", "Convocation Hall", "29.86,77.89"),
            ScheduleEvents("World", "09:00-11:30", "Convocation Hall", "29.86,77.89"),
            ScheduleEvents("Hello", "09:00-11:30", "Convocation Hall", "29.86,77.89"),
            ScheduleEvents("World", "09:00-11:30", "Convocation Hall", "29.86,77.89"),
            ScheduleEvents("Hello", "09:00-11:30", "Convocation Hall", "29.86,77.89"),
            ScheduleEvents("World", "09:00-11:30", "Convocation Hall", "29.86,77.89"),
            ScheduleEvents("Hello", "09:00-11:30", "Convocation Hall", "29.86,77.89"),
            ScheduleEvents("World", "09:00-11:30", "Convocation Hall", "29.86,77.89"),
            ScheduleEvents("Hello", "09:00-11:30", "Convocation Hall", "29.86,77.89"),
            ScheduleEvents("World", "09:00-11:30", "Convocation Hall", "29.86,77.89")
    )
}