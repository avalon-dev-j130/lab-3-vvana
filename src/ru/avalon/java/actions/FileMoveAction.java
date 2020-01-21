package ru.avalon.java.actions;

import java.io.*;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    
    public static final String ANSI_RESET = "\u001B[0m";            
    public static final String ANSI_RED = "\u001B[31m";                         // красный цвет в консоли
    File source, dest;
    
    public FileMoveAction (String source, String dest) {                        // конструктор
        this.source = new File(source);
        this.dest = new File(dest);
    }
    
    public void start() {
        new Thread(this).start();
        System.out.println("Запускаем поток копирования");
    }
    
    @Override
    public void run() {
        try (InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) >0) {
                os.write(buffer,0,length);
            }
            os.flush();
            is.close();                                                         // закрываем входной поток. т.к. он держит исходный файл
            source.delete();                                                    // удалить исходный файл
            System.out.println(ANSI_RED + "\n перемещение" + source.getAbsolutePath() + " в " 
                                + dest.getAbsolutePath() + " завершено" + ANSI_RESET + "\n> "); // подсветка красным выводимых сообщений
            
        } catch (IOException ex) {
            System.out.println("ошибка перемещения " + ex.getMessage());
        }
        
    }

   
    @Override
    public void close() throws Exception {
        source = null;                                                          // закрываем ресурсы
        dest = null;
    }

}
