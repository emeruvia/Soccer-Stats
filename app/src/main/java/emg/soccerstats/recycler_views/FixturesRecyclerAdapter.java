package emg.soccerstats.recycler_views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import emg.soccerstats.R;
import emg.soccerstats.data_objects.FixturesData;

/**
 * Created by EMG on 2/1/2018.
 */

public class FixturesRecyclerAdapter extends
        RecyclerView.Adapter<FixturesRecyclerAdapter.FixturesViewHolder> {

    private List<FixturesData> fixturesDataList;

    public FixturesRecyclerAdapter(List<FixturesData> fixturesDataList) {
        this.fixturesDataList = fixturesDataList;
    }

    @Override
    public FixturesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.matches_list_layout, parent, false);

        return new FixturesViewHolder(view);

    }

    @Override
    public void onBindViewHolder(FixturesViewHolder holder, int position) {

        holder.matchDayTextView.setText("Match Day: " + fixturesDataList.get(position).getMatchday());
        holder.homeTeamTextView.setText(fixturesDataList.get(position).getHomeTeamName());
        holder.awayTeamTextView.setText(fixturesDataList.get(position).getAwayTeamName());
        holder.homeGoalsTextView.setText(fixturesDataList.get(position).getResult()[0]);
        holder.awayGoalsTextView.setText(fixturesDataList.get(position).getResult()[1]);
        holder.matchStatusTextView.setText("Status: " + fixturesDataList.get(position).getStatus());
        holder.matchDateTextView.setText("Date: " + fixturesDataList.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return fixturesDataList.size();
    }

    public class FixturesViewHolder extends RecyclerView.ViewHolder {

        TextView matchDayTextView;
        TextView homeTeamTextView;
        TextView awayTeamTextView;
        TextView homeGoalsTextView;
        TextView awayGoalsTextView;
        TextView matchStatusTextView;
        TextView matchDateTextView;

        public FixturesViewHolder(View itemView) {
            super(itemView);

            matchDayTextView = itemView.findViewById(R.id.matchDayTextView);
            homeTeamTextView = itemView.findViewById(R.id.homeTeamTextView);
            awayTeamTextView = itemView.findViewById(R.id.awayTeamTextView);
            homeGoalsTextView = itemView.findViewById(R.id.homeGoalsTextView);
            awayGoalsTextView = itemView.findViewById(R.id.awayGoalsTextView);
            matchStatusTextView = itemView.findViewById(R.id.matchStatusTextView);
            matchDateTextView = itemView.findViewById(R.id.matchDateTextView);


        }
    }

}
