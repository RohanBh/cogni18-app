package com.cognizance.cognizance18;

import com.cognizance.cognizance18.models.LoginResponse;
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

    @POST("api/{email}/{password}")
    Call<String> register(@Path("email") String email, @Path("password") String password);
}
