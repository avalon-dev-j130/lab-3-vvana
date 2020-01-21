package ru.avalon.java;

import java.util.Arrays;

public class Commands {
    public enum Command {
    move,
    copy,
    exit,
    delete,
    create
    }
    
    public Command comm;
    public String[] param;
    
    public Commands (String input) throws IllegalCommand {                      // Конструктор класса Commands
        String[] parts = input.trim().split(" +");                               //Разделение строки. удаление пробелов в начале строки,  "+" регулярное выражение означает 1 и более
    switch(parts[0]) {
        case "copy" : comm = Command.copy; break;
        case "move" : comm = Command.move; break;
        case "exit" : comm = Command.exit; break;
        case "delete" : comm = Command.delete; break;
        case "create" : comm = Command.create; break;
        
        default:
            throw new IllegalCommand("Не удалось распознать команду: " + parts[0]);
    }
    param = Arrays.copyOfRange(parts, 1, parts.length);                         // считывание параметры команды (что и куда копировать, перемещать)
    }
    /*
     * TODO №8 К текущему списку команд, добавьте ещё две команды
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(comm.toString() + "\nПараметры: ");
        for(String s: param) {
            sb.append(" ").append(s);
        }
        return sb.toString();
    }
    
}
