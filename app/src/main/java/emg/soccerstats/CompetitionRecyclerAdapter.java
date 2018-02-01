package emg.soccerstats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SumringaH on 1/28/2018.
 */

public class CompetitionRecyclerAdapter extends RecyclerView.Adapter<CompetitionRecyclerAdapter.RecyclerViewHolder> {


    private Context context;
    private List<SoccerData> soccerData;
    private List<Integer> idList;

    ClickListener clickListener;


    public CompetitionRecyclerAdapter(Context context, List<SoccerData> soccerData, List<Integer> idList) {
        this.context = context;
        this.soccerData = soccerData;
        this.idList = idList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean attachToParentImmediately = false;

        View view = inflater.inflate(R.layout.list_layout, parent, attachToParentImmediately);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view, idList);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
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


    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        List<Integer> idList;

        TextView captionTextView;
        TextView leagueTextView;
        TextView yearTextView;
        TextView currentDayTextView;
        TextView totalDaysTextView;
        TextView totalTeamsTextView;
        TextView totalMatchesTextView;

        public RecyclerViewHolder(View itemView, List<Integer> idList) {
            super(itemView);

            this.idList = idList;

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
