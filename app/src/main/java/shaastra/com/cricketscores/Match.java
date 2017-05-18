package shaastra.com.cricketscores;

/**
 * Created by Rajat on 18-05-2017.
 */

public class Match {
    String team1, team1Score, team1Overs,
            team2, team2Score, team2Overs;

    public Match(String team11, String team22){
        team1 = team11;
        team2 = team22;
        team1Score = "0/0";
        team2Score = "0/0";
        team1Overs = "0";
        team2Overs = "0";
    }

    public boolean didTeam1Win(){
        int team1runs = Integer.parseInt(team1Score.split("/")[0]);
        int team2runs = Integer.parseInt(team2Score.split("/")[0]);
        return team1runs>team2runs;
    }

    public String toString(){
        return team1 + " vs " + team2;
    }

}
