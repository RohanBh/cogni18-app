package com.cognizance.cognizance18.database;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by samagra on 16/1/18.
 */

public class CentralList extends RealmObject {
    @SerializedName("centralStage")
    @Expose
    private RealmList<CategoryCenterStage> centralStage = null;
    @SerializedName("departmental")
    @Expose
    private RealmList<CategoryDepartmental> departmental = null;

    public RealmList<CategoryCenterStage> getCentralStage() {
        return centralStage;
    }

    public void setCentralStage(RealmList<CategoryCenterStage> centralStage) {
        this.centralStage = centralStage;
    }

    public RealmList<CategoryDepartmental> getDepartmental() {
        return departmental;
    }

    public void setDepartmental(RealmList<CategoryDepartmental> departmental) {
        this.departmental = departmental;
    }
}
