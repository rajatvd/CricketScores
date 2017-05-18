package shaastra.com.cricketscores;

/**
 * Created by Rajat on 18-05-2017.
 */

public class Match {
    String team1, team1Score, team1Overs,
            team2, team2Score, team2Overs;

    public boolean showDetails;

    public Match(String team11, String team22){
        team1 = team11;
        team2 = team22;
        team1Score = "0/0";
        team2Score = "0/0";
        team1Overs = "0";
        team2Overs = "0";
    }

    public boolean didTeam1Win(){
        // Compare the runs scored by each team to determine if team 1 won or not
        int team1runs = Integer.parseInt(team1Score.split("/")[0]);
        int team2runs = Integer.parseInt(team2Score.split("/")[0]);
        return team1runs>team2runs;
    }

    public String toString(){
        if(showDetails){
            String s =  team1 + " vs " + team2;
            s+="\n"+team1Score+"\t \t"+ team2Score;
            s+="\n"+team1Overs+"\t \t"+ team2Overs;
            s+="\n"+ (didTeam1Win()?team1:team2) + " Won";
            return s;
        }
        return team1 + " vs " + team2;
    }

}
