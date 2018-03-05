package com.cognizance.cognizance18.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Example{
  @SerializedName("departmental")
  @Expose
  private List<Departmental> departmental;
  @SerializedName("centralStage")
  @Expose
  private List<CentralStage> centralStage;
  public void setDepartmental(List<Departmental> departmental){
   this.departmental=departmental;
  }
  public List<Departmental> getDepartmental(){
   return departmental;
  }
  public void setCentralStage(List<CentralStage> centralStage){
   this.centralStage=centralStage;
  }
  public List<CentralStage> getCentralStage(){
   return centralStage;
  }
}