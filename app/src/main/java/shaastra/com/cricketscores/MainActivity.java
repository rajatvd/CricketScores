package shaastra.com.cricketscores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] myStringArray = {"hi","bye","ooooooooo big string","hi","bye","ooooooooo big string","hi","bye","ooooooooo big string","hi","bye","ooooooooo big string","hi","bye","ooooooooo big string","hi","bye","ooooooooo big string"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myStringArray);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }
}
