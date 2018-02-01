package com.cognizance.cognizance18.models

/**
 * Created by rohan on 18/1/18.
 */
data class NavMenuGridItem @JvmOverloads constructor(val text: String, val imageResource: Int? = null)

// Use joinToString()
data class CogniIds @JvmOverloads constructor(val teamMembers: String)

data class singleCogniId(val memberCogniId: String)


