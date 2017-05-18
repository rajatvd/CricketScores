package shaastra.com.cricketscores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Console;
import java.util.Arrays;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ArrayAdapter<String> matches = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);


        initMatches(matches);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(matches);


        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Log.i("test",parent.getAdapter().getItem(position)+"");
                ArrayAdapter mats = (ArrayAdapter) parent.getAdapter();
                Match m = (Match) mats.getItem(position);
                m.showDetails = !m.showDetails;
                Log.i("match", m.showDetails + "");
                parent.setAdapter(mats);
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
        m1.team2Score = "180/5";
        m1.team2Overs = "18.5";
        m.add(m1);
        Match m2 = new Match("SRH", "MI");
        m2.team1Score = "130/8";
        m2.team1Overs = "20";
        m2.team2Score = "111/5";
        m2.team2Overs = "20";
        m.add(m2);
        Match m3 = new Match("DD", "KKR");
        m3.team1Score = "90/10";
        m3.team1Overs = "13";
        m3.team2Score = "91/2";
        m3.team2Overs = "15.3";
        m.add(m3);
        Match m4 = new Match("SRH", "RCB");
        m4.team1Score = "178/8";
        m4.team1Overs = "20";
        m4.team2Score = "130/9";
        m4.team2Overs = "20";
        m.add(m4);
    }
}
