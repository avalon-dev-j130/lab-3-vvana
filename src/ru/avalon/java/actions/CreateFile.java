package ru.avalon.java.actions;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CreateFile implements Action {
    File file;
    
    public CreateFile (String path) {                        
        this.file = new File(path);
      }
    
    public void start() {
        new Thread(this).start();
        System.out.println("Запускаем поток создания");
    }
    
    @Override
    public void run() {
        try {
            file.createNewFile();
            
        } catch (IOException ex) {
            Logger.getLogger(CreateFile.class.getName()).log(Level.SEVERE, null, ex);
        }
                System.out.println("файл " + file +  " создан");
    }
    
    public void close() throws Exception {
        file = null;
    }
}
