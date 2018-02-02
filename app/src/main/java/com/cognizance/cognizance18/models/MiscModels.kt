package com.cognizance.cognizance18.models

/**
 * Created by rohan on 18/1/18.
 */
data class NavMenuGridItem @JvmOverloads constructor(val text: String, val imageResource: Int? = null)

// Use joinToString()
data class CogniIds constructor(val teamMembers: String)

data class SingleCogniId(val memberCogniId: String)

data class PostUserDetails(
        val state: String,
        val college: String,
        val address: String,
        val city: String,
        val gender: String,
        val year: String,
        val branch: String,
        val pincode: String,
        val mobile: String
) {
    init {
        if (gender != "M" || gender != "F") throw IllegalArgumentException("gender must be either M or F")
    }
}

data class Member(
        val id: Int,
        val name: String,
        val college: String,
        val leader: Boolean
)

data class MemberList(val members: List<Member>)

data class Workshop(
        val id: Int,
        val name: String,
        val description: String,
        val thumbnail: String
)

data class WorkshopList(val workshops: List<Workshop>)

/**
 * Tags will be comma separated string
 */
data class Trendings(
        val id: Int,
        val name: String,
        val thumbnail: String,
        val tags: String,
        val type: String // in lowercase
)

data class TrendingList(val events: List<Trendings>)

data class ResponseMessage(val message: String)
