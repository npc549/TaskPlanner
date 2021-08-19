package com.planner;

// пернесети всё в бутстрап

import java.io.*;
import java.lang.*;
import com.planner.controllers.*;

public class Main {

    public static void main(String[] args)
    {
        TaskController controller = new TaskController();

        greeting(controller);
        try {
            selection(controller);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void greeting (TaskController controller)
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

    public static void selection (TaskController controller) throws IOException {
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