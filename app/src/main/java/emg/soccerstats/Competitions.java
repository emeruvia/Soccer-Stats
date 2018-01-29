package emg.soccerstats;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class Competitions extends AppCompatActivity {

    ArrayList<String> dataList = new ArrayList<>();
    ArrayList<Integer> idList = new ArrayList<>();
    ArrayList<String> captionList = new ArrayList<>();
    ArrayList<String> leagueList = new ArrayList<>();
    ArrayList<String> yearList = new ArrayList<>();
    ArrayList<Integer> currentDayList = new ArrayList<>();
    ArrayList<Integer> totalDaysList = new ArrayList<>();
    ArrayList<Integer> numOfTeamsList = new ArrayList<>();
    ArrayList<Integer> numOfGamesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitions);
//        JsonParser jsonParser = new JsonParser("http://www.football-data.org/v1/competitions");
        DownloadTask task = new DownloadTask();
        task.execute("http://www.football-data.org/v1/competitions");

    }


    @SuppressLint("StaticFieldLeak")
    public class DownloadTask extends AsyncTask<String, Void, String> {


        private ArrayList<String> dataList = new ArrayList<>();

        private ArrayList<String> getDataList() {
            return dataList;
        }

        public void setDataList(ArrayList<String> dataList) {
            this.dataList = dataList;
        }

        @Override
        protected String doInBackground(String... strings) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);

                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    //gets the value of the string
                    String data = jsonObject.toString().replaceAll(",", "\n");
                    String idData = jsonObject.getString("id");
                    String captionData = jsonObject.getString("caption");
                    String leagueData = jsonObject.getString("league");
                    String yearData = jsonObject.getString("year");
                    String currentDayData = jsonObject.getString("currentMatchday");
                    String totalDaysData = jsonObject.getString("numberOfMatchdays");
                    String numOfTeamsData = jsonObject.getString("numberOfTeams");
                    String numOfGamesData = jsonObject.getString("numberOfGames");

                    //Append the data values into their respectives lists.
                    dataList.add(data);
                    idList.add(Integer.valueOf(idData));
                    captionList.add(captionData);
                    leagueList.add(leagueData);
                    yearList.add(yearData);
                    currentDayList.add(Integer.valueOf(currentDayData));
                    totalDaysList.add(Integer.valueOf(totalDaysData));
                    numOfTeamsList.add(Integer.valueOf(numOfTeamsData));
                    numOfGamesList.add(Integer.valueOf(numOfGamesData));

                }
                for (String s : dataList) {
                    Log.d("Data", s);
                }
                for (Integer i : idList) {
                    Log.d("ID", String.valueOf(i));
                }



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
