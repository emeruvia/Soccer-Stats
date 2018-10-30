package emg.soccerstats.interfaces

import emg.soccerstats.models.CompetitionsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
  @GET("/V2/competitions")
  fun competitionsService(
    @Query("X-Auth-Token") authToken: String
  ): Call<CompetitionsModel>
}