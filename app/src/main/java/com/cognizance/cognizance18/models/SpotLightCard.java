package com.cognizance.cognizance18.models;

/**
 * Created by Narendra on 11/2/18.
 * Modifies by rohit on 14/3/18
 */

public class SpotLightCard {
    int imageid;
    String name;

    public SpotLightCard(int imageid, String name) {
        this.imageid = imageid;
        this.name = name;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
