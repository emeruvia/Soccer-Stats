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
    //testing retrofit connectivity
    val retrofit = RetrofitClient().buildClient()
    val service = retrofit.create(RetrofitService::class.java)
    val call = service.competitionsService(resources.getString(R.string.api_key))
    //Call<CompetitionsModel> call =
    //    service.competitionsService();
    call.enqueue(object : Callback<CompetitionsModel> {
      override fun onResponse(
        call: Call<CompetitionsModel>,
        response: Response<CompetitionsModel>
      ) {
        Toast.makeText(applicationContext, "Got data swag", Toast.LENGTH_SHORT)
            .show()
        val (count, competitions) = response.body()!!
        println(count)
        println(competitions[0].name)
      }

      override fun onFailure(
        call: Call<CompetitionsModel>,
        t: Throwable
      ) {
        Log.d("onFailure", t.message)
        Toast.makeText(applicationContext, "Failed to get data", Toast.LENGTH_SHORT)
            .show()
      }
    })
  }
}
