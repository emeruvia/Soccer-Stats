package emg.soccerstats;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import android.widget.Toast;
import emg.soccerstats.interfaces.RetrofitService;
import emg.soccerstats.models.CompetitionsModel;
import emg.soccerstats.utils.RetrofitClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import emg.soccerstats.data_objects.SoccerData;
import emg.soccerstats.recycler_views.CompetitionRecyclerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
    implements CompetitionRecyclerAdapter.ClickListener {

  private SoccerData soccerData;
  private List<SoccerData> soccerDataList;
  private List<Integer> idList;

  private ProgressBar progressBar;
  private RecyclerView recyclerView;
  private TextView errorTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    progressBar = findViewById(R.id.progress_bar);
    recyclerView = findViewById(R.id.recyclerViewId);
    errorTextView = findViewById(R.id.error_textview);

    soccerDataList = new ArrayList<>();
    idList = new ArrayList<>();

    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    CompetitionRecyclerAdapter viewAdapter =
        new CompetitionRecyclerAdapter(soccerDataList);
    viewAdapter.setClickListener(this);
    recyclerView.setAdapter(viewAdapter);

    loadAPIData();
  }

  @Override
  public void itemClicked(View view, int position) {
    Intent intent = new Intent(this, Fixtures.class);
    Log.d("IdTest", String.valueOf(idList.get(position)));
    intent.putExtra("id", idList.get(position));
    startActivity(intent);
  }

  public void loadAPIData() {
    //testing retrofit connectivity
    Retrofit retrofit =
        new RetrofitClient().buildClient();
    RetrofitService service = retrofit.create(RetrofitService.class);
    Call<CompetitionsModel> call =
        service.competitionsService(getResources().getString(R.string.api_key));
    //Call<CompetitionsModel> call =
    //    service.competitionsService();
    call.enqueue(new Callback<CompetitionsModel>() {
      @Override
      public void onResponse(Call<CompetitionsModel> call, Response<CompetitionsModel> response) {
        Toast.makeText(getApplicationContext(), "Got data swag", Toast.LENGTH_SHORT).show();
        CompetitionsModel test = response.body();
        assert test != null;
        System.out.println(test.getCount());
        System.out.println(test.getCompetitions().get(0).getName());
      }

      @Override public void onFailure(Call<CompetitionsModel> call, Throwable t) {
        Log.d("onFailure", t.getMessage());
        Toast.makeText(getApplicationContext(), "Failed to get data", Toast.LENGTH_SHORT).show();
      }
    });
  }
}
