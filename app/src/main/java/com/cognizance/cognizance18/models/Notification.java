package com.cognizance.cognizance18.models;

/**
 * Created by samagra on 12/1/18.
 */

public class Notification {
    private String message;
    private String[] notifications;

    public Notification(String message, String[] notifications) {
        this.message = message;
        this.notifications = notifications;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getNotifications() {
        return notifications;
    }

    public void setNotifications(String[] notifications) {
        this.notifications = notifications;
    }
}
