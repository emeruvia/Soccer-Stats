package com.emg.mvvm_java;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.emg.mvvm_java.model.Competition;
import com.emg.mvvm_java.repositories.CompetitionsRepository;
import com.emg.mvvm_java.utils.Testing;
import com.emg.mvvm_java.viewmodels.CompetitionsListViewModel;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";

  private CompetitionsListViewModel mCompetitionsListViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Reference and instantiation of ViewModel
    mCompetitionsListViewModel = ViewModelProviders.of(this).get(CompetitionsListViewModel.class);
  }

  public void fetchCompetitions(View view) {
    // TODO fetch data from Competitions
    Toast.makeText(this, "Pressed.", Toast.LENGTH_SHORT).show();
    //mCompetitionsListViewModel.getCompetitions().observe(this, new Observer<List<Competition>>() {
    //  @Override public void onChanged(List<Competition> competitionList) {
    //    if (competitionList != null) {
    //      Log.d(TAG, "onChanged: something");
    //      Testing.printCompetitions(competitionList, TAG);
    //    }
    //  }
    //});
    CompetitionsRepository.getInstance().requestCompetitionsApi();
  }
}
