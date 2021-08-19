package com.planner.models;

// добавить геттеры и сеттеры + конструкторы + переопределение toString()

import java.io.*;
import java.util.*;

public class TaskModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private GregorianCalendar dateTime;
    private String contacts;

    public TaskModel(String title, String description, GregorianCalendar dateTime, String contacts) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.contacts = contacts;
    }

    public String getTitle () { return title; }
    public String getDescription () { return description; }
    public GregorianCalendar getDateTime () { return dateTime; }
    public String getContacts () { return contacts; }

    @Override
    public String toString() {
        return "Task {" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", contacts='" + contacts + '\'' +
                '}'+ '\n';
    }
}