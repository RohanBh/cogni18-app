package com.cognizance.cognizance18.models.WorkshopModels;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Workshops{
  @SerializedName("thumbnail")
  @Expose
  private String thumbnail;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("description")
  @Expose
  private String description;
  @SerializedName("id")
  @Expose
  private Integer id;
  public void setThumbnail(String thumbnail){
   this.thumbnail=thumbnail;
  }
  public String getThumbnail(){
   return thumbnail;
  }
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setDescription(String description){
   this.description=description;
  }
  public String getDescription(){
   return description;
  }
  public void setId(Integer id){
   this.id=id;
  }
  public Integer getId(){
   return id;
  }
}