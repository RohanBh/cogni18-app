package com.cognizance.cognizance18.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by samagra on 16/1/18.
 */

public class EventDescriptionResponse {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("event")
    @Expose
    private Event event;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "EventDescriptionResponse{" +
                "message='" + message + '\'' +
                ", event=" + event +
                '}';
    }
}
