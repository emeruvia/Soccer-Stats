package com.emg.mvvm_java.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.emg.mvvm_java.model.Competition;
import com.emg.mvvm_java.repositories.CompetitionsRepository;
import java.util.List;

/**
 * Created by emeruvia on 5/24/2019.
 */
public class CompetitionsListViewModel extends ViewModel {

  private CompetitionsRepository mCompetitionsRepository;

  public CompetitionsListViewModel() {
    mCompetitionsRepository = CompetitionsRepository.getInstance();
  }

  public LiveData<List<Competition>> getCompetitions() {
    return mCompetitionsRepository.getCompetitions();
  }

  public void requestCompetitionsApi() {
    mCompetitionsRepository.requestCompetitionsApi();
  }
}
