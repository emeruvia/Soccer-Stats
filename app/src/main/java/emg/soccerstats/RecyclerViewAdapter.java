package emg.soccerstats;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by SumringaH on 1/28/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    TextView captionTextView;
    TextView leagueTextView;
    TextView yearTextView;
    TextView currentDayTextView;
    TextView totalDaysTextView;
    Button teamButton;


    public RecyclerViewAdapter() {

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }

}
