package com.cognizance.cognizance18.models;

/**
 * Created by samagra on 16/1/18.
 */

public class EventListResponse {
    private String message;
    private Name[] name;

    public EventListResponse(String message, Name[] name) {
        this.message = message;
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Name[] getName() {
        return name;
    }

    public void setName(Name[] name) {
        this.name = name;
    }
}
