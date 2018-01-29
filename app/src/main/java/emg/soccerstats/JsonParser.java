package emg.soccerstats;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by SumringaH on 1/27/2018.
 */

public class JsonParser extends AppCompatActivity {

    private ArrayList<String> dataList;


    public JsonParser(String url) {
        DownloadTask task = new DownloadTask();
        task.execute(url);
    }


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
                    String data = jsonObject.toString().replaceAll(",", "\n");
                    dataList.add(data);
                    Log.i("Object", data);
                }
                for (String s : dataList) {
                    Log.d("Data", s);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
