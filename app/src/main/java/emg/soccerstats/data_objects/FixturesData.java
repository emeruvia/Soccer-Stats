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

    public FixturesData(String date, String status, int matchday, String homeTeamName,
                        String awayTeamName) {
        this.date = date;
        this.status = status;
        this.matchday = matchday;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
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

}
