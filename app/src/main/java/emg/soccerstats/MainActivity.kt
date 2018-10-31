package emg.soccerstats

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

import emg.soccerstats.adapters.CompetitionsAdapter
import emg.soccerstats.interfaces.RetrofitService
import emg.soccerstats.models.CompetitionsModel
import emg.soccerstats.utils.RetrofitClient

import emg.soccerstats.interfaces.ClickListener
import emg.soccerstats.models.CompetitionModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), ClickListener {

  private lateinit var competitionsList: List<CompetitionModel>

  private var progressBar: ProgressBar? = null
  private var recyclerView: RecyclerView? = null
  private var errorTextView: TextView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    progressBar = findViewById(R.id.progress_bar)
    recyclerView = findViewById(R.id.recyclerViewId)
    errorTextView = findViewById(R.id.error_textview)

    competitionsList = ArrayList()
    loadAPIData()
    val layoutManager = LinearLayoutManager(this)
    recyclerView!!.layoutManager = layoutManager

  }

  fun loadAPIData() {
    progressBar!!.visibility = View.VISIBLE
    val retrofit = RetrofitClient().buildClient()
    val service = retrofit.create(RetrofitService::class.java)
    val call =
      service!!.competitionsService(resources.getString(R.string.api_key))
    call.enqueue(object : Callback<CompetitionsModel> {
      override fun onResponse(
        call: Call<CompetitionsModel>,
        response: Response<CompetitionsModel>
      ) {
        val test: CompetitionsModel? = response.body()
        if (test != null) {
          progressBar!!.visibility = View.GONE
          errorTextView!!.text = "Data fetched"
          Log.d("onResponse", "Successfully connected to the API")
          Log.d("onResponse", response.message())
          Log.d("onResponse", response.body().toString())
          Log.d("onResponse", response.isSuccessful.toString())
          Log.d("onResponse", response.headers().toString())
          Log.d("onResponse", response.raw().toString())
          val competitions = response.body()
          competitionsList = competitions!!.competitions!!
          competitionsList.forEach { i -> println(i.toString()) }
          recyclerView!!.visibility = View.VISIBLE
          recyclerView!!.adapter = CompetitionsAdapter(competitionsList)
        }
      }

      override fun onFailure(
        call: Call<CompetitionsModel>,
        t: Throwable
      ) {
        Log.d("onFailure", t.printStackTrace().toString())
        Log.d("onFailure", "Failure to connect to API")
        Log.d("onFailure", t.message)
        progressBar!!.visibility = View.GONE
        errorTextView!!.text = "Network Error, try again later"
      }
    })
  }

  override fun itemClicked(
    view: View,
    position: Int
  ) {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }

}
