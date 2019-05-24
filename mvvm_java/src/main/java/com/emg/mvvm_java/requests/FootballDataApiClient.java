package com.emg.mvvm_java.requests;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.emg.mvvm_java.AppExecutors;
import com.emg.mvvm_java.model.Competition;
import com.emg.mvvm_java.requests.responses.CompetitionsResponse;
import com.emg.mvvm_java.utils.Secrets;
import com.emg.mvvm_java.utils.Testing;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import retrofit2.Call;
import retrofit2.Response;

import static com.emg.mvvm_java.utils.Constants.NETWORK_TIMEOUT;
import static com.emg.mvvm_java.utils.Secrets.API_KEY;

/**
 * Created by emeruvia on 5/22/2019.
 */
public class FootballDataApiClient {

  private static final String TAG = "FootballDataApiClient";

  private static FootballDataApiClient instance;
  private MutableLiveData<List<Competition>> mCompetitions;
  private RetrieveCompetitionsRunnable mRetrieveCompetitionsRunnable;

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

  public void requestCompetitionsApi() {
    if (mRetrieveCompetitionsRunnable != null) {
      mRetrieveCompetitionsRunnable = null;
    }
    mRetrieveCompetitionsRunnable = new RetrieveCompetitionsRunnable();
    final Future handler =
        AppExecutors.getInstance().networkIO().submit(mRetrieveCompetitionsRunnable);

    AppExecutors.getInstance().networkIO().schedule(new Runnable() {
      @Override public void run() {
        handler.cancel(true);
      }
    }, NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
  }

  private class RetrieveCompetitionsRunnable implements Runnable {

    boolean cancelRequest;

    public RetrieveCompetitionsRunnable() {
      this.cancelRequest = false;
    }

    @Override public void run() {
      try {
        Response response = getCompetitions().execute();
        if (cancelRequest) {
          return;
        }

        // Successful request was made
        if (response.code() == 200) {
          List<Competition> list =
              new ArrayList<>(((CompetitionsResponse) response.body()).getCompetitions());
          mCompetitions.postValue(list);
          Testing.printCompetitions(list, TAG);
        }
      } catch (IOException e) {
        e.printStackTrace();
        mCompetitions.postValue(null);
      }
    }

    private Call<CompetitionsResponse> getCompetitions() {
      return ServiceGenerator.getFootballDataApi().requestCompetitions(API_KEY);
    }

    private void cancelRequest() {
      Log.d(TAG, "cancelRequest: canceling the competitions request");
      cancelRequest = true;
    }
  }
}
