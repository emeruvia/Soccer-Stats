package emg.soccerstats.data_objects;

/**
 * Created by EMG on 2/1/2018.
 */

public class ResultsData {

    private int goalsHomeTeam;
    private int goalsAwayTeam;

    public ResultsData(int goalsHomeTeam, int goalsAwayTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }
}
