package ru.avalon.java.console;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.avalon.java.Commands;
import ru.avalon.java.IllegalCommand;


public class ConsoleUI implements Runnable, Closeable {
    /**
     * Флаг, указывающий на то, должен ли интерфейс
     * продолжать обрабатывать команды.
     * <p>
     * Переменная должна содержать значение false, чтобы
     * интрефейс продолжал получать команды из потомка.
     */
    private boolean exit;

    /**
     * Основной конструктор класса.
     * 
     * @param cls описатель перечисления, которое отражает
     *            набор команд, обрабатываемых интерфейсом
     */
//    public ConsoleUI(Class<E> cls) {
//        super(System.in, cls);
//    }

    /**
     * Выполняет обработку следующей команды из потока.
     * <p>
     * Следующая команда, содержащаяся в потоке, связанном
     * с текущим объектом, передаётся на обрабтку в метод
     * onCommand.
     */
    protected void processCommand() {
        Scanner sc = new Scanner(System.in);
            System.out.print("> ");
            String commandStr = sc.nextLine();                                  // ввод команды
        try {
            onCommand(new Commands(commandStr));

        } catch (IllegalCommand ex) {
            Logger.getLogger(ConsoleUI.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    
    @Override
    public void run() {
        while (!exit) processCommand();
        System.out.println("Цикл обработки команд завершился");
    }

    /**
     * Метод жизненного цикла класса.
     * <p>
     * Вызывается, когда от пользозвателя была получена
     * следующая команда.
     * 
     * @param command экземпляр перечисления E. Описывает
     *                пользовательскую команду.
     * 
     * @throws IOException в случае ощибки ввода вывода
     */
    protected void onCommand(Commands command)  {}

    @Override
    public void close()  {
        exit = true;
    }
}
