package com.cognizance.cognizance18.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shashank on 11/2/18.
 */

public class Departmental {

    @SerializedName("Events")
    @Expose
    private List<Events> Events;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;

    public List<com.cognizance.cognizance18.models.Events> getEvents() {
        return Events;
    }

    public void setEvents(List<com.cognizance.cognizance18.models.Events> events) {
        Events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
