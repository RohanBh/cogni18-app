package com.cognizance.cognizance18.database;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by samagra on 16/1/18.
 */
public class CategoryList extends RealmObject {
    @SerializedName("id")
    @PrimaryKey
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("Events")
    private RealmList<EventPreview> events = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<EventPreview> getEvents() {
        return events;
    }

    public void setEvents(RealmList<EventPreview> events) {
        this.events = events;
    }

}
