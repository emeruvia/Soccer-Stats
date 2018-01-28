package emg.soccerstats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
    API Source: https://apifootball.com/admin/
    API Key: 7232152e1a4dcce0088410420c4407ecda23d3f982890a32f976ce8c4c82e2d1
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonParser("http://www.football-data.org/v1/competitions");
    }
}
