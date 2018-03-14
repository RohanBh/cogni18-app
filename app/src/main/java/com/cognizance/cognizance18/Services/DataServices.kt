package com.cognizance.cognizance18.Services

import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.models.*
import com.cognizance.cognizance18.models.WorkshopModels.ScheduleEvents

/**
 * Created by rohit on 10/2/18.
 */
object DataServices {
    val categories = listOf(
            Category("Home", "ic_home"),
            Category("Events", "ic_event"),
            Category("Workshop", "ic_exhibition"),
            Category("Spotlights", "ic_spotlight"),
            Category("Schedule", "ic_social"),
            Category("Map", "ic_workshop")
    )

    val techtainments = listOf(
            SpotLightCard(R.drawable.spot_biswa, "Biswa", "Day 1"),
            SpotLightCard(R.drawable.spot_aron, "Aron Chupa & Diego Miranda", "Day 2"),
            SpotLightCard(R.drawable.spot_randhawa, "Guru Randhawa", "Day 3")
    )

    val urlbegin = "https://cognizance.org.in"
    val guestSpeakers = listOf(
            GuestSpeakers("Jagdeep Chhokar", urlbegin + "/images/guestLecture/Jagdeep Chhokar.jpeg"),
            GuestSpeakers("Prashant Jha", urlbegin + "/images/guestLecture/Prashant Jha.jpeg"),
            GuestSpeakers("Bharat Panchal", urlbegin + "/images/guestLecture/bharat panchal.jpg"),
            GuestSpeakers("Amaresh Ramaswamy", urlbegin + "/images/guestLecture/Amaresh Ramaswamy.jpg"),
            GuestSpeakers("Jeremie Lasnier", urlbegin + "/images/guestLecture/jeremie.jpg")
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