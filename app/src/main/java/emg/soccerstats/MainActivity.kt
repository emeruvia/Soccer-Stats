package emg.soccerstats

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import emg.soccerstats.adapters.CompetitionsAdapter
import emg.soccerstats.interfaces.RetrofitService
import emg.soccerstats.models.CompetitionsModel
import emg.soccerstats.utils.RetrofitClient

import emg.soccerstats.interfaces.ClickListener
import emg.soccerstats.models.Competition
import emg.soccerstats.utils.Secrets
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainActivity : AppCompatActivity(), ClickListener {

  private lateinit var competitionsList: List<Competition>

  private var progressBar: ProgressBar? = null
  private var recyclerView: RecyclerView? = null
  private var errorTextView: TextView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    Timber.d("onCreate called")

    progressBar = findViewById(R.id.progress_bar)
    recyclerView = findViewById(R.id.recyclerViewId)
    errorTextView = findViewById(R.id.error_textview)

    competitionsList = arrayListOf()
    loadAPIData()
    val layoutManager = LinearLayoutManager(this)
    recyclerView!!.layoutManager = layoutManager

  }

  fun loadAPIData() {
    progressBar!!.visibility = View.VISIBLE
    val retrofit = RetrofitClient().buildClient()
    val service = retrofit.create(RetrofitService::class.java)
    val call =
      service.competitionsService(Secrets.API_KEY)
    call.enqueue(object : Callback<CompetitionsModel> {
      override fun onResponse(
        call: Call<CompetitionsModel>,
        response: Response<CompetitionsModel>
      ) {
        val test: CompetitionsModel? = response.body()
        if (test != null) {
          progressBar!!.visibility = View.GONE
          errorTextView!!.text = "Data fetched"
          Timber.d("onResponse(): Successfully connected to the API")
          Timber.d("onResponse(): $response.message()")
          Timber.d("onResponse $response.body().toString()")
          Timber.d("onResponse(): $response.isSuccessful.toString()")
          Timber.d("onResponse(): $response.headers().toString()")
          Timber.d("onResponse(): $response.raw().toString()")
          val competitions = response.body()
          competitionsList = competitions!!.competitions
          competitionsList.forEach { i -> println(i.toString()) }
          recyclerView!!.visibility = View.VISIBLE
          recyclerView!!.adapter = CompetitionsAdapter(competitionsList)
        }
      }

      override fun onFailure(
        call: Call<CompetitionsModel>,
        t: Throwable
      ) {
        Timber.d("onFailure(): Can't connect to API")
        Timber.e("onFailure(): $t")
        progressBar!!.visibility = View.GONE
        errorTextView!!.text = "Network Error, try again later"
      }
    })
  }

  override fun itemClicked(
    view: View,
    position: Int
  ) {
    Timber.d("itemClicked(): clicked on pos: $position")
  }
}
