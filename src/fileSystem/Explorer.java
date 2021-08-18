package fileSystem;

import console.*;

import java.io.*;
import java.util.*;

public class Explorer implements ExplorerInterface {
    private static final String FILE_PATH = "C:\\Users\\aryadnov\\Desktop\\tasks.xml";

    public static void tetsMethod() {
        GregorianCalendar calendar = new GregorianCalendar(2017, Calendar.JANUARY , 25, 14, 45, 34);

        try (ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            console.Task task = new console.Task("Title", "Description", calendar, "Contacts");
            writeFile.writeObject(task);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try(ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Task p = (Task) readFile.readObject();
            System.out.println(p.getTitle() + " " + p.getContacts() + " " + p.getDateTime() + " " + p.getContacts());
        }
        catch (Exception ex) { System.out.println(ex.getMessage()); }
    }
}
