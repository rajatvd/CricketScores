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


    public MatchAdapter(Context context, ArrayList<Match> matches) {
        super(context, 0, matches);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Match match = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        int layout = 0;
        if(match.showDetails){
            layout = R.layout.list_item_match_detailed;
        }else{
            layout = R.layout.list_item_match_simple;
        }
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(layout, parent, false);
        }
        if(match.showDetails) {
            boolean b = match.didTeam1Win();
            TextView team1 = (TextView) convertView.findViewById(R.id.team1);
            TextView team2 = (TextView) convertView.findViewById(R.id.team2);
            team1.setText(match.team1 + "\n" + match.team1Score + "\n" + match.team1Overs + "\n" + (b?"Won":"Lost"));
            team2.setText(match.team2 + "\n" + match.team2Score + "\n" + match.team2Overs + "\n" + (b?"Lost":"Won"));
            if(b){
                team1.setBackgroundColor(Color.argb(100,0,255,0));
                team2.setBackgroundColor(Color.argb(100,255,0,0));
            }else{
                team2.setBackgroundColor(Color.argb(100,0,255,0));
                team1.setBackgroundColor(Color.argb(100,255,0,0));
            }
        }else{
            TextView text = (TextView) convertView.findViewById(R.id.text);
            text.setGravity(Gravity.CENTER_HORIZONTAL);
            text.setText(match.team1+" vs "+match.team2);
        }
        return convertView;
    }
}


