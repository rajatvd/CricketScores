package shaastra.com.cricketscores;

/**
 * Created by Rajat on 18-05-2017.
 */

public class Match {
    // A match class which holds all data regarding matches as strings.
    // This is not too impractical as all actual data can be parsed to this form, and any
    // validations on the data can be performed at a previous stage(as that depends on how it is stored).
    String team1, team1Score, team1Overs, team1Status,
            team2, team2Score, team2Overs, team2Status;

    public boolean showDetails; // Whether details of the matches should be displayed or not

    public Match(String team11, String team22){
        team1 = team11;
        team2 = team22;
        team1Score = "0/0";
        team2Score = "0/0";
        team1Overs = "0";
        team2Overs = "0";
        team1Status = "Batting";
        team2Status = "Bowling";
    }

    /*public boolean didTeam1Win(){
        // Compare the runs scored by each team to determine if team 1 won or not
        int team1runs = Integer.parseInt(team1Score.split("/")[0]);
        int team2runs = Integer.parseInt(team2Score.split("/")[0]);
        return team1runs>team2runs;
    }

    public String toString(){
        if(showDetails){
            String s =  team1 + "\u0009vs\u0009" + team2;
            s+="\n"+team1Score+"\t  \t"+ team2Score;
            s+="\n"+team1Overs+"\t  \t"+ team2Overs;
            s+="\n"+ (didTeam1Win()?team1:team2) + " Won";
            return s;
        }
        return team1 + "\tvs\t" + team2;
    }*/

}
