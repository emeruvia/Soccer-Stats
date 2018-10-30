package emg.soccerstats.models

data class CurrentSeasonModel(
  val id: Int,
  val startDate: String,
  val endDate: String,
  val currentMatchday: Int,
    val winner: WinnerModel
)