package com.cognizance.cognizance18.models;

import java.util.ArrayList;

/**
 * Created by arihant on 15/12/17.
 */

public class EventCategory {

    private String name;
    private ArrayList<Event> eventList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }
}
