package com.cognizance.cognizance18.Services

import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.models.Category
import com.cognizance.cognizance18.models.SpotlightCard
import com.cognizance.cognizance18.models.WorkshopModels.ScheduleEvents

/**
 * Created by rohit on 10/2/18.
 */
object DataServices {
    val categories = listOf<Category>(
            Category("Home", "ic_home"),
            Category("Events", "ic_event"),
            Category("Workshop", "ic_exhibition"),
            Category("Spotlights", "ic_spotlight"),
            Category("Schedule", "ic_social"),
            Category("Map", "ic_workshop")
    )

    val spotlightEvents = listOf(
            SpotlightCard(R.drawable.spot_biswa, "Biswa"),
            SpotlightCard(R.drawable.spot_aron, "Aron Chupa"),
            SpotlightCard(R.drawable.spot_randhawa, "Guru Randhawa")
    )

    val scheduleDay1 = arrayListOf(
            ScheduleEvents("1", "09:00-11:30", "Convocation Hall", "29.86,77.89"),
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
    val scheduleDay2 = arrayListOf(
            ScheduleEvents("2", "09:00-11:30", "Convocation Hall", "29.86,77.89"),
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
    val scheduleDay3 = arrayListOf(
            ScheduleEvents("3", "09:00-11:30", "Convocation Hall", "29.86,77.89"),
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