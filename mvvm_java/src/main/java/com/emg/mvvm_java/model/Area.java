package com.emg.mvvm_java.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/**
 * Created by emeruvia on 5/22/2019.
 */
public class Area implements Parcelable {

  private int id;
  private String name;

  public Area() {

  }

  public Area(int id, String name) {
    this.id = id;
    this.name = name;
  }

  protected Area(Parcel in) {
    id = in.readInt();
    name = in.readString();
  }

  public static final Creator<Area> CREATOR = new Creator<Area>() {
    @Override
    public Area createFromParcel(Parcel in) {
      return new Area(in);
    }

    @Override
    public Area[] newArray(int size) {
      return new Area[size];
    }
  };

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override public String toString() {
    return "Area{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(id);
    parcel.writeString(name);
  }
}
