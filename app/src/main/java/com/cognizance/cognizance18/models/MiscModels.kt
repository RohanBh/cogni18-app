package com.cognizance.cognizance18.models

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by rohan on 18/1/18.
 */
open class NavMenuGridItem @JvmOverloads constructor(
        var text: String? = null,
        var imageResource: Int? = null
)

// Use joinToString()
open class CogniIds constructor(var teamMembers: String? = null)

open class SingleCogniId(var memberCogniId: String? = null)

open class PostUserDetails(
        var state: String,
        var college: String,
        var address: String,
        var city: String,
        var gender: String,
        var year: String,
        var branch: String,
        var pincode: String,
        var mobile: String
) {
    init {
        if (gender != "M" || gender != "F") throw IllegalArgumentException("gender must be either M or F")
    }
}

open class Member @JvmOverloads constructor(
        @PrimaryKey var id: Int = 0,
        var name: String? = null,
        var college: String? = null,
        var leader: Boolean = false
) : RealmObject()

open class MemberList @JvmOverloads constructor(
        var members: RealmList<Member>? = null) : RealmObject()

open class Workshop @JvmOverloads constructor(
        @PrimaryKey var id: Int = 0,
        var name: String? = null,
        var description: String? = null,
        var thumbnail: String? = null
) : RealmObject()

open class WorkshopList @JvmOverloads constructor(
        var workshops: RealmList<Workshop>? = null) : RealmObject()

/**
 * Tags will be comma separated string
 */
open class Trendings @JvmOverloads constructor(
        @PrimaryKey var id: Int = 0,
        var name: String? = null,
        var thumbnail: String? = null,
        var tags: String? = null,
        var type: String? = null // in lowercase
) : RealmObject()

open class TrendingList @JvmOverloads constructor(
        var events: RealmList<Trendings>? = null) : RealmObject()

open class ResponseMessage @JvmOverloads constructor(var message: String? = null)
