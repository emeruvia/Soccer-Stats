package emg.soccerstats.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
  private var retrofit: Retrofit? = null

  fun buildClient(): Retrofit {
    if (retrofit == null) {
      retrofit = Retrofit.Builder()
          .baseUrl(baseUrl)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
    }
    return retrofit!!
  }
  companion object {
    val baseUrl: String = "http://api.football-data.org"
  }
}