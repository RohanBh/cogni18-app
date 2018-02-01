package com.cognizance.cognizance18.interfaces

import com.cognizance.cognizance18.database.CentralList
import com.cognizance.cognizance18.models.*
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by samagra on 6/1/18.
 */
interface ApiInterface {

    @POST("api/login/")
    fun authenticate(@Body user: User): Call<LoginResponse>

    @POST("api/oauth/{role}")
    fun oauthLogin(@Path("role") role: String, @Body user: OauthUser): Call<LoginResponse>

    @POST("api/signup/spp")
    fun signUp(@Body signUpUser: SignUpUser): Call<LoginResponse>

    @POST("api/users/upload/image")
    fun uploadFile(@Header("Authorization") authorization: String,
                   @Header("Content-Type") contentType: String = "json",
                   @Part image: MultipartBody.Part): Call<UploadFileResponse>

    @GET("api/users/details")
    fun requestDetails(@Header("Authorization") authorization: String,
                       @Header("Content-Type") contentType: String = "json"): Call<UserDetailsResponse>

    @GET("api/users/notifications")
    fun getNotifications(@Header("Authorization") authorization: String,
                         @Header("Content-Type") contentType: String = "json"): Call<Notification>

    @GET("api/android/events")
    fun requestEvents(@Header("Authorization") authorization: String,
                      @Header("Content-type") contentType: String = "json"): Call<CentralList>

    @GET("/api/users/events/{id}")
    fun getEventDescription(id: Int)

    @POST("api/users/event/{id}/register")
    fun registerEvent(@Body cogniids: CogniIds)

    @POST("/api/users/event/{id}/team/{teamId}/add_member") // remove_member
    fun addMemberInEvent(memberCogniId: CogniIds)

    @POST("/api/users/event/{id}/team")
    fun getTeamForEvent(@Path("id") id: Int)

    //@POST("/api/users/events/minimal") //gives events with registered flag

    @POST("/api/users/events/registered")
    fun getRegisteredEvents()

}
