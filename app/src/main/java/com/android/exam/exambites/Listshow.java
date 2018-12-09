package com.android.exam.exambites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Listshow extends AppCompatActivity {
    List li;
    List path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listshow);
        Intent i = getIntent();
        List<Topics> list;
        animationspath apth=new animationspath();
        list=apth.getanimationslit();
        String[] listofstring=i.getStringArrayExtra("list");
        li=new ArrayList<String>();
        if(listofstring.length>0) {
            for(int word=0;word<list.size();word++) {
                for (int s=0;s<listofstring.length;s++){
                    if(listofstring[s].length()>4&&listofstring[s].toLowerCase().contains(list.get(word).topicName.toLowerCase())){
                        li.add(list.get(word).topicName);
                    }
                }

            }
        }
        else{
            li.add("nothing to show");
        }
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,li);
        ListView l=this.findViewById(R.id.lvi);
        l.setAdapter(itemsAdapter);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent n=new Intent(getApplicationContext(),player.class);


            }
        });
    }
}
