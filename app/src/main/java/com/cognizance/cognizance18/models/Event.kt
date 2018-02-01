package com.cognizance.cognizance18.models

import com.google.gson.annotations.SerializedName

/**
 * Created by rohan on 23/12/17.
 */
data class Event(@SerializedName("name")
                 var name: String? = null,
                 @SerializedName("description")
                 var description: String? = null,
                 @SerializedName("teamLimit")
                 var teamLimit: String? = null,
                 @SerializedName("tagline")
                 var tagline: String? = null,
                 @SerializedName("abstract")
                 var abstract: Boolean? = null,
                 @SerializedName("type")
                 var type: String? = null,
                 @SerializedName("problemStatement")
                 var problemStatement: String? = null,
                 @SerializedName("prize")
                 var prize: String? = null,
                 @SerializedName("rules")
                 var rules: String? = null,
                 @SerializedName("procedure")
                 var procedure: String? = null,
                 @SerializedName("cost")
                 var cost: String? = null,
                 @SerializedName("venue")
                 var venue: String? = null,
                 @SerializedName("contact")
                 var contact: List<Contact>? = null)
