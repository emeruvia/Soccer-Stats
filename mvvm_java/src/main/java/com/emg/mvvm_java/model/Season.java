package com.emg.mvvm_java.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by emeruvia on 5/22/2019.
 */
public class Season implements Parcelable {

  private int id;
  private String startDate;
  private String endDate;
  private int currentMatchDay;
  // TODO implement Winner object

  public Season() {

  }

  public Season(int id, String startDate, String endDate, int currentMatchDay) {
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.currentMatchDay = currentMatchDay;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public int getCurrentMatchDay() {
    return currentMatchDay;
  }

  public void setCurrentMatchDay(int currentMatchDay) {
    this.currentMatchDay = currentMatchDay;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(id);
    parcel.writeString(startDate);
    parcel.writeString(endDate);
    parcel.writeInt(currentMatchDay);
  }

  @Override public String toString() {
    return "Season{" +
        "id=" + id +
        ", startDate='" + startDate + '\'' +
        ", endDate='" + endDate + '\'' +
        ", currentMatchDay=" + currentMatchDay +
        '}';
  }
}
