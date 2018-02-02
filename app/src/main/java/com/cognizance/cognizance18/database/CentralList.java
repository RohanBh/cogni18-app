package com.cognizance.cognizance18.database;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by samagra on 16/1/18.
 */
public class CentralList extends RealmObject {
    @SerializedName("centralStage")
    private RealmList<CategoryList> centralStage = null;
    @SerializedName("departmental")
    private RealmList<CategoryList> departmental = null;

    public RealmList<CategoryList> getCentralStage() {
        return centralStage;
    }

    public void setCentralStage(RealmList<CategoryList> centralStage) {
        this.centralStage = centralStage;
    }

    public List<CategoryList> getDepartmental() {
        return departmental;
    }

    public void setDepartmental(RealmList<CategoryList> departmental) {
        this.departmental = departmental;
    }
}
