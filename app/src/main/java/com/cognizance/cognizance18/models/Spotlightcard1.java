package com.cognizance.cognizance18.models;

/**
 * Created by me on 12/2/18.
 */

public class Spotlightcard1 {
    int imageid;
    String name;

    public Spotlightcard1(int imageid, String name) {
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
