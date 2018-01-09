package com.cognizance.cognizance18;

import com.cognizance.cognizance18.models.LoginResponse;
<<<<<<< HEAD
import com.cognizance.cognizance18.models.OauthUser;
=======
import com.cognizance.cognizance18.models.SignUpUser;
>>>>>>> sign_up
import com.cognizance.cognizance18.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
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

}
