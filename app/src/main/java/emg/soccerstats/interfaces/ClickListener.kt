package emg.soccerstats.interfaces

import android.view.View

interface ClickListener {
  fun itemClicked(view: View, position: Int)
}