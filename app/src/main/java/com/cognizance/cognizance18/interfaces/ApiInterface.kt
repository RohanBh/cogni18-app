package com.cognizance.cognizance18.interfaces

import com.cognizance.cognizance18.database.CentralList
import com.cognizance.cognizance18.database.EventPreview
import com.cognizance.cognizance18.models.*
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by samagra on 6/1/18.
 */
interface ApiInterface {

    /**
     * This function is used to Login user using email and password.
     */
    @POST("api/login/")
    fun authenticate(@Body user: User): Call<LoginResponse>

    /**
     * This is used to Login user using gmail/fb account.
     */
    @POST("api/oauth/{role}")
    fun oauthLogin(@Path("role") role: String, @Body user: OauthUser): Call<LoginResponse>

    /**
     * Used to signup/register user taking email, pass, name, type and mobile.
     */
    @POST("api/signup/cogni_user")
    fun signUp(@Body signUpUser: SignUpUser): Call<LoginResponse>

    /**
     * Used to upload user image.
     */
    @POST("api/users/upload/image")
    fun uploadFile(@Header("Authorization") authorization: String,
                   @Part image: MultipartBody.Part): Call<UploadFileResponse>

    /**
     * Get details filled by user.
     */
    @GET("api/users")
    fun requestDetails(@Header("Authorization") authorization: String): Call<UserDetailsResponse>

    /**
     * Post user details from the FORM.
     */
    @POST("api/users")
    fun postDetails(@Header("Authorization") authorization: String, userDetails: PostUserDetails)

    @GET("api/users/notifications")
    fun getNotifications(@Header("Authorization") authorization: String): Call<Notification>

    /**
     * Get CentralStage and Departmental events
     */
    @GET("api/android/events")
    fun requestEvents(@Header("Authorization") authorization: String): Call<CentralList>

    @GET("/api/android/event/{id}")
    fun getEventDescription(@Header("Authorization") authorization: String,
                            @Path("id") id: Int): Call<EventPreview>

    @POST("api/users/events/{id}/register")
    fun registerEvent(@Header("Authorization") authorization: String,
                      @Path("id") eventId: Int, @Body cogniids: CogniIds): Call<ResponseMessage>

    /**
     * Unregister from an event. <br>
     * If a team member unregisters, he/she will be removed from the team.<br>
     * If that team member is the <b>leader</b>, then the whole team will be disbanded.
     */
    @GET("api/users/event/{id}/unregister")
    fun unregisterEvent(@Header("Authorization") authorization: String,
                        @Path("id") eventId: Int)

    @POST("/api/users/event/{event_id}/team/{team_id}/add_member")
    fun addMemberInEvent(
            @Header("Authorization") authorization: String,
            @Path("event_id") eventId: Int,
            @Path("team_id") teamId: Int,
            memberCogniId: SingleCogniId
    ): Call<ResponseMessage>

    @POST("/api/users/event/{event_id}/team/{team_id}/remove_member")
    fun removeMemberInEvent(
            @Header("Authorization") authorization: String,
            @Path("event_id") eventId: Int,
            @Path("team_id") teamId: Int,
            memberCogniId: SingleCogniId
    ): Call<ResponseMessage>

    @GET("/api/users/event/{id}/team")
    fun getTeamForEvent(@Header("Authorization") authorization: String,
                        @Path("id") id: Int): Call<MemberList>

    //@POST("/api/users/events/minimal") //gives events with registered flag

    @GET("/api/users/events/registered")
    fun getRegisteredEvents(@Header("Authorization") authorization: String): Call<List<Event>>

    @GET("api/workshops")
    fun getWorkshopList(@Header("Authorization") authorization: String): Call<WorkshopList>
    // /api/workshops array of workshops : (id, name, desc, thumbnail)

    @GET("api/trending")
    fun getTrendings(@Header("Authorization") authorization: String): Call<TrendingList>
    // api/trendings object : Trending (events(id ,name , thumbnail,
    // tags(comma separated string )), type : spotlight, workshop)

}
