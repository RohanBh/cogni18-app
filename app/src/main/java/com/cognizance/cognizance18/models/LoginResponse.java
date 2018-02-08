package com.cognizance.cognizance18.models;

import android.util.Log;

/**
 * Created by samagra on 7/1/18.
 */

public class LoginResponse {
    private String message;
    private String email;
    private String token;
    private String role;
    private String name;

    public LoginResponse(String message, String email, String token, String role, String name) {
        this.message = message;
        this.email = email;
        this.token = token;
        this.role = role;
        this.name = name;

    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    @Override
    public String toString() {
        return "{ message : " + message + ", email : " + email +
                ", token : " + token + ", role : " + role + ", name : " + name + "}";
    }
}
