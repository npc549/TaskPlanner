package com.planner.models;

import java.io.*;
import java.util.*;

public class TaskModel implements Serializable {

    private static final long serialVersionUID = 1L;

    // Fields
    private String title;
    private String description;
    private GregorianCalendar dateTime;
    private String contacts;

    // Constructor
    public TaskModel(String title, String description, GregorianCalendar dateTime, String contacts) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.contacts = contacts;
    }

    // Getters
    public String getTitle () { return title; }
    public String getDescription () { return description; }
    public GregorianCalendar getDateTime () { return dateTime; }
    public String getContacts () { return contacts; }

    //Setters
    public void setTitle (String title) { this.title = title; }
    public void setDescription (String description) {
        this.description = description;
    }
    public void setDateTime (GregorianCalendar dateTime) {
        this.dateTime = dateTime;
    }
    public void setContacts (String contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Task {" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime= " + dateTime.get(Calendar.DAY_OF_MONTH) + "." + dateTime.get(Calendar.MONTH) + 1 + "." + dateTime.get(Calendar.YEAR) + " " + dateTime.get(Calendar.HOUR) + ":" + dateTime.get(Calendar.MINUTE) + ":" + dateTime.get(Calendar.SECOND) +
                ", contacts='" + contacts + '\'' +
                '}'+ '\n';
    }


}