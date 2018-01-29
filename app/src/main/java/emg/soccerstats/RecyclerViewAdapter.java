package emg.soccerstats;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SumringaH on 1/28/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {


    private Context context;
    private List<SoccerData> soccerData;


    public RecyclerViewAdapter(Context context, List<SoccerData> soccerData) {
        this.context = context;
        this.soccerData = soccerData;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean attachToParentImmediately = false;

        View view = inflater.inflate(R.layout.list_layout, parent, attachToParentImmediately);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return soccerData.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView captionTextView;
        TextView leagueTextView;
        TextView yearTextView;
        TextView currentDayTextView;
        TextView totalDaysTextView;
        TextView totalTeamsTextView;
        TextView totalMatchesTextView;
        Button teamButton;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            captionTextView = (TextView) itemView.findViewById(R.id.captionTextView);
            leagueTextView = (TextView) itemView.findViewById(R.id.leagueTextView);
            yearTextView = (TextView) itemView.findViewById(R.id.yearTextView);
            currentDayTextView = (TextView) itemView.findViewById(R.id.currentDayTextView);
            totalDaysTextView = (TextView) itemView.findViewById(R.id.totalDaysTextView);
            totalTeamsTextView = (TextView) itemView.findViewById(R.id.totalTeamsTextView);
            totalMatchesTextView = (TextView) itemView.findViewById(R.id.totalMatchesTextView);
            teamButton = (Button) itemView.findViewById(R.id.teamsButton);
        }
    }

}
