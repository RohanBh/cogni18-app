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
    val venuemac = "MAC Auditorium"
    val guestSpeakers = listOf(
            GuestSpeakers("Jagdeep Chhokar",
                    urlbegin + "/images/guestLecture/Jagdeep Chhokar.jpeg",
                    0,
                    R.string.jagdeep_chhokar,
                    venuemac,
                    "Day 1: 1400-1500"),
            GuestSpeakers("Prashant Jha",
                    urlbegin + "/images/guestLecture/Prashant Jha.jpeg",
                    0,
                    R.string.Dr_Prashant_Jha,
                    venuemac,
                    "Day 3: 1200-1300"),
            GuestSpeakers("Bharat Panchal",
                    urlbegin + "/images/guestLecture/bharat panchal.jpg",
                    0,
                    R.string.Bharat_Panchal,
                    venuemac,
                    "Day 2: 1700-1800"),
            GuestSpeakers("Amaresh Ramaswamy",
                    urlbegin + "/images/guestLecture/Amaresh Ramaswamy.jpg",
                    0,
                    R.string.Amaresh_Ramaswamy,
                    venuemac,
                    "-"),
            GuestSpeakers("Jeremie Lasnier",
                    urlbegin + "/images/guestLecture/jeremie.jpg",
                    0,
                    R.string.Jeremie_Lasnier,
                    venuemac,
                    "Day 1: 1100-1200")
    )

    val exhibitions = listOf(
            Events("Furhat", urlbegin + "/images/exhibitions/FurhatRobot.jpg"),
            Events("Nino", urlbegin + "/images/exhibitions/NinoRobot.jpg"),
            Events("Puzzlebox Orbit", urlbegin + "/images/exhibitions/Puzzlebox Orbit.jpg")
    )

    val paneldiscussion1 = listOf(
            GuestSpeakers("Ms. Lizzie Chapman",
                    urlbegin + "/images/guestLecture/Lizzie Chapman.jpg",
                    0,
                    R.string.Lizzie_Chapman,
                    venuemac,
                    "Day 2: 1100-1400"),
            GuestSpeakers("Mr. Jai Pawani",
                    urlbegin + "/images/guestLecture/Jai Pawani.jpg",
                    0,
                    R.string.Jai_Pawani,
                    venuemac,
                    "Day 2: 1100-1400"),
            GuestSpeakers("Mr. Harshil Mathur",
                    urlbegin + "/images/guestLecture/Harshil Mathur.jpg",
                    0,
                    R.string.Harshil_Mathur,
                    venuemac,
                    "Day 2: 1100-1400"),
            GuestSpeakers("Ms. Prashanthi Reddy",
                    urlbegin + "/images/guestLecture/Prashanthi Reddy.jpg",
                    0,
                    R.string.Prashanthi_Reddy,
                    venuemac,
                    "Day 2: 1100-1400"),
            GuestSpeakers("Mr. Nishant Govil",
                    urlbegin + "/images/guestLecture/nishant govil.jpg",
                    0,
                    R.string.Nishant_Govil,
                    venuemac,
                    "Day 2: 1100-1400")
    )
    val paneldiscussion2 = listOf(
            GuestSpeakers("Saumya Kulshreshtha",
                    "",
                    R.drawable.gs_saumya_kulshreshtha,
                    R.string.Saumya_Kulshreshtha,
                    venuemac,
                    "Day 1: 1500-1700"),
            GuestSpeakers("Ashutosh Sinha",
                    "",
                    R.drawable.gs_ashutosh_sinha,
                    R.string.Ashutosh_Sinha,
                    venuemac,
                    "Day 1: 1500-1700"),
            GuestSpeakers("Nikhil Chandwani",
                    "",
                    R.drawable.gs_nikhil_chandwani,
                    R.string.Nikhil_Chandwani,
                    venuemac,
                    "Day 1: 1500-1700"),
            GuestSpeakers("Keshav Aneel",
                    "",
                    R.drawable.gs_keshav_aneel,
                    R.string.Keshav_Aneel,
                    venuemac,
                    "Day 1: 1500-1700"),
            GuestSpeakers("Gaurav Solanki",
                    "",
                    R.drawable.gs_gaurav_solanki,
                    R.string.Gaurav_Solanki,
                    venuemac,
                    "Day 1: 1500-1700")
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