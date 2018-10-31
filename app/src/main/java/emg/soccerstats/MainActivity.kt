package emg.soccerstats

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

import android.widget.Toast
import emg.soccerstats.interfaces.RetrofitService
import emg.soccerstats.models.CompetitionsModel
import emg.soccerstats.utils.RetrofitClient
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.ArrayList

import emg.soccerstats.data_objects.SoccerData
import emg.soccerstats.recycler_views.CompetitionRecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity(), CompetitionRecyclerAdapter.ClickListener {

  private val soccerData: SoccerData? = null
  private var soccerDataList: List<SoccerData>? = null
  private var idList: List<Int>? = null

  private var progressBar: ProgressBar? = null
  private var recyclerView: RecyclerView? = null
  private var errorTextView: TextView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    progressBar = findViewById(R.id.progress_bar)
    recyclerView = findViewById(R.id.recyclerViewId)
    errorTextView = findViewById(R.id.error_textview)

    soccerDataList = ArrayList()
    idList = ArrayList()

    val layoutManager = LinearLayoutManager(this)
    recyclerView!!.layoutManager = layoutManager

    val viewAdapter = CompetitionRecyclerAdapter(soccerDataList)
    viewAdapter.setClickListener(this)
    recyclerView!!.adapter = viewAdapter

    loadAPIData()
  }

  override fun itemClicked(
    view: View,
    position: Int
  ) {
    val intent = Intent(this, Fixtures::class.java)
    Log.d("IdTest", idList!![position].toString())
    intent.putExtra("id", idList!![position])
    startActivity(intent)
  }

  fun loadAPIData() {
    progressBar!!.visibility = View.VISIBLE
    val retrofit = RetrofitClient().buildClient()
    val service = retrofit.create(RetrofitService::class.java)
    val call =
      service!!.competitionsService(resources.getString(R.string.api_key))
    call.enqueue(object: Callback<CompetitionsModel>{
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
}
