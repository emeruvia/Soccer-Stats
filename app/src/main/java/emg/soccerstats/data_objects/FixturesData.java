package emg.soccerstats.data_objects;

/**
 * Created by EMG on 2/1/2018.
 */

public class FixturesData {

    private String date;
    private String status;
    private int matchday;
    private String homeTeamName;
    private String awayTeamName;
    private String homeGoals;
    private String awayGoals;

    public FixturesData(String date, String status, int matchday, String homeTeamName,
                        String awayTeamName, String homeGoals, String awayGoals) {
        this.date = date;
        this.status = status;
        this.matchday = matchday;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public int getMatchday() {
        return matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public String getHomeGoals() {
        return homeGoals;
    }

    public String getAwayGoals() {
        return awayGoals;
    }

}
