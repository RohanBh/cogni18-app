package com.cognizance.cognizance18.utilities;

import com.cognizance.cognizance18.interfaces.Networkservices;

/**
 * Created by shashank on 17/3/18.
 */

public class NetworkApi {

    private NetworkApi() {}

    public static final String BASE_URL="http://api.cognizance.org.in/";


    public static Networkservices getNetworkService(){
        return RetrofitClient.getClient(BASE_URL).create(Networkservices.class);
    }

}
