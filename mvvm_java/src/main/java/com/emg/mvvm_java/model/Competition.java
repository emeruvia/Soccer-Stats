package com.emg.mvvm_java.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by emeruvia on 5/22/2019.
 */
public class Competition implements Parcelable {

  private int id;
  private Area area;
  private String name;
  private String code;
  private String embelUrl;
  private String plan;
  private Season currentSeason;
  private int numberOfAvailableSeasons;
  private String lastUpdated;

  public Competition() {

  }

  public Competition(int id, Area area, String name, String code, String embelUrl,
      String plan, Season currentSeason, int numberOfAvailableSeasons, String lastUpdated) {
    this.id = id;
    this.area = area;
    this.name = name;
    this.code = code;
    this.embelUrl = embelUrl;
    this.plan = plan;
    this.currentSeason = currentSeason;
    this.numberOfAvailableSeasons = numberOfAvailableSeasons;
    this.lastUpdated = lastUpdated;
  }

  protected Competition(Parcel in) {
    id = in.readInt();
    area = in.readParcelable(Area.class.getClassLoader());
    name = in.readString();
    code = in.readString();
    embelUrl = in.readString();
    plan = in.readString();
    currentSeason = in.readParcelable(Season.class.getClassLoader());
    numberOfAvailableSeasons = in.readInt();
    lastUpdated = in.readString();
  }

  public static final Creator<Competition> CREATOR = new Creator<Competition>() {
    @Override
    public Competition createFromParcel(Parcel in) {
      return new Competition(in);
    }

    @Override
    public Competition[] newArray(int size) {
      return new Competition[size];
    }
  };

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getEmbelUrl() {
    return embelUrl;
  }

  public void setEmbelUrl(String embelUrl) {
    this.embelUrl = embelUrl;
  }

  public String getPlan() {
    return plan;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }

  public Season getCurrentSeason() {
    return currentSeason;
  }

  public void setCurrentSeason(Season currentSeason) {
    this.currentSeason = currentSeason;
  }

  public int getNumberOfAvailableSeasons() {
    return numberOfAvailableSeasons;
  }

  public void setNumberOfAvailableSeasons(int numberOfAvailableSeasons) {
    this.numberOfAvailableSeasons = numberOfAvailableSeasons;
  }

  public String getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  @Override public String toString() {
    return "Competition{" +
        "id=" + id +
        ", area=" + area +
        ", name='" + name + '\'' +
        ", code='" + code + '\'' +
        ", embelUrl='" + embelUrl + '\'' +
        ", plan='" + plan + '\'' +
        ", currentSeason=" + currentSeason +
        ", numberOfAvailableSeasons=" + numberOfAvailableSeasons +
        ", lastUpdated='" + lastUpdated + '\'' +
        '}';
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(id);
    parcel.writeParcelable(area, i);
    parcel.writeString(name);
    parcel.writeString(code);
    parcel.writeString(embelUrl);
    parcel.writeString(plan);
    parcel.writeParcelable(currentSeason, i);
    parcel.writeInt(numberOfAvailableSeasons);
    parcel.writeString(lastUpdated);
  }
}
