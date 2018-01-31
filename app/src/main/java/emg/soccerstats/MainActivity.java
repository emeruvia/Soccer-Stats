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

public class MainActivity extends AppCompatActivity {

    private SoccerData soccerData;
    private List<SoccerData> soccerDataList = new ArrayList<>();

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewId);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter viewAdapter = new RecyclerViewAdapter(this, soccerDataList);
        recyclerView.setAdapter(viewAdapter);

        loadAPIData();

    }

    public void loadAPIData() {

        new FetchAPIDataTask().execute("http://www.football-data.org/v1/competitions");

    }
    public class FetchAPIDataTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder result = new StringBuilder();
            URL url;
            HttpURLConnection urlConnection;

            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);

                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result.append(current);
                    data = reader.read();
                }
                return result.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            progressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    //gets the value of the string
                    String idData = jsonObject.getString("id");
                    String captionData = jsonObject.getString("caption");
                    String leagueData = jsonObject.getString("league");
                    String yearData = jsonObject.getString("year");
                    String currentDayData = jsonObject.getString("currentMatchday");
                    String totalDaysData = jsonObject.getString("numberOfMatchdays");
                    String numOfTeamsData = jsonObject.getString("numberOfTeams");
                    String numOfGamesData = jsonObject.getString("numberOfGames");
                    String lastUpdateData = jsonObject.getString("lastUpdated");

                    soccerData = new SoccerData(Integer.valueOf(idData), captionData, leagueData,
                            yearData, Integer.valueOf(currentDayData), Integer.valueOf(totalDaysData),
                            Integer.valueOf(numOfTeamsData), Integer.valueOf(numOfGamesData),
                            lastUpdateData);

                    soccerDataList.add(soccerData);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
