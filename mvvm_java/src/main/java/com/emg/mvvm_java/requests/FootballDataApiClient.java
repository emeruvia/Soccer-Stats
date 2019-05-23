package com.emg.mvvm_java.requests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.emg.mvvm_java.model.Competition;
import java.util.List;

/**
 * Created by emeruvia on 5/22/2019.
 */
public class FootballDataApiClient {

  private static FootballDataApiClient instance;

  private MutableLiveData<List<Competition>> mCompetitions;

  public static FootballDataApiClient getInstance() {
    if (instance == null) {
      instance = new FootballDataApiClient();
    }
    return instance;
  }

  private FootballDataApiClient() {
    mCompetitions = new MutableLiveData<>();
  }

  public LiveData<List<Competition>> getCompetitions() {
    return mCompetitions;
  }

  public void getCompetitionsApi() {

  }
}
