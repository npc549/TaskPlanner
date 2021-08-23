package com.planner.bootstrap;

// Packages import
import com.planner.controllers.TaskController;
import com.planner.interfaces.ControllerInterface;
import com.planner.interfaces.ExplorerInterface;
import com.planner.services.Explorer;

// Java classes import
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bootstrap {

    // Variables
    ExplorerInterface explorer = new Explorer();
    TaskController controller = new TaskController(explorer);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start () {
        greetingLoad();
        try { inputSwitch(); }
        catch (IOException e) { e.printStackTrace(); }
    }

    public static void greetingLoad () {
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

    char inputAction;
    public void inputSwitch () throws IOException {
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