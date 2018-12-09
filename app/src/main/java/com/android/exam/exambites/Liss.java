package com.android.exam.exambites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Liss extends AppCompatActivity {

    List imagelist=new ArrayList();
    List textlist=new ArrayList();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liss);
        imagelist.add(R.drawable.physical_quantities_and_measurements1);
        imagelist.add(R.drawable.kinematics2);
        imagelist.add(R.drawable.dynamics3);
        imagelist.add(R.drawable.turning_forces4);
        imagelist.add(R.drawable.gravitation5);
        imagelist.add(R.drawable.work_and_energ6);
        imagelist.add(R.drawable.propertiesm7);
        imagelist.add(R.drawable.thermal_propertie_of_atter8);
        imagelist.add(R.drawable.transfer_of_eat9);
        textlist.add("Physical Quantities and Meassurements");
        textlist.add("Kinametics");
        textlist.add("Dynamics");
        textlist.add("Turning Effect of Forces");
        textlist.add("Gravitation");
        textlist.add("Work and Energy");
        textlist.add("Properties of Matter");
        textlist.add("Thermal Properties of Matter");
        textlist.add("Transfer of Heat");
        listView=(ListView)findViewById(R.id.chaplsitview);
        chapterAdapter chapterAdapter=new chapterAdapter(this,R.layout.chap,imagelist,textlist);
        listView.setAdapter(chapterAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(),Chapterlist.class);
                startActivity(intent);
            }
        });

    }

}
