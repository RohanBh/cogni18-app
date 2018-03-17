package com.cognizance.cognizance18.Services

import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.models.WorkshopModel

/**
 * Created by me on 18/3/18.
 */

object DetailWorkshop {

    val workshops = listOf(
            WorkshopModel("Nano Technology", R.string.nano_technology, R.string.nano_technology_benefits, R.string.nano_techonlogy_rules,
                    "Rs. 1200/-", "Maximum of 5 participants can team together.", "Venue: IIT Roorkee \nTime: -",
                    "Shubankit: 7232068467 \nPrashant: 8006627570"),

            WorkshopModel("Fintech4Students by Abhishant Pant", R.string.fintech, R.string.fintech_beneftits, R.string.fintech_rules,
                    "Rs. 1500/-", "Particpants have to take part individually.", "Venue: IIT Roorkee \nTime: -",
                    "Kartikay Kaushik: 9717644916\n" + "Aashish Saxena: 9460275101"),

            WorkshopModel("The Anonymous Writer Offline Session", R.string.anonywriter, R.string.anonywriter_benefits, R.string.anonywiter_rules,
                    "This workshop is free of cost", "Particpants have to take part individually.", "Venue: IIT Roorkee \nTime: Day 2, 1300-1500 Hrs",
                    "Prashast: 8726042210"),

            WorkshopModel("Rekhta- Celebrating Urdu", R.string.rekhta,R.string.rekhta_benefits, R.string.rekhta_rules,
                    "Rs. 350/-", "Particpants have to take part individually.", "Venue: IIT Roorkee\nTime: " +
                    "Day 1, 1100-1300 Hrs\n" + "      Day 2, 1100-1300 Hrs\n" + "      Day 3, 1100-1300 Hrs",
                    "Prashast: 8726042210"),

            WorkshopModel("Computational Fluid Dynamics", R.string.cfd, R.string.cfd_benefits, R.string.cfd_benefits,
                    "This workshop is free of cost", "Particpants have to take part individually.",
                    "Venue: Chemical Department, IIT Roorkee\nTime: -", "Yogesh Nikose: 8171783226\n" +
                    "Shadab: 9893592931"),

            WorkshopModel("Fantastic Four Robotics", R.string.ffr, R.string.ffr_benefits, R.string.ffr_rules,
                    "Rs. 1400/-", "Maximum of 5 participants can team together.", "Venue: IIT Roorkee\nTime: -",
                    "Prashant: 8006627570\nShubhankit: 7232068467"),

            WorkshopModel("IOT with Arduino", R.string.iot, R.string.iot_benefits, R.string.iot_rules,
                    "Rs. 1300/-", "Maximum of 5 participants can team together.", "Venue: IIT Roorkee\nTime: -",
                    "Prashant: 8006627570\nShubhankit: 7232068467"),

            WorkshopModel("Embedded Systems 8051", R.string.embedded, R.string.embedded_benefits, R.string.embedded_rules,
                    "Rs. 1200/-", "Maximum of 5 participants can team together.", "Venue: IIT Roorkee\nTime: -",
                    "Prashant: 8006627570\nShubhankit: 7232068467"),

            WorkshopModel("Social Media Marketing and SEO", R.string.seo, R.string.seo_benefits, R.string.seo_rules,
                    "Rs. 1100/-", "Particpants have to take part individually.", "Venue: IIT Roorkee \n" +
                    "Time: Day 2, 1030-1800 Hrs" + "      Day 3, 1000-1800 Hrs", "Prashant: 8006627570\nShubhankit: 7232068467"),

            WorkshopModel("Design Thinking for Entrepreneurs", R.string.design, R.string.design_benefits, R.string.design_rules,
                    "Rs. 1200/- ", "Particpants have to take part individually.", "Venue: IIT Roorkee\nTime: Day 2, 1000-1800 Hrs",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel("Microsoft Azure Infrastructure", R.string.azure, R.string.azure_benefits, R.string.azure_rules,
                    "Rs. 1200/-", "Particpants have to take part individually.", "Venue: IIT Roorkee\nTime: -",
                    "Kartikay Kaushik: 9717644916\nAashish Saxena: 9460275101"),

            WorkshopModel("Sixth Sense Technology", R.string.sixth, R.string.sixth_benfits, R.string.sixth_rules,
                    "Rs. 1200/-", "Maximum of 5 participants can team together.", "Venue: IIT Roorkee\nTime: -",
                    "Shubhankit: 7232068467\nPrashant: 7232068467"),

            WorkshopModel("RC Tri-Copter UAV", R.string.uav, R.string.uav_benefit, R.string.uav_rules,
                    "Rs. 1500/-", "Maximum of 5 participants can team together.", "Venue: IIT Roorkee\nTime: -",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel("Mercedes Engine Overhauling", R.string.engine, R.string.engine_benefits, R.string.engine_rules,
                    "Rs. 1200/-", "Particpants have to take part individually.", "Venue: IIT Roorkee\nTime: -",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel("Python Programming", R.string.python, R.string.python_benefits, R.string.python_rules,
                    "Rs. 1200/-", "Particpants have to take part individually.", "Venue: IIT Roorkee\nTime: -",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel("Ethical Hacking and Cyber Security", R.string.cyber, R.string.cyber_benefits, R.string.cyber_rules,
                    "Rs. 1100/-", "Particpants have to take part individually.", "Venue: IIT Roorkee\nTime: -",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel("Android App Development", R.string.appdev, R.string.appdev_benefits, R.string.appdev_rules,
                    "Rs. 1200/-", "Particpants have to take part individually.", "Venue: IIT Roorkee\nTime: -",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel("Machine Learning", R.string.machine, R.string.machine_benfits, R.string.machine_rules,
                    "Rs. 1100/-", "Particpants have to take part individually.", "Venue: IIT Roorkee\nTime: -",
                    "Shubhankit: 7232068467\nPrashant: 8006627570"),

            WorkshopModel("Tall Building Design", R.string.tall, R.string.tall_benefits, R.string.tall_rules,
                    "Rs. 1100/-", "Particpants have to take part individually.", "Venue: IIT Roorkee\nTime: Day 1, 1000-1800 Hrs",
                    "Shubhankit: 7232068467\nPrashant: 8006627570")
    )
}