package com.emg.mvvm_java.requests;

import com.emg.mvvm_java.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.emg.mvvm_java.utils.Constants.BASE_URL;

/**
 * Created by emeruvia on 5/24/2019.
 */
public class ServiceGenerator {

  private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create());

  private static Retrofit retrofit = retrofitBuilder.build();

  private static FootballDataApi footballDataApi = retrofit.create(FootballDataApi.class);

  public static FootballDataApi getFootballDataApi() {
    return footballDataApi;
  }
}
