package emg.soccerstats.recycler_views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FixturesViewHolder extends RecyclerView.ViewHolder {

        public FixturesViewHolder(View itemView) {
            super(itemView);
        }
    }

}
