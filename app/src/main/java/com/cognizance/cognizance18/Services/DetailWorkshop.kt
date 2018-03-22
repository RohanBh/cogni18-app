package com.cognizance.cognizance18.Services

import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.models.WorkshopModel

/**
 * Created by me on 18/3/18.
 */

object DetailWorkshop {

    val workshops = listOf(
            WorkshopModel(83,"Rekhta- Celebrating Urdu", R.string.rekhta,R.string.rekhta_benefits, R.string.rekhta_rules,
                    "Rs. 350/-", "Particpants have to take part individually.", "Venue: Chemical Department Auditorium \nTime: " +
                    "Day 1, 1100-1300 Hrs\n" + "      Day 2, 1100-1300 Hrs\n" + "      Day 3, 1100-1300 Hrs",
                    "Prashast: 8726042210"),
            WorkshopModel(12,"Ethical Hacking and Cyber Security", R.string.cyber, R.string.cyber_benefits, R.string.cyber_rules,
                    "Rs. 1100/-", "Particpants have to take part individually.", "Venue: LHC 202 IIT Roorkee\nTime: " +
                     "      Day 2, 0930-1800 Hrs\n" + "      Day 3,  0930-1800 Hrs",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),
            WorkshopModel(16,"RC Tri-Copter UAV", R.string.uav, R.string.uav_benefit, R.string.uav_rules,
                    "Rs. 1500/-", "Maximum of 5 participants can team together.", "Venue: LH2 IIT Roorkee\nTime: " +
                    "Day 1, 0930-1800 Hrs\n" +"      Day 2, 0930-1800 Hrs\n" ,
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel(28,"Fintech4Students by Abhishant Pant", R.string.fintech, R.string.fintech_beneftits, R.string.fintech_rules,
                    "Rs. 1500/-", "Particpants have to take part individually.", "Venue:ECE Dept. Auditorium \nTime: "+
                    "Day 1,0930-1800 Hrs\n" + "      Day 2, 0930-1800 Hrs\n" + "      Day 3, -",
                    "Kartikay Kaushik: 9717644916\n" + "Aashish Saxena: 9460275101"),

            WorkshopModel(68,"The Anonymous Writer Offline Session", R.string.anonywriter, R.string.anonywriter_benefits, R.string.anonywiter_rules,
                    "This workshop is free of cost", "Particpants have to take part individually.", "Venue: LHC 006 \nTime: "+ "Day 2, 1300-1530 Hrs",
                    "Prashast: 8726042210"),



            WorkshopModel(103,"Computational Fluid Dynamics", R.string.cfd, R.string.cfd_benefits, R.string.cfd_benefits,
                    "This workshop is free of cost", "Particpants have to take part individually.",
                    "Venue: Chemical Department, IIT Roorkee\nTime: "+"Day 1 1000-1800 Hrs", "Yogesh Nikose: 8171783226\n" +
                    "Shadab: 9893592931"),

            WorkshopModel(14,"Fantastic Four Robotics", R.string.ffr, R.string.ffr_benefits, R.string.ffr_rules,
                    "Rs. 1400/-", "Maximum of 5 participants can team together.", "Venue: LHC 206\nTime: "+"Day 1, 0930-1800\n" + "Day2, 0930-1800",
                    "Prashant: 8006627570\nShubhankit: 7232068467"),

            WorkshopModel(20,"IOT with Arduino", R.string.iot, R.string.iot_benefits, R.string.iot_rules,
                    "Rs. 1300/-", "Maximum of 5 participants can team together.", "Venue: Computer Centre First Floor (Lab I)\nTime: "+"Day1,0930-1800 Hrs\n"+"Day 2,0930-1800 Hrs" ,
                    "Prashant: 8006627570\nShubhankit: 7232068467"),


            WorkshopModel(21,"Social Media Marketing and SEO", R.string.seo, R.string.seo_benefits, R.string.seo_rules,
                    "Rs. 1100/-", "Particpants have to take part individually.", "Venue: LHC 301 \n" +
                    "Time: Day 2, 0930-1800 Hrs" + "      Day 3, 0930-1800 Hrs", "Prashant: 8006627570\nShubhankit: 7232068467"),

            WorkshopModel(22,"Design Thinking for Entrepreneurs", R.string.design, R.string.design_benefits, R.string.design_rules,
                    "Rs. 1200/- ", "Particpants have to take part individually.", "Venue: LHC 002\nTime: " +"Day 2, 0930-1800 Hrs" + "Day 3, 0930-1800 ",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel(90,"Microsoft Azure Infrastructure", R.string.azure, R.string.azure_benefits, R.string.azure_rules,
                    "Rs. 1200/-", "Particpants have to take part individually.", "Venue: LHC 101\nTime: \n"+"Day 2, 0930-1800 Hrs\n" + "Day 3, 0930-1800 \n",
                    "Kartikay Kaushik: 9717644916\nAashish Saxena: 9460275101"),

            WorkshopModel(24,"Sixth Sense Technology", R.string.sixth, R.string.sixth_benfits, R.string.sixth_rules,
                    "Rs. 1200/-", "Maximum of 5 participants can team together.", "Venue: Mech Department CAE lab \nTime: "+"Day 1, 0930-1800 Hrs\n"                                                                                                     + "Day 2, 0930-1800 \n",
                    "Shubhankit: 7232068467\nPrashant: 7232068467"),



            WorkshopModel(19,"Mercedes Engine Overhauling", R.string.engine, R.string.engine_benefits, R.string.engine_rules,
                    "Rs. 1200/-", "Particpants have to take part individually.", "Venue: LHC 201\nTime: "+"Day 1, 0930-1800 Hrs\n" + "Day 2, 0930-1800 \n",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel(25,"Python Programming", R.string.python, R.string.python_benefits, R.string.python_rules,
                    "Rs. 1200/-", "Particpants have to take part individually.", "Civil Department CAD Lab\n Time: \n"+"Day 1, 0930-1800 Hrs\n" + "Day 2, 0930-1800 \n",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel(23,"Android App Development", R.string.appdev, R.string.appdev_benefits, R.string.appdev_rules,
                    "Rs. 1200/-", "Particpants have to take part individually.", "Venue: LHC 004 \nTime: "+"Day 1, 0930-1800 Hrs\n" + "Day 2, 0930-1800 \n",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel(18,"Machine Learning", R.string.machine, R.string.machine_benfits, R.string.machine_rules,
                    "Rs. 1100/-", "Particpants have to take part individually.", "Venue: LHC 005\nTime: "+"Day 1, 0930-1800 Hrs\n" + "Day 2, 0930-1800 \n",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel(27,"Tall Building Design", R.string.tall, R.string.tall_benefits, R.string.tall_rules,
                    "Rs. 1100/-", "Particpants have to take part individually.", "Venue: LH 1\nTime: Day 1, 0930-1800 Hrs \n"+"Day2, 0930-1800 Hrs",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),
            WorkshopModel(133,"WorldQuant Quantitative Finance Workshop", R.string.worldQuant,R.string.worldQuantBenefits, R.string.worldQuantRules,
                    "Rs.00/-", "Particpants have to take part individually.", "Venue: LHC 202\nTime: " +
                    "Day 1, 0930-1800 Hrs\n",
                    "Akshat Mittal: 7055223255")

    )


}