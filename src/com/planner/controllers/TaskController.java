package com.planner.controllers;

// Packages import
import com.planner.services.*;
import com.planner.interfaces.*;
import com.planner.controllers.*;

// Java classes import
import java.io.*;

public class TaskController implements ControllerInterface {

    @Override
    public void taskCreate() {
        //Explorer.testReadSerialFile();
        //Explorer.testWriteSerialFile();
        //Explorer.testXMLRead();
        Explorer.parserReader();
    }

    @Override
    public void taskLoad() {

    }

    @Override
    public void taskView() {

    }

    @Override
    public void taskUpdate() {

    }

    @Override
    public void taskDelete() {

    }

    public static void inputSwitch (TaskController controller) throws IOException {
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
}