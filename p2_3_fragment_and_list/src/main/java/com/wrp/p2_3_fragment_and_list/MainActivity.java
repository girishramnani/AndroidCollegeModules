package com.wrp.p2_3_fragment_and_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext()
                ,android.R.layout.simple_list_item_1,DataStore.getInstance().getKeySet());



        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                ListFragment frag = (ListFragment) getFragmentManager().findFragmentById(R.id.listFragment);


                String data = (String) parent.getItemAtPosition(position);
                frag.changeData(data, MainActivity.this);

            }
        });



    }
}
