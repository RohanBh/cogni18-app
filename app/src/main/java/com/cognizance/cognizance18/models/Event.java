package com.cognizance.cognizance18.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by samagra on 16/1/18.
 */

public class Event {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("teamLimit")
    @Expose
    private String teamLimit;
    @SerializedName("tagline")
    @Expose
    private String tagline;
    @SerializedName("abstract")
    @Expose
    private Boolean _abstract;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("problemStatement")
    @Expose
    private String problemStatement;
    @SerializedName("prize")
    @Expose
    private String prize;
    @SerializedName("rules")
    @Expose
    private String rules;
    @SerializedName("procedure")
    @Expose
    private String procedure;
    @SerializedName("cost")
    @Expose
    private String cost;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("contact")
    @Expose
    private List<Contact> contact = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeamLimit() {
        return teamLimit;
    }

    public void setTeamLimit(String teamLimit) {
        this.teamLimit = teamLimit;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Boolean getAbstract() {
        return _abstract;
    }

    public void setAbstract(Boolean _abstract) {
        this._abstract = _abstract;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }
    public Event(){
        this.name = "test";
        this.description = "test";
        this.teamLimit = "test";
        this.tagline = "test";
        this._abstract = true;
        this.type = "test";
        this.problemStatement = "test";
        this.prize = "test";
        this.rules = "test";
        this.procedure = "test";
        this.cost = "test";
        this.venue = "test";
        this.contact = null;

    }

    public Event(String name,
                 String description,
                 String teamLimit,
                 String tagline,
                 Boolean _abstract,
                 String type,
                 String problemStatement,
                 String prize,
                 String rules,
                 String procedure,
                 String cost,
                 String venue,
                 List<Contact> contact) {
        this.name = name;
        this.description = description;
        this.teamLimit = teamLimit;
        this.tagline = tagline;
        this._abstract = _abstract;
        this.type = type;
        this.problemStatement = problemStatement;
        this.prize = prize;
        this.rules = rules;
        this.procedure = procedure;
        this.cost = cost;
        this.venue = venue;
        this.contact = contact;
    }
}


