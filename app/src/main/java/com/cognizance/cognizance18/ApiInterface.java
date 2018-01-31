package com.cognizance.cognizance18;

import com.cognizance.cognizance18.database.CentralList;
import com.cognizance.cognizance18.models.LoginResponse;
import com.cognizance.cognizance18.models.Notification;
import com.cognizance.cognizance18.models.OauthUser;
import com.cognizance.cognizance18.models.SignUpUser;
import com.cognizance.cognizance18.models.UploadFileResponse;
import com.cognizance.cognizance18.models.User;
import com.cognizance.cognizance18.models.UserDetailsResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by samagra on 6/1/18.
 */

public interface ApiInterface {
    @POST("api/login/")
    Call<LoginResponse> authenticate(@Body User user);


    @POST("api/oauth/{role}")
    Call<LoginResponse> oauthLogin(@Path("role") String role , @Body OauthUser user);

    @POST("api/signup/spp")
    Call<LoginResponse> signUp(@Body SignUpUser signUpUser);

    @POST("api/users/upload/image")
    Call<UploadFileResponse> uploadFile(@Header("Authorization") String authorization,
                                        @Header("Accept") String accept,
                                        @Header("Content-Type") String contentType,
                                        @Part MultipartBody.Part image);

    @GET("api/users/details")
    Call<UserDetailsResponse> requestDetails(@Header("Authorization") String authorization,
                                             @Header("Accept") String accept,
                                             @Header("Content-Type") String contentType);
    @GET("api/users/notifications")
    Call<Notification> getNotifications(@Header("Authorization") String authorization,
                                        @Header("Accept") String accept,
                                        @Header("Content-Type") String contentType);

    @GET("api/android/events")
    Call<CentralList> requestEvents(@Header("Authorization") String authorization,
                                    @Header("Accept") String accept,
                                    @Header("Content-type") String contentType);

}
