package com.planner.controllers;

// Packages import
import com.planner.services.*;
import com.planner.interfaces.*;
import com.planner.controllers.*;

// Java classes import
import java.io.*;

public class TaskController implements ControllerInterface {

    ExplorerInterface explorer;

    // Constructors
    public TaskController(ExplorerInterface explorer) {
        this.explorer = explorer;
    }

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


}