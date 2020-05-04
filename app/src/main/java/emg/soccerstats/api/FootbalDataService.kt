package emg.soccerstats.api

import emg.soccerstats.models.Competition
import emg.soccerstats.models.CompetitionsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FootbalDataService {
  @GET("/v2/competitions")
  fun competitionsService(
    @Query("X-Auth-Token") authToken: String
  ): Call<CompetitionsModel>
}