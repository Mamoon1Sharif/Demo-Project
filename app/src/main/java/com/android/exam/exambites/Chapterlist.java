package com.android.exam.exambites;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Chapterlist extends AppCompatActivity {

    List imagelist=new ArrayList();
    List textlist=new ArrayList();
    List english=new ArrayList();
    List urdu=new ArrayList();
    ListView listView;
    String lan="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapterlist);
        english.add("https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A1%20What%20is%20Physics%20E.mp4?alt=media&token=42eb1173-28e9-4349-bf54-99f2d017617f");
        urdu.add("https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A1%20what%20is%20physics%20U.mp4?alt=media&token=bbbfa951-f41f-41c3-a2eb-7a2ba6f006a7");
        english.add("https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A2%20physical%20quantities%20E.mp4?alt=media&token=bd58dd6f-b6c1-486c-9f3a-68de344e7cd8");
        urdu.add("https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A2%20physical%20quantities%20U.mp4?alt=media&token=acceb8af-05c6-45f5-8c96-da0e7ff2a084");
        english.add("gs://cheklist-1b8ba.appspot.com/level/9th/chapters/C1 A3 Base Quantities E.mp4");
        urdu.add("gs://cheklist-1b8ba.appspot.com/level/9th/chapters/C1 A3 base quantities U.mp4");
        english.add("https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A4%20derived%20quantities%20E.mp4?alt=media&token=0bd77990-763f-433d-8e10-08011b8a3e93");
        urdu.add("https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A4%20derived%20quantities%20U.mp4?alt=media&token=76be852f-53a6-4da6-ace5-596f45a0896a");
        english.add("https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A5%20Prefixes%20E.mp4?alt=media&token=69bc8c77-25a2-4bf5-96a2-943ed6aef5c3");
        urdu.add("https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A5%20Prefixes%20U.mp4?alt=media&token=a7855c14-ff14-4a7c-a27b-6d56a2543143");
        english.add("https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A7%20Scientific%20notations%20English.mp4?alt=media&token=7ed00add-118a-44be-8837-65d98dd1f854");
        urdu.add("https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A7%20Scientific%20notations%20Urdu.mp4?alt=media&token=ba373ad0-960b-43a3-a81d-d14a14964f2f");
        english.add("https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A8%20Accuracy%20and%20Precision%20E.mp4?alt=media&token=6255ffdc-0ee3-437c-ac96-506b45f8c2bd");
        urdu.add("https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A8%20Accuracy%20and%20Precision%20U.mp4?alt=media&token=8e0008db-82ca-40f1-817d-647b626706f2");
        imagelist.add(R.drawable.turning_forces4);
        imagelist.add(R.drawable.turning_forces4);
        imagelist.add(R.drawable.turning_forces4);
        imagelist.add(R.drawable.turning_forces4);
        imagelist.add(R.drawable.turning_forces4);
        imagelist.add(R.drawable.turning_forces4);
        imagelist.add(R.drawable.turning_forces4);
        textlist.add("What is Physics");
        textlist.add("Physical Quantities");
        textlist.add("Base Quantities");
        textlist.add("Derived Quantities");
        textlist.add("Prefixes");
        textlist.add("Scientific Notations");
        textlist.add("Accuracy and Precision");
        listView=(ListView)findViewById(R.id.topiclist);
        chapterAdapter chapterAdapter=new chapterAdapter(this,R.layout.chap,imagelist,textlist);
        listView.setAdapter(chapterAdapter);
        listView.setScrollingCacheEnabled(false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,final int i, long l) {

                AlertDialog alertDialog = new AlertDialog.Builder(Chapterlist.this).create();
                alertDialog.setTitle("Select Language");
                alertDialog.setMessage("Please Select Language");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "English",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(getApplicationContext(),player.class);
                                intent.putExtra("path",english.get(i).toString());
                                startActivity(intent);
                                dialog.dismiss();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Urdu",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                lan="urdu";
                                Intent intent=new Intent(getApplicationContext(),player.class);
                                intent.putExtra("path",urdu.get(i).toString());
                                startActivity(intent);
                                dialog.dismiss();

                            }
                        });
                alertDialog.show();


            }
        });
    }



}
