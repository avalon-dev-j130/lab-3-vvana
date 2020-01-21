package ru.avalon.java;

import ru.avalon.java.console.ConsoleUI;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.avalon.java.actions.CreateFile;
import ru.avalon.java.actions.DeleteFile;
import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileMoveAction;

public class Lab3 extends ConsoleUI{
    
    public static void main(String[] args) {

      new Lab3().run();
    }
 
//    Lab3() {
//        super(Commands.class);
//    }

   @Override
    protected void onCommand(Commands command)  {
        switch (command.comm) {
            case copy:
                new FileCopyAction(command.param[0], command.param[1]).start();
                System.out.println("onCommand отработал для copy");
                break;
            case move:
                new FileMoveAction(command.param[0], command.param[1]).start();
                System.out.println("onCommand отработал для move");
                break;
            case exit:
                close();
                break;
            case delete:
                new DeleteFile (command.param[0]).start();
                break;
            case create:
                new CreateFile (command.param[0]).start();
                break;
            default :
                System.out.println("Плохая команда пролезла в onCommand()");
               
        }
    }
    
}
