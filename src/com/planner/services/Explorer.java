package com.planner.services;

import com.planner.interfaces.ExplorerInterface;
import com.planner.models.TaskModel;

import java.io.*;
import java.util.*;

public class Explorer implements ExplorerInterface {
    private static final String FILE_PATH = "C:\\Users\\aryadnov\\Desktop\\tasks.xml";

    public static void writeFile() {
        GregorianCalendar calendar = new GregorianCalendar(2017, Calendar.JANUARY , 25, 14, 45, 34);

        try (ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            TaskModel taskModel = new TaskModel("Title", "Description", calendar, "Contacts");
            TaskModel taskModel2 = new TaskModel("Title", "Description", calendar, "Contacts");
            TaskModel taskModel3 = new TaskModel("Title", "Description", calendar, "Contacts");
            writeFile.writeObject(taskModel);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readFile() {
        try (ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            TaskModel p = (TaskModel) readFile.readObject();
            System.out.println(p.getTitle() + " " + p.getContacts() + " " + p.getDateTime() + " " + p.getContacts());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}