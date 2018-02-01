package emg.soccerstats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Teams extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        Intent teamsIntent = getIntent();
        if (teamsIntent.hasExtra("id")) {
            TextView test = findViewById(R.id.testTextView);
            test.setText(teamsIntent.getStringExtra("id"));
        }
    }
}
