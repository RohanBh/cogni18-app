package com.cognizance.cognizance18.models;

/**
 * Created by samagra on 12/1/18.
 */

public class UploadFileResponse {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UploadFileResponse(String message) {

        this.message = message;
    }
}
