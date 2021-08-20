package com.planner.bootstrap;

// Packages import
import com.planner.controllers.TaskController;

// Java classes import
import java.io.IOException;

public class Bootstrap {

    public static void start () {
        TaskController controller = new TaskController();

        greetingLoad(controller);
        try { TaskController.inputSwitch(controller); }
        catch (IOException e) { e.printStackTrace(); }



    }

    public static void greetingLoad (TaskController controller) {
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

}
