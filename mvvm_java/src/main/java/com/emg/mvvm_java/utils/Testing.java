package com.emg.mvvm_java.utils;

import android.util.Log;
import com.emg.mvvm_java.model.Competition;
import java.util.List;

/**
 * Created by emeruvia on 5/23/2019.
 */
public class Testing {

  public static void printCompetitions(List<Competition> competitionList, String tag) {
    for (Competition competition : competitionList) {
      Log.d(tag, "Competition: " + competition.getName());
    }
  }
}
