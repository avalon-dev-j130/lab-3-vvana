package ru.avalon.java.actions;

import java.io.File;


public class DeleteFile implements Action {
    File file;
    
    public DeleteFile (String path) {                        
        this.file = new File(path);
      }
    
    public void start() {
        new Thread(this).start();
        System.out.println("Запускаем поток удаления");
    }
    
    @Override
    public void run() {
           file.delete();
                System.out.println("файл " + file +  " удален");
    }
    
    public void close() throws Exception {
        file = null;
    }
}
