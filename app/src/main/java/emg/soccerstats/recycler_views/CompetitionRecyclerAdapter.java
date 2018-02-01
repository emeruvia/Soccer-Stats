package emg.soccerstats.recycler_views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import emg.soccerstats.R;
import emg.soccerstats.data_objects.SoccerData;

/**
 * Created by SumringaH on 1/28/2018.
 */

public class CompetitionRecyclerAdapter extends
        RecyclerView.Adapter<CompetitionRecyclerAdapter.CompetitionsViewHolder> {


    private List<SoccerData> soccerData;

    ClickListener clickListener;


    public CompetitionRecyclerAdapter(List<SoccerData> soccerData) {
        this.soccerData = soccerData;
    }

    @Override
    public CompetitionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.list_layout, parent, false);
        return new CompetitionsViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(CompetitionsViewHolder holder, final int position) {
        holder.captionTextView.setText(soccerData.get(position).getCaption());
        holder.leagueTextView.setText("League: " + soccerData.get(position).getLeague());
        holder.yearTextView.setText("Year: " + soccerData.get(position).getYear());
        holder.currentDayTextView.setText("Day: " + soccerData.get(position).getCurrentMatchday());
        holder.totalDaysTextView.setText("Total Days: " + soccerData.get(position)
                .getNumberOfMatchdays());
        holder.totalTeamsTextView.setText("Total Teams: " + soccerData.
                get(position).getNumberOfTeams());
        holder.totalMatchesTextView.setText("Total Matches: " + soccerData.
                get(position).getNumberOfGames());
    }

    @Override
    public int getItemCount() {
        return soccerData.size();
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }


    public class CompetitionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView captionTextView;
        TextView leagueTextView;
        TextView yearTextView;
        TextView currentDayTextView;
        TextView totalDaysTextView;
        TextView totalTeamsTextView;
        TextView totalMatchesTextView;

        public CompetitionsViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            captionTextView = itemView.findViewById(R.id.captionTextView);
            leagueTextView = itemView.findViewById(R.id.leagueTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            currentDayTextView = itemView.findViewById(R.id.currentDayTextView);
            totalDaysTextView = itemView.findViewById(R.id.totalDaysTextView);
            totalTeamsTextView = itemView.findViewById(R.id.totalTeamsTextView);
            totalMatchesTextView = itemView.findViewById(R.id.totalMatchesTextView);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClicked(v, getLayoutPosition());
            }

        }
    }

    public interface ClickListener {

        public void itemClicked(View view, int position);

    }
}
