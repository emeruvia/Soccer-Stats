package com.emg.mvvm_java.repositories;

import androidx.lifecycle.LiveData;
import com.emg.mvvm_java.model.Competition;
import com.emg.mvvm_java.requests.FootballDataApiClient;
import java.util.List;

/**
 * Created by emeruvia on 5/22/2019.
 */
public class CompetitionsRepository {

  private static CompetitionsRepository instance;
  private FootballDataApiClient mFootballApiClient;

  public static CompetitionsRepository getInstance() {
    if (instance == null) {
      instance = new CompetitionsRepository();
    }
    return instance;
  }

  private CompetitionsRepository() {
    mFootballApiClient = FootballDataApiClient.getInstance();
  }

  public LiveData<List<Competition>> getCompetitions() {
    return mFootballApiClient.getCompetitions();
  }

  // TODO simple method returns list of competitions
  public void requestCompetitionsApi() {
    mFootballApiClient.requestCompetitionsApi();
  }

}
