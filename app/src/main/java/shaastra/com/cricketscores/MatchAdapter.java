package shaastra.com.cricketscores;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rajat on 21-05-2017.
 */

public class MatchAdapter extends ArrayAdapter<Match> {
    // A custom adapter for our list view


    public MatchAdapter(Context context, ArrayList<Match> matches) {
        super(context, 0, matches);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Match match = getItem(position);

        int layout = 0;
        // Decide which layout to use based on whether we want to show details or not
        if(match.showDetails){
            layout = R.layout.list_item_match_detailed;
        }else{
            layout = R.layout.list_item_match_simple;
        }

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(layout, parent, false);
        }

        // Detailed display of the match
        if(match.showDetails) {

            TextView team1 = (TextView) convertView.findViewById(R.id.team1);
            TextView team2 = (TextView) convertView.findViewById(R.id.team2);
            team1.setText(match.team1 + "\n" + match.team1Score + "\n" + match.team1Overs + "\n" + match.team1Status);
            team2.setText(match.team2 + "\n" + match.team2Score + "\n" + match.team2Overs + "\n" + match.team2Status);
            if(match.team1Status.equals("Won")){
                team1.setBackgroundColor(Color.argb(100,0,255,0));
                team2.setBackgroundColor(Color.argb(100,255,0,0));
            }else if(match.team2Status.equals("Won")){
                team2.setBackgroundColor(Color.argb(100,0,255,0));
                team1.setBackgroundColor(Color.argb(100,255,0,0));
            }else if(match.team1Status.equals("Batting")){
                team1.setBackgroundColor(Color.argb(100,200,200,0));
                team2.setBackgroundColor(Color.argb(100,0,200,200));
            }else{
                team2.setBackgroundColor(Color.argb(100,200,200,0));
                team1.setBackgroundColor(Color.argb(100,0,200,200));
            }
        }else{

            // Simple display of the match as just the two teams playing, if details are not needed
            TextView text = (TextView) convertView.findViewById(R.id.text);
            text.setGravity(Gravity.CENTER_HORIZONTAL);
            text.setText(match.team1+" vs "+match.team2);
        }

        // return the view which will be displayed in the list view
        return convertView;
    }
}


