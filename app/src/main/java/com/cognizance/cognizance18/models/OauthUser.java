package com.cognizance.cognizance18.models;

/**
 * Created by samagra on 8/1/18.
 */

public class OauthUser {

    private String type;
    private String role;
    private String name;
    private String email;
    private String accessToken;
    private String dateTime;
    private String id;
    private String imageUrl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public OauthUser(   String type, String role, String name, String email, String accessToken, String dateTime, String id, String imageUrl) {

        this.type = type;
        this.role = role;
        this.name = name;
        this.email = email;
        this.accessToken = accessToken;
        this.dateTime = dateTime;
        this.id = id;
        this.imageUrl = imageUrl;
    }
}