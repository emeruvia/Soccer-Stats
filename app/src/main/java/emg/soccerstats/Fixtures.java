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

import emg.soccerstats.data_objects.FixturesData;
import emg.soccerstats.data_objects.SoccerData;
import emg.soccerstats.recycler_views.FixturesRecyclerAdapter;

public class Fixtures extends AppCompatActivity {

    private int id;
    private TextView idErrorTextView;
    private FixturesData fixturesData;
    private List<FixturesData> fixturesDataList;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);

        recyclerView = findViewById(R.id.fixture_recyclerview);
        progressBar = findViewById(R.id.fixture_progressbar);
        idErrorTextView = findViewById(R.id.error_textview);

        fixturesDataList = new ArrayList<>();

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        if (id != 0) {
            Log.i("id_value", String.valueOf(id));

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            FixturesRecyclerAdapter viewAdapter = new FixturesRecyclerAdapter(fixturesDataList);
            recyclerView.setAdapter(viewAdapter);

            loadAPIData(String.valueOf(id));

        } else {
            idErrorTextView.setText("API Error call");
            idErrorTextView.setVisibility(View.VISIBLE);
        }
    }

    public void loadAPIData(String parseId) {

        try {
            new FetchFixtures().execute("http://api.football-data.org/v1/competitions/" +
                    parseId + "/fixtures");
        } catch (NullPointerException e) {
            idErrorTextView.setText("API Error call");
            idErrorTextView.setVisibility(View.VISIBLE);
            e.printStackTrace();
        }

    }

    @SuppressLint("StaticFieldLeak")
    public class FetchFixtures extends AsyncTask<String, Void, String> {

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

                JSONObject jsonObject = new JSONObject(result);
                String fixtures = jsonObject.getString("fixtures");
                JSONArray jsonArray = new JSONArray(fixtures);
//                Log.i("JsonParsed", fixtures);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonParsed = jsonArray.getJSONObject(i);

                    //gets the value of the string
                    String date = jsonParsed.getString("date");
                    String status = jsonParsed.getString("status");
                    String matchday = jsonParsed.getString("matchday");
                    String homeTeamName = jsonParsed.getString("homeTeamName");
                    String awayTeamName = jsonParsed.getString("awayTeamName");
                    String resultGame = jsonParsed.getString("result");


                    fixturesData = new FixturesData(date, status, Integer.valueOf(matchday),
                            homeTeamName, awayTeamName);

                    fixturesDataList.add(fixturesData);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
