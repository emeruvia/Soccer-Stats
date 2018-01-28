package emg.soccerstats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /*
    API Source: https://apifootball.com/admin/
    API Key: 7232152e1a4dcce0088410420c4407ecda23d3f982890a32f976ce8c4c82e2d1
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Whenever the competitions button is clicked it jumps to another activity
    public void competitionsButton(View view) {
        Intent competitionIntent = new Intent(this, Competitions.class);
        startActivity(competitionIntent);
    }
}
