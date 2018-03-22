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
            Category("Treasure Hunt", "ic_workshop")
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
            ScheduleEvents("Jeremie Lasnier", "11:00-12:00", "MAC Auditorium", "29.869995, 77.896328", "Guest Speaker"),
            ScheduleEvents("Jagdeep Chhokar", "14:00-15:00", "MAC Auditorium", "29.869995, 77.896328", "Guest Speaker"),
            ScheduleEvents("Lit.A.F. Panel", "15:00-17:00", "MAC Auditorium", "29.869995, 77.896328", "Panel Discussion"),
            ScheduleEvents("Armageddon", "10:00-17:00", "SBI Lawns", "29.864582, 77.895635", "Robotics"),
            ScheduleEvents("Powerdrift", "10:00-17:00", "LH Parking", "29.864929, 77.895174", "Robotics"),
            ScheduleEvents("Cyborg Breakln", "10:00-17:00", "LHC Lawns", "29.864324, 77.893793", "Robotics"),
            ScheduleEvents("Aeronave", "10:00-17:00", "Football Ground", "29.867862, 77.898488", "Robotics"),
            ScheduleEvents("Poseidon", "10:00-17:00", "LHC Lawns", "29.864324, 77.893793", "Robotics"),
            ScheduleEvents("Quadrone", "10:00-17:00", "Saraswati Ground", "29.868001, 77.897255", "Robotics"),
            ScheduleEvents("IITR MUN", "10:00-17:00", "Senate Hall", "29.8648749,77.8963164", "Lit A.F."),
            ScheduleEvents("AI", "11:00-17:00", "LHC 102", "29.8649077,77.8937664", "Technology"),
            ScheduleEvents("Schlumberger day", "13:00-17:00", "LHC 103", "29.8649077,77.8937664", "Technology"),
            ScheduleEvents("Mindsweeper", "10:00-16:00", "CC Ground Floor", "29.862890, 77.896407", "Technology"),
            ScheduleEvents("SafeRoads DataQuest", "10:00-17:00", "CTRANS", "29.8623183,77.8893435", "Technology"),
            ScheduleEvents("Alankan", "10:00-17:00", "LR1,DOMS", "29.8646738,77.8926466", "B-Street"),
            ScheduleEvents("Karyaneeti", "10:00-17:00", "LHC 315,316", "29.8649077,77.8937664", "B-Street"),
            ScheduleEvents("DigiPeak", "13:00-17:00", "LR2,DOMS", "29.8646738,77.8926466", "B-Street"),
            ScheduleEvents("Rush Hour", "10:30-13:30", "LHC 002", "29.8649077,77.8937664", "Innovation Conclave"),
            ScheduleEvents("Pictionary", "11:00-13:00", "LHC 006", "29.8649077,77.8937664", "Lit A.F."),
            ScheduleEvents("Carnival", "11:00-17:30", "Saraswati Ground", "29.868001, 77.897255", "Gaming"),
            ScheduleEvents("FIFA '17", "11:00-17:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("Counter Strike GO", "11:00-17:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("NFS", "11:00-17:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("DOTA 2", "11:00-17:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("AI", "11:00-17:00", "LHC 006", "29.8649077,77.8937664", "Technology"),
            ScheduleEvents("Innovation Challenge", "11:00-17:00", "LHC 105", "29.8649077,77.8937664", "Innovation Conclave"),
            ScheduleEvents("BlockRush", "11:00-17:00", "LHC 104", "29.8649077,77.8937664", "Innovation Conclave"),
            ScheduleEvents("AddictEd", "11:00-17:00", "LHC 106", "29.8649077,77.8937664", "Off the Cuff"),
            ScheduleEvents("Laser-o-Reflect", "11:00-17:00", "LHC 003", "29.8649077,77.8937664", "Off the Cuff"),
            ScheduleEvents("Chem-e-Car", "13:00-17:00", "LHC 101", "29.8649077,77.8937664", "Off the Cuff"),
            ScheduleEvents("Effigy", "23:30-02:00", "AHEC Deptt", "29.868678,77.895408", "Off the Cuff"),
            ScheduleEvents("Quizzotica: Biz", "14:00-16:00", "LHC 006", "29.8649077,77.8937664", "Lit A.F."),
            ScheduleEvents("Mobile Gaming", "23:30-03:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming")
    )
    val scheduleDay2 = arrayListOf(
            ScheduleEvents("Bharti Dayal", "14:30-15:30", "Chem Audi", "29.8675097,77.8935227", "Guest Speaker"),
            ScheduleEvents("Soumya Kulshreshtha", "15:00-17:00", "MAC Auditorium", "29.869995, 77.896328", "Guest Speaker"),
            ScheduleEvents("Bharat Panchal", "17:00-18:00", "MAC Auditorium", "29.869995, 77.896328", "Guest Speaker"),
            ScheduleEvents("Dawn of FinTech", "11:00-14:00", "MAC Audi", "29.869995, 77.896328", "Pannel Discussion"),
            ScheduleEvents("Armageddon", "10:00-17:00", "SBI Lawns", "29.864582, 77.895635", "Robotics"),
            ScheduleEvents("Powerdrift", "10:00-17:00", "LH Parking", "29.864929, 77.895174", "Robotics"),
            ScheduleEvents("Cyborg Breakln", "10:00-17:00", "LHC Lawns", "29.864324, 77.893793", "Robotics"),
            ScheduleEvents("Aeronave", "10:00-17:00", "Football Ground", "29.867862, 77.898488", "Robotics"),
            ScheduleEvents("Poseidon", "10:00-17:00", "LHC Lawns", "29.864324, 77.893793", "Robotics"),
            ScheduleEvents("Quadrone", "10:00-17:00", "Saraswati Ground", "29.868001, 77.897255", "Robotics"),
            ScheduleEvents("IITR MUN", "10:00-17:00", "Senate Hall", "29.8648749,77.8963164", "Lit A.F."),
            ScheduleEvents("Mindsweeper", "10:00-16:00", "CC Ground Floor", "29.862890, 77.896407", "Technology"),
            ScheduleEvents("Chem-e-Car", "10:00-16:30", "TT ROOM | STUDENT'S CLUB", "29.863740,77.894668", "Off the Cut"),
            ScheduleEvents("DataQuest", "10:00-17:00", "CTRANS", "29.8623183,77.8893435", "Technology"),
            // ScheduleEvents("Rush Hour", "10:30-13:30", "LHC 002", "", ""),
            //ScheduleEvents("Yin Yang", "11:00-13:00", "LHC 004", "", "Lit A.F."),
            ScheduleEvents("Book Pitching", "11:00-17:00", "LHC 308", "29.8649077,77.8937664", "LIt A.F."),
            ScheduleEvents("Shortify", "15:30-17:30", "LHC 006", "29.8649077,77.8937664", "Lit A.F."),
            ScheduleEvents("Quizzotica", "10:30-12:30", "LHC 006", "29.8649077,77.8937664", "Lit A.F."),
            ScheduleEvents("Corpostrat", "13:00-17:00", "LR1,DOMS", "29.8646738,77.8926466", "B-Street"),
            ScheduleEvents("Karyaneeti", "11:00-17:00", "LHC 315,316", "29.8649077,77.8937664", "B-Street"),
            ScheduleEvents("Saleution", "11:00-17:00", "LHC 003", "29.8649077,77.8937664", "B-Street"),
            ScheduleEvents("DigiPeak", "13:00-17:00", "LR2,DOMS", "29.8646738,77.8926466", "B-Street"),
            ScheduleEvents("Schlumberger day", "13:00-17:00", "LHC 103", "29.8649077,77.8937664", "Technology"),
            ScheduleEvents("FIFA '17", "11:00-17:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("Counter Strike Go", "11:00-17:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("NFS", "11:00-17:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("DOTA 2", "11:00-17:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("Let's Cube", "11:00-17:00", "LHC 006", "29.869995, 77.896328", "Gaming"),
            ScheduleEvents("AI", "11:00-17:00", "LHC 006", "29.869995, 77.896328", "Technology"),
            ScheduleEvents("teAch", "11:00-17:00", "LHC 205", "", "Technology"),
            ScheduleEvents("Verzeo AI Algo Challenge", "11:00-17:00", "LHC 003", "29.8649077,77.8937664", "Technology"),
            ScheduleEvents("Innovation Challenge", "11:00-17:00", "LHC 105", "29.8649077,77.8937664", "Innovation Conclave"),
            ScheduleEvents("Glocalisation", "11:00-17:00", "LHC 101", "29.8649077,77.8937664", "Innovation Conclave"),
            ScheduleEvents("BlockRush", "11:00-17:00", "LHC 104", "29.8649077,77.8937664", "Innovation Conclave"),
            ScheduleEvents("SMOG", "11:00-17:00", "LHC 203", "29.8649077,77.8937664", "Off the Cuff"),
            ScheduleEvents("AddictEd", "11:00-17:00", "LHC 106", "29.8649077,77.8937664", "Off the Cuff"),
            ScheduleEvents("COSC", "12:00-16:00", "LHC 301, 302, 303, 304", "29.8649077,77.8937664", "Off the Cuff"),
            ScheduleEvents("Lensational", "15:00-17:00", "OP Jain Audi", "29.863000, 77.898826", "Off the Cuff"),
            ScheduleEvents("Mobile Gaming", "23:30-0300", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming")
    )
    val scheduleDay3 = arrayListOf(
            ScheduleEvents("Amaresh Ramaswamy", "15:30-16:30", "Senate Hall", "29.8648749,77.8963164", "Guest Speaker"),
            ScheduleEvents("Gaurav Solanki", "14:00-15:00", "Senate Hall", "29.8648749,77.8963164", "Guest Speaker"),
            ScheduleEvents("Debashish Purkayastha", "11:00-12:00", "MAC Auditorium", "29.869995, 77.896328", "Guest Speaker"),
            ScheduleEvents("Prashant Jha", "12:00-13:00", "MAC Auditorium", "29.869995, 77.896328", "Guest Speaker"),
            ScheduleEvents("Armageddon", "10:00-17:00", "SBI Lawns", "29.864582, 77.895635", "Robotics"),
            ScheduleEvents("Powerdrift", "10:00-17:00", "LH Parking", "29.864929, 77.895174", "Robotics"),
            ScheduleEvents("Cyborg Breakln", "10:00-17:00", "LH Lawns", "29.869995, 77.896328", "Robotics"),
            ScheduleEvents("Aeronave", "10:00-17:00", "Football Ground", "29.867862, 77.898488", "Robotics"),
            ScheduleEvents("Poseidon", "10:00-17:00", "LHC Lawns", "29.864324, 77.893793", "Robotics"),
            ScheduleEvents("Quadrone", "10:00-17:00", "Saraswati Ground", "29.868001, 77.897255", "Robotics"),
            ScheduleEvents("Mindsweeper", "10:00-16:00", "CC Ground Floor", "29.862890, 77.896407", "Technology"),
            ScheduleEvents("Corpostrat", "10:00-17:00", "LR1,DOMS", "29.8646738,77.8926466", "B-Street"),
            ScheduleEvents("Opstruct", "13:00-17:00", "LHC 005", "29.8649077,77.8937664", "B-Street"),
            ScheduleEvents("Saleution", "11:00-17:00", "LHC 003", "29.8649077,77.8937664", "B-Street"),
            ScheduleEvents("Schlumberger day", "13:00-17:00", "LHC 103", "29.8649077,77.8937664", "Technology"),
            ScheduleEvents("Applicate", "10:00-17:00", "LHC 004", "29.8649077,77.8937664", "Technology"),
            ScheduleEvents("Yin Yang", "12:30-14:00", "LHC 006", "29.8649077,77.8937664", "Lit A.F."),
            ScheduleEvents("Quizzotica: MELA quiz", "11:00-13:00", "LHC 006", "29.8649077,77.8937664", "Lit A.F."),
            ScheduleEvents("FIFA '17", "11:00-17:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("Counter Strike Go", "11:00-17:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("NFS Most Wanted", "11:00-17:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("DOTA 2", "11:00-17:00", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("Carnival", "11:00-17:30", "Saraswati Ground", "29.868001, 77.897255", "Gaming"),
            ScheduleEvents("Let's Cube", "11:00-17:00", "LHC 004", "29.8649077,77.8937664", "Gaming"),
            ScheduleEvents("teAch", "11:00-17:00", "LHC 205", "29.8649077,77.8937664", "Technology"),
            ScheduleEvents("Verzeo AI Algo Challenge", "11:00-17:00", "TPO Hall 1stfloor", "29.8674669,77.89103679999994", "Technology"),
            ScheduleEvents("Finnacle", "11:00-17:00", "LH 1", "29.8649077,77.8937664", "Innovation Enclave"),
            ScheduleEvents("Glocalisation", "11:00-17:00", "LHC 101", "29.8649077,77.8937664", "Innovation Conclave"),
            ScheduleEvents("SMOG", "11:00-17:00", "LHC 203", "29.8649077,77.8937664", "Off the Cuff"),
            ScheduleEvents("Quizzotica: Sci Tech", "14:00-16:00", "LHC 006", "29.8649077,77.8937664", "Lit A.F."),
            ScheduleEvents("Mobile Gaming", "23:30-0300", "Ravindra Lounge", "29.8630682,77.8948558", "Gaming"),
            ScheduleEvents("UnHeard IIT Roorkee", "17:00-19:00", "MAC Auditorium", "29.869995, 77.896328", "Lit A.F.")
    )
}