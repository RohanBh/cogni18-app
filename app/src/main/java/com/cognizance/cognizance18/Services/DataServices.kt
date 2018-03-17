package com.cognizance.cognizance18.Services

import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.models.Category
import com.cognizance.cognizance18.models.SpotLightCard
import com.cognizance.cognizance18.models.SpotlightCard
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

    val spotlightEvents = listOf(
            SpotLightCard(R.drawable.spot_biswa, "Biswa", "Day 1"),
            SpotLightCard(R.drawable.spot_aron, "Aron Chupa and Diego Miranda", "Day 2"),
            SpotLightCard(R.drawable.spot_randhawa, "Guru Randhawa", "Day 3")
    )

    val scheduleDay1 = arrayListOf(
            ScheduleEvents("Jeremie Lasnier", "11:00-12:00", "MAC Auditorium", "29.86,77.89", "Guest Speaker"),
            ScheduleEvents("Jagdeep Chhokar", "14:00-15:00", "MAC Auditorium", "29.86,77.89", "Guest Speaker"),
            ScheduleEvents("Lit.A.F. Panel", "15:00-17:00", "MAC Auditorium", "29.86,77.89", "Panel Discussion"),
            ScheduleEvents("Armageddon", "09:30-17:30", "SBI Lawns", "29.86,77.89", "Robotics"),
            ScheduleEvents("PowerDrift", "09:30-17:30", "LH Parking", "29.86,77.89", "Robotics"),
            ScheduleEvents("Cyborg Breakin", "09:30-17:30", "LHC Lawns", "29.86,77.89", "Robotics"),
            ScheduleEvents("AeroNave", "09:30-17:30", "Football Ground", "29.86,77.89", "Robotics"),
            ScheduleEvents("Poseidon", "09:30-17:30", "LHC Lawns", "29.86,77.89", "Robotics"),
            ScheduleEvents("Quadrone", "09:30-17:30", "Saraswati Ground", "29.86,77.89", "Robotics"),
            ScheduleEvents("IITR Mun", "10:00-14:00", "Senate Hall", "29.86,77.89", "Lit A.F."),
            ScheduleEvents("Mindsweeper", "10:00-16:00", "CC Ground Floor", "29.86,77.89", "Technology"),
            ScheduleEvents("SafeRoads DataQuest", "10:00-17:00", "CTRANS", "29.86,77.89", "Technology"),
            ScheduleEvents("Rush Hour", "10:30-13:30", "LHC 002", "", "Innovation Enclave"),
            ScheduleEvents("Pictionary", "11:00-13:00", "LHC 004", "", "Lit A.F."),
            ScheduleEvents("Fifa", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", "Gaming"),
            ScheduleEvents("Counter Strike", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", "Gaming"),
            ScheduleEvents("NFS", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", "Gaming"),
            ScheduleEvents("DOTA", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", "Gaming"),
            ScheduleEvents("AI", "11:00-17:00", "LHC 006", "29.86,77.89", "Technology"),
            ScheduleEvents("Innovation Challenge", "11:00-17:00", "LHC 105", "", "Innovation Enclave"),
            ScheduleEvents("BlockRush", "11:00-17:00", "LHC 104", "", "Innovation Enclave"),
            ScheduleEvents("AddictEd", "11:00-17:00", "LHC 106", "", "Off the Cut"),
            ScheduleEvents("Laser-o-Reflect", "11:00-17:00", "LHC 003", "", "Off the Cut"),
            ScheduleEvents("Chem-e-Car", "13:00-17:00", "LHC 101", "", "Off the Cut"),
            ScheduleEvents("Quizzotica: Biz", "14:00-16:00", "LHC 004", "", "Lit A.F."),
            ScheduleEvents("Mobile Gaming", "23:30-03:00", "Ravindra Lounge", "29.86,77.89", "Gaming")
    )
    val scheduleDay2 = arrayListOf(
            ScheduleEvents("Bharti Dayal", "14:30-15:30", "LHC 001", "29.86,77.89", "Guest Speaker"),
            ScheduleEvents("Soumya Kulshreshtha", "15:00-17:00", "MAC Auditorium", "29.86,77.89", "Guest Speaker"),
            ScheduleEvents("Bharat Panchal", "17:00-18:00", "MAC Auditorium", "29.86,77.89", "Guest Speaker"),
            ScheduleEvents("Dawn of FinTexh v/s Traditional Banking", "11:00-14:00", "MAC Auditorium", "29.86,77.89", "Pannel Discussion"),
            ScheduleEvents("Armageddon", "09:30-17:30", "SBI Lawns", "29.86,77.89", "Robotics"),
            ScheduleEvents("PowerDrift", "09:30-17:30", "LH Parking", "29.86,77.89", "Robotics"),
            ScheduleEvents("Cyborg Breakin", "09:30-17:30", "LHC Lawns", "29.86,77.89", "Robotics"),
            ScheduleEvents("AeroNave", "09:30-17:30", "Football Ground", "29.86,77.89", "Robotics"),
            ScheduleEvents("Poseidon", "09:30-17:30", "LHC Lawns", "29.86,77.89", "Robotics"),
            ScheduleEvents("Quadrone", "09:30-17:30", "Saraswati Ground", "29.86,77.89", "Robotics"),
            ScheduleEvents("IITR Mun", "10:00-14:00", "Senate Hall", "29.86,77.89", "Lit A.F."),
            ScheduleEvents("Mindsweeper", "10:00-16:00", "CC Ground Floor", "29.86,77.89", "Technology"),
            ScheduleEvents("Chem-e-Car", "10:00-16:30", "TT ROOM | STUDENT'S CLUB", "", ""),
            ScheduleEvents("SafeRoads DataQuest", "10:00-17:00", "CTRANS", "29.86,77.89", "Technology"),
            ScheduleEvents("Rush Hour", "10:30-13:30", "LHC 002", "", ""),
            ScheduleEvents("Yin Yang", "11:00-13:00", "LHC 004", "", "Lit A.F."),
            ScheduleEvents("Fifa", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", "Gaming"),
            ScheduleEvents("Counter Strike", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", "Gaming"),
            ScheduleEvents("NFS", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", "Gaming"),
            ScheduleEvents("DOTA", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", "Gaming"),
            ScheduleEvents("Let's Cube", "11:00-17:00", "LHC 006", "29.86,77.89", "Gaming"),
            ScheduleEvents("AI", "11:00-17:00", "LHC 006", "29.86,77.89", "Technology"),
            ScheduleEvents("teAch", "11:00-17:00", "LHC 205", "", "Technology"),
            ScheduleEvents("Artboard", "11:00-17:00", "-", "", "Technology"),
            ScheduleEvents("Verzeo AI Algo Challenge", "11:00-17:00", "LHC 003", "", "Technology"),
            ScheduleEvents("Innovation Challenge", "11:00-17:00", "LHC 105", "", "Innovation Enclave"),
            ScheduleEvents("Glocalisation", "11:00-17:00", "LHC 101", "", "Innovation Enclave"),
            ScheduleEvents("BlockRush", "11:00-17:00", "LHC 104", "", "Innovation Enclave"),
            ScheduleEvents("Smog", "11:00-17:00", "LHC 203", "", "Off the Cut"),
            ScheduleEvents("AddictEd", "11:00-17:00", "LHC 106", "", "Off the Cut"),
            ScheduleEvents("COSC", "12:00-16:00", "LHC 301, 302, 303, 304", "", "Off the Cut"),
            ScheduleEvents("Lensational", "15:00-17:00", "OP Jain Audi", "", "Off the Cut"),
            ScheduleEvents("Mobile Gaming", "23:30-0300", "Ravindra Lounge", "29.86,77.89", "Gaming")
    )
    val scheduleDay3 = arrayListOf(
            ScheduleEvents("Enesa Mahmic", "14:00-15:00", "Senate Hall", "29.86,77.89", "Guest Speaker"),
            ScheduleEvents("Debashish Purkayastha", "11:00-12:00", "MAC Auditorium", "29.86,77.89", "Guest Speaker"),
            ScheduleEvents("Prashant Jha", "12:00-13:00", "MAC Auditorium", "29.86,77.89", "Guest Speaker"),
            ScheduleEvents("Armageddon", "09:30-17:30", "SBI Lawns", "29.86,77.89", "Robotics"),
            ScheduleEvents("PowerDrift", "09:30-17:30", "LH Parking", "29.86,77.89", "Robotics"),
            ScheduleEvents("Cyborg Breakin", "09:30-17:30", "LH Lawns", "29.86,77.89", "Robotics"),
            ScheduleEvents("AeroNave", "09:30-17:30", "Football Ground", "29.86,77.89", "Robotics"),
            ScheduleEvents("Poseidon", "09:30-17:30", "LHC Lawns", "29.86,77.89", "Robotics"),
            ScheduleEvents("Quadrone", "09:30-17:30", "Saraswati Ground", "29.86,77.89", "Robotics"),
            ScheduleEvents("Mindsweeper", "10:00-16:00", "CC Ground Floor", "29.86,77.89", "Technology"),
            ScheduleEvents("Applicate", "10:00-17:00", "LHC 004", "", "Technology"),
            ScheduleEvents("Quizzotica: MELA quiz", "11:00-13:00", "LHC 004", "", "Lit A.F."),
            ScheduleEvents("Fifa", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", "Gaming"),
            ScheduleEvents("Counter Strike", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", "Gaming"),
            ScheduleEvents("NFS", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", "Gaming"),
            ScheduleEvents("DOTA", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", "Gaming"),
            ScheduleEvents("Let's Cube", "11:00-17:00", "LHC 006", "29.86,77.89", "Gaming"),
            ScheduleEvents("teAch", "11:00-17:00", "LHC 205", "29.86,77.89", "Technology"),
            ScheduleEvents("Verzeo AI Algo Challenge", "11:00-17:00", "LHC 003", "", "Technology"),
            ScheduleEvents("Glocalisation", "11:00-17:00", "LHC 101", "", "Innovation Enclave"),
            ScheduleEvents("Smog", "11:00-17:00", "LHC 203", "", "Off the Cut"),
            ScheduleEvents("Quizzotica: Sci Tech", "14:00-16:00", "LHC 004", "", "Lit A.F."),
            ScheduleEvents("Mobile Gaming", "23:30-0300", "Ravindra Lounge", "29.86,77.89", "Gaming")
    )
}