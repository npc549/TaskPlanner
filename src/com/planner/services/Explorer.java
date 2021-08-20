package com.planner.services;

// Packages import

import com.planner.controllers.*;
import com.planner.interfaces.*;
import com.planner.models.*;

// Java classes import
import java.io.*;
import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Explorer implements ExplorerInterface {
    private static final String FILE_PATH_TS = "C:\\Users\\aryadnov\\Desktop\\testSerial.xml";

    public static void testWriteSerialFile() {
        GregorianCalendar calendar = new GregorianCalendar(2017, Calendar.JANUARY , 25, 14, 45, 34);

        try (ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(FILE_PATH_TS))) {
            TaskModel taskModel = new TaskModel("Title", "Description", calendar, "Contacts");
            writeFile.writeObject(taskModel);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void testReadSerialFile() {
        GregorianCalendar calendar = new GregorianCalendar(2017, Calendar.JANUARY , 25, 14, 45, 34);

        try (ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(FILE_PATH_TS))) {
            TaskModel p = (TaskModel) readFile.readObject();
            System.out.println(p);
            System.out.println(calendar.getTime());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void inputSwitchReader (TaskController controller) throws  IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char inputAction;
        boolean exit = false;

        while (!exit) {
            System.out.println("Type letter for action: ");
            inputAction = reader.readLine().charAt(0);

            switch (inputAction) {
                case 'c':
                    controller.taskCreate();
                    break;
                case 'v':
                    controller.taskView();
                    break;
                case 'u':
                    controller.taskUpdate();
                    break;
                case 'd':
                    controller.taskDelete();
                    break;
                case 'e':
                    exit = true;
                    break;
                default:
                    System.out.println("Oops, something wrong! Try again.");
            }
        }
    }

    public static void testXMLRead () {
        try {
            File inputFile = new File("C:\\Users\\aryadnov\\Desktop\\testFile.xml");

            // DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            // DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            // Document doc = dBuilder.parse(inputFile);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("student");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Student roll no : "
                            + eElement.getAttribute("rollno"));
                    System.out.println("First Name : "
                            + eElement
                            .getElementsByTagName("firstname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Last Name : "
                            + eElement
                            .getElementsByTagName("lastname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Nick Name : "
                            + eElement
                            .getElementsByTagName("nickname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Marks : "
                            + eElement
                            .getElementsByTagName("marks")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parserReader () {
        try {
            File inputFile = new File("C:\\Users\\aryadnov\\Desktop\\tasks.xml");

            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("task");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Title: " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Description: " + eElement.getElementsByTagName("description").item(0).getTextContent());
                    System.out.println("Date&Time: " + eElement.getElementsByTagName("dateTime").item(0).getTextContent());
                    System.out.println("Conacts: " + eElement.getElementsByTagName("conacts").item(0).getTextContent());
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}