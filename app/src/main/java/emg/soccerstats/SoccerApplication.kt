package emg.soccerstats

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

class SoccerApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    if (BuildConfig.DEBUG) Timber.plant(DebugTree())
  }

}