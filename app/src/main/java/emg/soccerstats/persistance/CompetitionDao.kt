package emg.soccerstats.persistance

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import emg.soccerstats.models.Competition

@Dao
interface CompetitionDao {

  // TODO check about using liveData here
  @Query("SELECT * FROM competition")
  fun getAll(): List<Competition>

  @Insert
  fun insert(competition: Competition)

  @Insert
  fun insertAll(vararg competitions: Competition)

  @Delete
  fun delete(competition: Competition)

}