package emg.soccerstats.models

import com.google.gson.annotations.SerializedName

data class Competition(
  val id: Int,
  val name: String?,
  val plan: String?,
  val currentSeason: CurrentSeasonModel?,
  @SerializedName("numberOfAvailableSeasons")
  val seasons: Int?,
  val lastUpdated: String?
)