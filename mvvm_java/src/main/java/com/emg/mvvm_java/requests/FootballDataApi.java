package com.emg.mvvm_java.requests;

import com.emg.mvvm_java.requests.responses.CompetitionsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by emeruvia on 5/22/2019.
 */
public interface FootballDataApi {
  // Competitions Request
  @GET("/v2/competitions")
  Call<CompetitionsResponse> requestCompetitions(
      @Query("X-Auth-Token") String authToken
  );
}
