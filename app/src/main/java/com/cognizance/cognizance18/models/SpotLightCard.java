package com.cognizance.cognizance18.models;

/**
 * Created by Narendra on 11/2/18.
 */

public class SpotLightCard {
    int imageId;
    String name;

    public SpotLightCard(){

    }

    public SpotLightCard(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
