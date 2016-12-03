package com.example.admin.notedevelop;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Admin on 03.12.2016.
 */
public class AppContex extends Application{

    public static final String ACTION_TYPE = "rrrvbyfhytjutmiuy";
    public static final String DOC_INDEX= "rrfffffrrfrfrfrfr";

    public static final int NEW_DOCUMENT = 0;
    public static final int DOCUMENT_UPDATE= 1;


  private static   ArrayList<ToDoDocument>toDoDocuments = new ArrayList<>();

    public static ArrayList<ToDoDocument> getToDoDocuments() {
        return toDoDocuments;
    }

    public  void setToDoDocuments( ArrayList<ToDoDocument> toDoDocuments) {
        this.toDoDocuments = toDoDocuments;
    }
}
