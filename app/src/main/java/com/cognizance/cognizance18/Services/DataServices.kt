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
            ScheduleEvents("Jeremie Lasnier", "11:00-12:00", "MAC Auditorium", "29.86,77.89", ""),
            ScheduleEvents("Jagdeep Chhokar", "14:00-15:00", "MAC Auditorium", "29.86,77.89", ""),
            ScheduleEvents("Lit.A.F. Panel", "15:00-17:00", "MAC Auditorium", "29.86,77.89", ""),
            ScheduleEvents("Armageddon", "09:30-17:30", "SBI Lawns", "29.86,77.89", ""),
            ScheduleEvents("PowerDrift", "09:30-17:30", "LH Parking", "29.86,77.89", ""),
            ScheduleEvents("Cyborg Breakin", "09:30-17:30", "LHC Lawns", "29.86,77.89", ""),
            ScheduleEvents("AeroNave", "09:30-17:30", "Football Ground", "29.86,77.89", ""),
            ScheduleEvents("Poseidon", "09:30-17:30", "LHC Lawns", "29.86,77.89", ""),
            ScheduleEvents("Quadrone", "09:30-17:30", "Saraswati Ground", "29.86,77.89", ""),
            ScheduleEvents("IITR Mun", "10:00-14:00", "Senate Hall", "29.86,77.89", ""),
            ScheduleEvents("Mindsweeper", "10:00-16:00", "CC Ground Floor", "29.86,77.89", ""),
            ScheduleEvents("SafeRoads DataQuest", "10:00-17:00", "CTRANS", "29.86,77.89", ""),
            ScheduleEvents("Rush Hour", "10:30-13:30", "LHC 002", "", ""),
            ScheduleEvents("Pictionary", "11:00-13:00", "LHC 004", "", ""),
            ScheduleEvents("Fifa", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", ""),
            ScheduleEvents("Counter Strike", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", ""),
            ScheduleEvents("NFS", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", ""),
            ScheduleEvents("DOTA", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", ""),
            ScheduleEvents("AI", "11:00-17:00", "LHC 006", "29.86,77.89", "Technology"),
            ScheduleEvents("Innovation Challenge", "11:00-17:00", "LHC 105", "", ""),
            ScheduleEvents("BlockRush", "11:00-17:00", "LHC 104", "", ""),
            ScheduleEvents("AddictEd", "11:00-17:00", "LHC 106", "", ""),
            ScheduleEvents("Laser-o-Reflect", "11:00-17:00", "LHC 003", "", ""),
            ScheduleEvents("Chem-e-Car", "13:00-17:00", "LHC 101", "", ""),
            ScheduleEvents("Quizzotica: General", "14:00-16:00", "LHC 004", "", ""),
            ScheduleEvents("Mobile Gaming", "23:30-03:00", "Ravindra Lounge", "29.86,77.89", "")
    )
    val scheduleDay2 = arrayListOf(
            ScheduleEvents("Bharti Dayal", "14:30-15:30", "LHC 001", "29.86,77.89", ""),
            ScheduleEvents("Soumya Kulshreshtha", "15:00-17:00", "MAC Auditorium", "29.86,77.89", ""),
            ScheduleEvents("Bharat Panchal", "17:00-18:00", "MAC Auditorium", "29.86,77.89", ""),
            ScheduleEvents("Dawn of FinTexh v/s Traditional Banking", "11:00-14:00", "MAC Auditorium", "29.86,77.89", ""),
            ScheduleEvents("Armageddon", "09:30-17:30", "SBI Lawns", "29.86,77.89", ""),
            ScheduleEvents("PowerDrift", "09:30-17:30", "LH Parking", "29.86,77.89", ""),
            ScheduleEvents("Cyborg Breakin", "09:30-17:30", "LHC Lawns", "29.86,77.89", ""),
            ScheduleEvents("AeroNave", "09:30-17:30", "Football Ground", "29.86,77.89", ""),
            ScheduleEvents("Poseidon", "09:30-17:30", "LHC Lawns", "29.86,77.89", ""),
            ScheduleEvents("Quadrone", "09:30-17:30", "Saraswati Ground", "29.86,77.89", ""),
            ScheduleEvents("IITR Mun", "10:00-14:00", "Senate Hall", "29.86,77.89", ""),
            ScheduleEvents("Mindsweeper", "10:00-16:00", "CC Ground Floor", "29.86,77.89", ""),
            ScheduleEvents("Chem-e-Car", "10:00-16:30", "TT ROOM | STUDENT'S CLUB", "", ""),
            ScheduleEvents("SafeRoads DataQuest", "10:00-17:00", "CTRANS", "29.86,77.89", ""),
            ScheduleEvents("Rush Hour", "10:30-13:30", "LHC 002", "", ""),
            ScheduleEvents("Yin Yang", "11:00-13:00", "LHC 004", "", ""),
            ScheduleEvents("Fifa", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", ""),
            ScheduleEvents("Counter Strike", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", ""),
            ScheduleEvents("NFS", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", ""),
            ScheduleEvents("DOTA", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", ""),
            ScheduleEvents("Let's Cube", "11:00-17:00", "LHC 006", "29.86,77.89", ""),
            ScheduleEvents("AI", "11:00-17:00", "LHC 006", "29.86,77.89", ""),
            ScheduleEvents("teAch", "11:00-17:00", "LHC 205", "", ""),
            ScheduleEvents("Artboard", "11:00-17:00", "-", "", ""),
            ScheduleEvents("Verzeo AI Algo Challenge", "11:00-17:00", "LHC 003", "", ""),
            ScheduleEvents("Innovation Challenge", "11:00-17:00", "LHC 105", "", ""),
            ScheduleEvents("Glocalisation", "11:00-17:00", "LHC 101", "", ""),
            ScheduleEvents("BlockRush", "11:00-17:00", "LHC 104", "", ""),
            ScheduleEvents("Smog", "11:00-17:00", "LHC 203", "", ""),
            ScheduleEvents("AddictEd", "11:00-17:00", "LHC 106", "", ""),
            ScheduleEvents("COSC", "12:00-16:00", "LHC 301, 302, 303, 304", "", ""),
            ScheduleEvents("Lensational", "15:00-17:00", "OP Jain Audi", "", ""),
            ScheduleEvents("Mobile Gaming", "23:30-0300", "Ravindra Lounge", "29.86,77.89", "")
    )
    val scheduleDay3 = arrayListOf(
            ScheduleEvents("Enesa Mahmic", "14:00-15:00", "Senate Hall", "29.86,77.89", ""),
            ScheduleEvents("Debashish Purkayastha", "11:00-12:00", "MAC Auditorium", "29.86,77.89", ""),
            ScheduleEvents("Prashant Jha", "12:00-13:00", "MAC Auditorium", "29.86,77.89", ""),
            ScheduleEvents("Armageddon", "09:30-17:30", "SBI Lawns", "29.86,77.89", ""),
            ScheduleEvents("PowerDrift", "09:30-17:30", "LH Parking", "29.86,77.89", ""),
            ScheduleEvents("Cyborg Breakin", "09:30-17:30", "LH Lawns", "29.86,77.89", ""),
            ScheduleEvents("AeroNave", "09:30-17:30", "Football Ground", "29.86,77.89", ""),
            ScheduleEvents("Poseidon", "09:30-17:30", "LHC Lawns", "29.86,77.89", ""),
            ScheduleEvents("Quadrone", "09:30-17:30", "Saraswati Ground", "29.86,77.89", ""),
            ScheduleEvents("Mindsweeper", "10:00-16:00", "CC Ground Floor", "29.86,77.89", ""),
            ScheduleEvents("Applicate", "10:00-17:00", "LHC 004", "", ""),
            ScheduleEvents("Quizzotica: MELA quiz", "11:00-13:00", "LHC 004", "", ""),
            ScheduleEvents("Fifa", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", ""),
            ScheduleEvents("Counter Strike", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", ""),
            ScheduleEvents("NFS", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", ""),
            ScheduleEvents("DOTA", "11:00-17:00", "Ravindra Lounge", "29.86,77.89", ""),
            ScheduleEvents("Let's Cube", "11:00-17:00", "LHC 006", "29.86,77.89", ""),
            ScheduleEvents("teAch", "11:00-17:00", "LHC 205", "29.86,77.89", ""),
            ScheduleEvents("Verzeo AI Algo Challenge", "11:00-17:00", "LHC 003", "", ""),
            ScheduleEvents("Glocalisation", "11:00-17:00", "LHC 101", "", ""),
            ScheduleEvents("Smog", "11:00-17:00", "LHC 203", "", ""),
            ScheduleEvents("Quizzotica: Sci Tech", "14:00-16:00", "LHC 004", "", ""),
            ScheduleEvents("Mobile Gaming", "23:30-0300", "Ravindra Lounge", "29.86,77.89", "")
    )
}