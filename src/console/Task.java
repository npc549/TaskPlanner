package console;

import java.io.*;
import java.util.*;

public class Task implements Serializable {

    private String title;
    private String description;
    private GregorianCalendar dateTime;
    private String contacts;

    public Task(String title, String description, GregorianCalendar dateTime, String contacts) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.contacts = contacts;
    }

    public String getTitle () { return this.title; }
    public String getDescription () { return this.description; }
    public GregorianCalendar getDateTime () { return this.dateTime; }
    public String getContacts () { return this.contacts; }
}