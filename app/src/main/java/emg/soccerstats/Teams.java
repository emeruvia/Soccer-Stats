package emg.soccerstats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Teams extends AppCompatActivity {

    TextView idErrorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        idErrorTextView = findViewById(R.id.error_textview);
        Intent intent = getIntent();
        int testInt = intent.getIntExtra("id", 0);
        if (testInt != 0) {
            Log.i("id_value", String.valueOf(testInt));
        } else {
            idErrorTextView.setVisibility(View.VISIBLE);
        }
    }
}
