package com.planner;

import java.io.*;
import java.lang.*;
import console.*;

public class Main {

    public static void main(String[] args)
    {
        Controller controller = new Controller();

        greeting(controller);
        try {
            selection(controller);
        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void greeting (Controller controller)
    {
        System.out.println("Hi! There is Task Planner. I can read, create, delete and change your tasks. There are all your tasks: ");
        //controller.taskLoad();
        //controller.taskView();

        System.out.println();
        System.out.println("You can do what you want! \n" +
                " Enter 'c' for create task \n" +
                " Enter 'v' for view all tasks again \n" +
                " Enter 'u' for update task \n" +
                " Enter 'd' for delete task \n" +
                " Enter 'e' for EXIT task \n");
    }

    public static void selection (Controller controller) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char inputAction;
        boolean exit = true;

        while (exit) {
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
                    exit = false;
                    break;
                default:
                    System.out.println("Oops, something wrong! Try again.");
            }
        }
    }
}