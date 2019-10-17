package emg.soccerstats.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import emg.soccerstats.R
import emg.soccerstats.interfaces.ClickListener
import emg.soccerstats.models.CompetitionModel

class CompetitionsAdapter(competitionsList: List<CompetitionModel>) :
    RecyclerView.Adapter<CompetitionsAdapter.CompetitionsViewHolder>() {

  private var competitionsList: List<CompetitionModel> = competitionsList
  lateinit var clickListener: ClickListener

  override fun onCreateViewHolder(
    p0: ViewGroup,
    p1: Int
  ): CompetitionsViewHolder {
    val context = p0.context
    val inflater = LayoutInflater.from(context)
    val view = inflater.inflate(R.layout.competitions_cardview, p0, false)
    return CompetitionsViewHolder(view)
  }

  override fun getItemCount(): Int {
    println("size of list: " + competitionsList.size)
    return competitionsList.size
  }

  override fun onBindViewHolder(
    p0: CompetitionsViewHolder,
    p1: Int
  ) {
    p0.nameTv.text = competitionsList.get(p1).name
    p0.seasonTv.text = competitionsList.get(p1).currentSeason?.id.toString()
    p0.startDateTv.text = competitionsList.get(p1).currentSeason?.startDate
    p0.endDateTv.text = competitionsList.get(p1).currentSeason?.endDate
    p0.currentMatchDayTv.text = competitionsList.get(p1).currentSeason?.currentMatchday.toString()
    p0.tierTv.text = competitionsList.get(p1).plan
    p0.lastUpdateTv.text = competitionsList.get(p1).lastUpdated
  }


  inner class CompetitionsViewHolder(
    itemView: View
  ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var nameTv: TextView
    var seasonTv: TextView
    var startDateTv: TextView
    var endDateTv: TextView
    var currentMatchDayTv: TextView
    var tierTv: TextView
    var lastUpdateTv: TextView

    init {
      nameTv = itemView.findViewById(R.id.name_competitions_tv)
      seasonTv = itemView.findViewById(R.id.season_competition_tv)
      startDateTv = itemView.findViewById(R.id.start_date_competitions_tv)
      endDateTv = itemView.findViewById(R.id.end_date_competitions_tv)
      currentMatchDayTv = itemView.findViewById(R.id.current_day_competition_tv)
      tierTv = itemView.findViewById(R.id.tier_competition_tv)
      lastUpdateTv = itemView.findViewById(R.id.last_update_competition_tv)
    }

    override fun onClick(v: View?) {

    }

  }
}