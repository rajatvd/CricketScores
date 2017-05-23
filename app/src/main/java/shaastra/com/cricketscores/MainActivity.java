package shaastra.com.cricketscores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Match> ms = new ArrayList<Match>();
        MatchAdapter matches = new MatchAdapter(this, ms); // Setup our custom list adapter

        // Setup some sample matches
        initMatches(matches);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(matches);


        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Log.i("test",parent.getAdapter().getItem(position)+""); // Gen logging
                ArrayAdapter mats = (ArrayAdapter) parent.getAdapter();
                Match m = (Match) mats.getItem(position);
                m.showDetails = !m.showDetails; // Update whether we want to show details or not
                Log.i("match", m.showDetails + "");
                parent.setAdapter(mats); // Reset our adapter so the list view updates based on the new
                // item view returned by our custom adapter
                // (ArrayAdapter)(parent.getAdapter()).getItem(position).showDetails = !(ArrayAdapter)(parent.getAdapter()).getItem(position).showDetails;
            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler);


    }

    // Setup some example matches to display
    private void initMatches(ArrayAdapter m){
        Match m1 = new Match("KKR", "RCB");
        m1.team1Score = "178/3";
        m1.team1Overs = "20";
        m1.team1Status = "Lost";
        m1.team2Score = "180/5";
        m1.team2Overs = "18.5";
        m1.team2Status = "Won";
        m.add(m1);
        Match m2 = new Match("SRH", "MI");
        m2.team1Score = "130/8";
        m2.team1Overs = "20";
        m2.team1Status = "Bowling";
        m2.team2Score = "111/5";
        m2.team2Overs = "18";
        m2.team2Status = "Batting";
        m.add(m2);
        Match m4 = new Match("SRH", "RCB");
        m4.team1Score = "178/8";
        m4.team1Overs = "20";
        m4.team1Status = "Won";
        m4.team2Score = "130/9";
        m4.team2Overs = "20";
        m4.team2Status = "Lost";
        m.add(m4);

        Match m3 = new Match("DD", "KKR");
        m3.team1Score = "10/0";
        m3.team1Overs = "2.3";
        m3.team1Status = "Batting";
        m3.team2Score = "90/10";
        m3.team2Overs = "13";
        m3.team2Status = "Bowling";
        m.add(m3);

    }
}
