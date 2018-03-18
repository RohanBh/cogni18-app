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
            ScheduleEvents("Jeremie Lasnier", "11:00-12:00", "MAC Auditorium", "29.8706399,77.8962164", "Guest Speaker"),
            ScheduleEvents("Jagdeep Chhokar", "14:00-15:00", "MAC Auditorium", "29.8706399,77.8962164", "Guest Speaker"),
            ScheduleEvents("Lit.A.F. Panel", "15:00-17:00", "MAC Auditorium", "29.8706399,77.8962164", "Panel Discussion"),
            ScheduleEvents("Armageddon", "09:30-17:30", "SBI Lawns", "29.8643591,77.8947845", "Robotics"),
            ScheduleEvents("PowerDrift", "09:30-17:30", "LH Parking", "29.8649349,77.8954754", "Robotics"),
            ScheduleEvents("Cyborg Breakin", "09:30-17:30", "LHC Lawns", "29.8643248,77.8932424", "Robotics"),
            ScheduleEvents("AeroNave", "09:30-17:30", "Football Ground", "29.8673954,77.8963734", "Robotics"),
            ScheduleEvents("Poseidon", "09:30-17:30", "LHC Lawns", "29.8643248,77.8932424", "Robotics"),
            ScheduleEvents("Quadrone", "09:30-17:30", "Saraswati Ground", "29.8679955,77.8950774", "Robotics"),
            ScheduleEvents("IITR Mun", "10:00-14:00", "Senate Hall", "29.8657711,77.8928973", "Lit A.F."),
            ScheduleEvents("Mindsweeper", "10:00-16:00", "CC Ground Floor", "29.8638314,77.8943198", "Technology"),
            ScheduleEvents("SafeRoads DataQuest", "10:00-17:00", "CTRANS", "29.8623183,77.8893435", "Technology"),
            ScheduleEvents("Rush Hour", "10:30-13:30", "LHC 002", "29.8648554,77.893711", "Innovation Enclave"),
            ScheduleEvents("Pictionary", "11:00-13:00", "LHC 004", "29.8648554,77.893711", "Lit A.F."),
            ScheduleEvents("Fifa", "11:00-17:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming"),
            ScheduleEvents("Counter Strike", "11:00-17:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming"),
            ScheduleEvents("NFS", "11:00-17:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming"),
            ScheduleEvents("DOTA", "11:00-17:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming"),
            ScheduleEvents("AI", "11:00-17:00", "LHC 006", "29.8648554,77.893711", "Technology"),
            ScheduleEvents("Innovation Challenge", "11:00-17:00", "LHC 105", "29.8648554,77.893711", "Innovation Enclave"),
            ScheduleEvents("BlockRush", "11:00-17:00", "LHC 104", "29.8648554,77.893711", "Innovation Enclave"),
            ScheduleEvents("AddictEd", "11:00-17:00", "LHC 106", "29.8648554,77.893711", "Off the Cut"),
            ScheduleEvents("Laser-o-Reflect", "11:00-17:00", "LHC 003", "29.8648554,77.893711", "Off the Cut"),
            ScheduleEvents("Chem-e-Car", "13:00-17:00", "LHC 101", "29.8648554,77.893711", "Off the Cut"),
            ScheduleEvents("Quizzotica: Biz", "14:00-16:00", "LHC 004", "29.8648554,77.893711", "Lit A.F."),
            ScheduleEvents("Mobile Gaming", "23:30-03:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming")
    )
    val scheduleDay2 = arrayListOf(
            ScheduleEvents("Bharti Dayal", "14:30-15:30", "LHC 001", "29.8648554,77.893711", "Guest Speaker"),
            ScheduleEvents("Soumya Kulshreshtha", "15:00-17:00", "MAC Auditorium", "29.8706399,77.8962164", "Guest Speaker"),
            ScheduleEvents("Bharat Panchal", "17:00-18:00", "MAC Auditorium", "29.8706399,77.8962164", "Guest Speaker"),
            ScheduleEvents("Dawn of FinTexh v/s Traditional Banking", "11:00-14:00", "MAC Auditorium", "29.8706399,77.8962164", "Pannel Discussion"),
            ScheduleEvents("Armageddon", "09:30-17:30", "SBI Lawns", "29.8643591,77.8947845", "Robotics"),
            ScheduleEvents("PowerDrift", "09:30-17:30", "LH Parking", "29.8649349,77.8954754", "Robotics"),
            ScheduleEvents("Cyborg Breakin", "09:30-17:30", "LHC Lawns", "29.8643248,77.8932424", "Robotics"),
            ScheduleEvents("AeroNave", "09:30-17:30", "Football Ground", "29.8673954,77.8963734", "Robotics"),
            ScheduleEvents("Poseidon", "09:30-17:30", "LHC Lawns", "29.8643248,77.8932424", "Robotics"),
            ScheduleEvents("Quadrone", "09:30-17:30", "Saraswati Ground", "29.8679955,77.8950774", "Robotics"),
            ScheduleEvents("IITR Mun", "10:00-14:00", "Senate Hall", "29.8657711,77.8928973", "Lit A.F."),
            ScheduleEvents("Mindsweeper", "10:00-16:00", "CC Ground Floor", "29.8638314,77.8943198", "Technology"),
            ScheduleEvents("Chem-e-Car", "10:00-16:30", "TT ROOM | STUDENT'S CLUB", "29.8645077,77.890639", "Off the Cut"),
            ScheduleEvents("SafeRoads DataQuest", "10:00-17:00", "CTRANS", "29.8623183,77.8893435", "Technology"),
            ScheduleEvents("Rush Hour", "10:30-13:30", "LHC 002", "29.8648554,77.893711", "Innovation Enclave"),
            ScheduleEvents("Yin Yang", "11:00-13:00", "LHC 004", "29.8648554,77.893711", "Lit A.F."),
            ScheduleEvents("Fifa", "11:00-17:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming"),
            ScheduleEvents("Counter Strike", "11:00-17:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming"),
            ScheduleEvents("NFS", "11:00-17:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming"),
            ScheduleEvents("DOTA", "11:00-17:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming"),
            ScheduleEvents("Let's Cube", "11:00-17:00", "LHC 006", "29.8648554,77.893711", "Gaming"),
            ScheduleEvents("AI", "11:00-17:00", "LHC 006", "29.8648554,77.893711", "Technology"),
            ScheduleEvents("teAch", "11:00-17:00", "LHC 205", "29.8648554,77.893711", "Technology"),
            ScheduleEvents("Artboard", "11:00-17:00", "-", "", "Technology"),
            ScheduleEvents("Verzeo AI Algo Challenge", "11:00-17:00", "LHC 003", "29.8648554,77.893711", "Technology"),
            ScheduleEvents("Innovation Challenge", "11:00-17:00", "LHC 105", "29.8648554,77.893711", "Innovation Enclave"),
            ScheduleEvents("Glocalisation", "11:00-17:00", "LHC 101", "29.8648554,77.893711", "Innovation Enclave"),
            ScheduleEvents("BlockRush", "11:00-17:00", "LHC 104", "29.8648554,77.893711", "Innovation Enclave"),
            ScheduleEvents("Smog", "11:00-17:00", "LHC 203", "29.8648554,77.893711", "Off the Cut"),
            ScheduleEvents("AddictEd", "11:00-17:00", "LHC 106", "29.8648554,77.893711", "Off the Cut"),
            ScheduleEvents("COSC", "12:00-16:00", "LHC 301, 302, 303, 304", "29.8648554,77.893711", "Off the Cut"),
            ScheduleEvents("Lensational", "15:00-17:00", "OP Jain Audi", "29.8639694,77.8955173", "Off the Cut"),
            ScheduleEvents("Mobile Gaming", "23:30-0300", "Ravindra Lounge", "29.86322,77.8926161", "Gaming")
    )
    val scheduleDay3 = arrayListOf(
            ScheduleEvents("Enesa Mahmic", "14:00-15:00", "Senate Hall", "29.8657711,77.8928973", "Guest Speaker"),
            ScheduleEvents("Debashish Purkayastha", "11:00-12:00", "MAC Auditorium", "29.8706399,77.8962164", "Guest Speaker"),
            ScheduleEvents("Prashant Jha", "12:00-13:00", "MAC Auditorium", "29.8706399,77.8962164", "Guest Speaker"),
            ScheduleEvents("Armageddon", "09:30-17:30", "SBI Lawns", "29.8643591,77.8947845", "Robotics"),
            ScheduleEvents("PowerDrift", "09:30-17:30", "LH Parking", "29.8649349,77.8954754", "Robotics"),
            ScheduleEvents("Cyborg Breakin", "09:30-17:30", "LH Lawns", "29.86,77.89", "Robotics"),
            ScheduleEvents("AeroNave", "09:30-17:30", "Football Ground", "29.8673954,77.8963734", "Robotics"),
            ScheduleEvents("Poseidon", "09:30-17:30", "LHC Lawns", "29.8643248,77.8932424", "Robotics"),
            ScheduleEvents("Quadrone", "09:30-17:30", "Saraswati Ground", "29.8679955,77.8950774", "Robotics"),
            ScheduleEvents("Mindsweeper", "10:00-16:00", "CC Ground Floor", "29.8638314,77.8943198", "Technology"),
            ScheduleEvents("Applicate", "10:00-17:00", "LHC 004", "29.8648554,77.893711", "Technology"),
            ScheduleEvents("Quizzotica: MELA quiz", "11:00-13:00", "LHC 004", "29.8648554,77.893711", "Lit A.F."),
            ScheduleEvents("Fifa", "11:00-17:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming"),
            ScheduleEvents("Counter Strike", "11:00-17:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming"),
            ScheduleEvents("NFS", "11:00-17:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming"),
            ScheduleEvents("DOTA", "11:00-17:00", "Ravindra Lounge", "29.86322,77.8926161", "Gaming"),
            ScheduleEvents("Let's Cube", "11:00-17:00", "LHC 006", "29.8648554,77.893711", "Gaming"),
            ScheduleEvents("teAch", "11:00-17:00", "LHC 205", "29.8648554,77.893711", "Technology"),
            ScheduleEvents("Verzeo AI Algo Challenge", "11:00-17:00", "LHC 003", "29.8648554,77.893711", "Technology"),
            ScheduleEvents("Glocalisation", "11:00-17:00", "LHC 101", "29.8648554,77.893711", "Innovation Enclave"),
            ScheduleEvents("Smog", "11:00-17:00", "LHC 203", "29.8648554,77.893711", "Off the Cut"),
            ScheduleEvents("Quizzotica: Sci Tech", "14:00-16:00", "LHC 004", "29.8648554,77.893711", "Lit A.F."),
            ScheduleEvents("Mobile Gaming", "23:30-0300", "Ravindra Lounge", "29.86322,77.8926161", "Gaming")
    )
}