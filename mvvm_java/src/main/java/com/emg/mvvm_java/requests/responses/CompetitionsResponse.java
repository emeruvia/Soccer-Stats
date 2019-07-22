package com.emg.mvvm_java.requests.responses;

import com.emg.mvvm_java.model.Competition;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by emeruvia on 5/22/2019.
 */
public class CompetitionsResponse {
  @SerializedName("competitions")
  @Expose()
  private List<Competition> competitions;

  public List<Competition> getCompetitions() {
    return competitions;
  }

  @Override public String toString() {
    return "CompetitionsResponse{" +
        "competitions=" + competitions +
        '}';
  }
}
