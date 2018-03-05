package com.cognizance.cognizance18.interfaces;

import com.cognizance.cognizance18.models.Events;
import com.cognizance.cognizance18.models.WorkshopModels.WorkshopResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by shashank on 11/2/18.
 */

public interface Networkservices {
    @GET(NetworkConstants.REST_EVENTS)
    Call<Events> getEventList(@Header("Authorisation") String token);

    @GET(NetworkConstants.REST_TRENDING)
    Call<WorkshopResponse> getWorkshopList(@Header("Authorisation") String token);


}
