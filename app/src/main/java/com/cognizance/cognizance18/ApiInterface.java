package com.cognizance.cognizance18;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by samagra on 6/1/18.
 */

public interface ApiInterface {
    @GET("api/login/{email}/{password}")
    Call<String> authenticate(@Path("user") String email, @Path("password") String password);

    @POST("api/{email}/{password}")
    Call<String> register(@Path("email") String email, @Path("password") String password);
}
