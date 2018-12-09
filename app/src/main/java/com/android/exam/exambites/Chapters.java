package com.android.exam.exambites;

import java.util.List;

public class Chapters {
    String chaptername;
    List<Topics> chaptersList;

    public Chapters(String chaptername,List<Topics> chaptersList){
            this.chaptername=chaptername;
            this.chaptersList=chaptersList;
    }
    public String getChaptername(){
        return this.chaptername;
    }
    public void setChaptername(){
        this.chaptername=chaptername;
    }

    public List<Topics> getChaptersList() {
        return this.chaptersList;
    }
    public void setChaptersList(List<Topics> chaptersList){
        this.chaptersList=chaptersList;
    }
}
