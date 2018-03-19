package com.cognizance.cognizance18.models.EventDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class EventD {

    private String info,procedure,rules;
    private int id;


    public EventD(){

    }

    public EventD(Integer id,String info,String procedure,String rules){
        this.id=id;
        this.info=info;
        this.procedure=procedure;
        this.rules=rules;

    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //    @SerializedName("id")
//    @Expose
//    private Integer id;
//
//    @SerializedName("info")
//    @Expose
//    private String info;
//
//    @SerializedName("procedure")
//    @Expose
//    private String procedure;
//
//    @SerializedName("rules")
//    @Expose
//    private String rules;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getInfo() {
//        return info;
//    }
//
//    public void setInfo(String info) {
//        this.info = info;
//    }
//
//    public String getProcedure() {
//        return procedure;
//    }
//
//    public void setProcedure(String procedure) {
//        this.procedure = procedure;
//    }
//
//    public String getRules() {
//        return rules;
//    }
//
//    public void setRules(String rules) {
//        this.rules = rules;
//    }
}