package emg.soccerstats.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import emg.soccerstats.models.Competition

@Database(entities = [Competition::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun competitionDao(): CompetitionDao

  //TODO check for better way of instantiating DB
  companion object {
    private const val DB_NAME = "app_db"
    private var INSTANCE: AppDatabase? = null
    fun getInstance(context: Context): AppDatabase? {
      if (INSTANCE == null) {
        synchronized(AppDatabase::class) {
          INSTANCE = Room.databaseBuilder(
              context.applicationContext,
              AppDatabase::class.java,
              DB_NAME
          )
              .build()
        }
      }
      return INSTANCE
    }
  }

}