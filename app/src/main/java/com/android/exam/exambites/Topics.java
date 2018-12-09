package com.android.exam.exambites;

import java.io.Serializable;

public class Topics implements Serializable{
    String topicName;
    String topicPath;
    public Topics(String topicName,String topicPath){
        this.topicName=topicName;
        this.topicPath=topicPath;
    }
    public String getTopicName(){
        return this.topicName;
    }
    public String getTopicPath(){
        return this.topicPath;
    }

    public void setTopicName(String topicName){
        this.topicName=topicName;
    }
    public void setTopicPath(){
        this.topicPath=topicPath;
    }
}