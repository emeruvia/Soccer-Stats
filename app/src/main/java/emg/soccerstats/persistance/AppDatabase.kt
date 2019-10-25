package emg.soccerstats.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import emg.soccerstats.models.Competition

@Database(entities = [Competition::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun competitionDao(): CompetitionDao
}