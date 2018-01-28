package emg.soccerstats;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by SumringaH on 1/28/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {


    private int numberOfItems;


    public RecyclerViewAdapter(int numberOfItems) {
        this.numberOfItems = numberOfItems;
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
        return numberOfItems;
    }


    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView captionTextView;
        TextView leagueTextView;
        TextView yearTextView;
        TextView currentDayTextView;
        TextView totalDaysTextView;
        Button teamButton;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }

}
