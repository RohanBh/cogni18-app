@file:JvmName("ApiUtils")
package com.cognizance.cognizance18.utilities

import com.cognizance.cognizance18.interfaces.ApiInterface
import com.cognizance.cognizance18.interfaces.Networkservices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val BASE_URL = "https://api.cognizance.org.in/"

fun getInterfaceService(): ApiInterface {
    val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    return retrofit.create(ApiInterface::class.java)

}


    fun getApiService():Networkservices {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(Networkservices::class.java)
    }



