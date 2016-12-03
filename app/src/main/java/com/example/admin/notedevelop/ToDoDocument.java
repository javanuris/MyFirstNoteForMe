package com.example.admin.notedevelop;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Admin on 03.12.2016.
 */
public class ToDoDocument implements Serializable{

    private String name;
    private String content;
    private Date date;
    private int number;

    public ToDoDocument(){

    }
    public ToDoDocument(String name, String content ,Date date){
        this.name = name;
        this.content = content;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
