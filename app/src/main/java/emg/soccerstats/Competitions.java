package emg.soccerstats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Competitions extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitions);
        JsonParser jsonParser = new JsonParser("http://www.football-data.org/v1/competitions");

        ArrayList<String> dataList = jsonParser.getDataList();
        for(String s : dataList) {
            Log.d("Parsed", s);
        }

    }

    //just pull out the download task, no use having a single class if I can't figure out how
    //to get the data


}
