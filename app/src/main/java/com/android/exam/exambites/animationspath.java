package com.android.exam.exambites;

import java.util.ArrayList;
import java.util.List;

public class animationspath {
    List<Topics> topics;
    Topics topic;
    public animationspath(){
        topics=new ArrayList<>();
        topic=new Topics("what is physics","https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A1%20What%20is%20Physics%20E.mp4?alt=media&token=42eb1173-28e9-4349-bf54-99f2d017617f");
        topics.add(topic);
        topic=new Topics("Base Quantities","gs://cheklist-1b8ba.appspot.com/level/9th/chapters/C1 A3 Base Quantities E.mp4");
        topics.add(topic);
        topic=new Topics("Physical Quantities","https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A2%20physical%20quantities%20E.mp4?alt=media&token=bd58dd6f-b6c1-486c-9f3a-68de344e7cd8");
        topics.add(topic);
        topic=new Topics("Prefixes","https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A5%20Prefixes%20E.mp4?alt=media&token=69bc8c77-25a2-4bf5-96a2-943ed6aef5c3");
        topics.add(topic);
        topic=new Topics("Prefix","https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A5%20Prefixes%20E.mp4?alt=media&token=69bc8c77-25a2-4bf5-96a2-943ed6aef5c3");
        topics.add(topic);
        topic=new Topics("Scientific Notations","https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A7%20Scientific%20notations%20English.mp4?alt=media&token=7ed00add-118a-44be-8837-65d98dd1f854");
        topics.add(topic);
        topic=new Topics("Derived Quantities","https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A4%20derived%20quantities%20E.mp4?alt=media&token=0bd77990-763f-433d-8e10-08011b8a3e93");
        topics.add(topic);
        topic=new Topics("accuracy vs precision","https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2FC1%20A8%20Accuracy%20and%20Precision%20E.mp4?alt=media&token=6255ffdc-0ee3-437c-ac96-506b45f8c2bd");
        topics.add(topic);

    }

    public List<Topics> getanimationslit(){
        return this.topics;
    }
}
