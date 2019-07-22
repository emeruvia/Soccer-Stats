package com.emg.mvvm_java;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by emeruvia on 5/24/2019.
 */
public class AppExecutors {

  private static AppExecutors instance;

  private final ScheduledExecutorService mNetworkIO = Executors.newScheduledThreadPool(1);

  public static AppExecutors getInstance() {
    if (instance == null) {
      instance = new AppExecutors();
    }
    return instance;
  }

  public ScheduledExecutorService networkIO() {
    return mNetworkIO;
  }
}
