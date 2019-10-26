package emg.soccerstats.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Competition(
  @PrimaryKey val id: Int,
  @ColumnInfo(name = "competition_name") val name: String?,
  @ColumnInfo(name = "plan") val plan: String?,
    //TODO uncomment currentSeason after figuring out how to use objects inside a room entity
//  @ColumnInfo(name = "current_season") val currentSeason: CurrentSeasonModel?,
  @SerializedName("numberOfAvailableSeasons")
  @ColumnInfo(name = "number_of_available_seasons") val seasons: Int?,
  @ColumnInfo(name = "last_updated") val lastUpdated: String?
)