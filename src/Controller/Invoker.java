package Controller;


import Utilites.Console;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.TreeMap;

public class Invoker {
    private static Map<String, Commandable> commands = new TreeMap<>();
    public static final int COMMAND_COMMANDHISTORY_SIZE = 8;
    private static ArrayDeque<String> commandHistory = new ArrayDeque<>(COMMAND_COMMANDHISTORY_SIZE);

    public Commandable getCommand(String commandname) {
        return commands.get(commandname);
    }

    public static void setCommands(Map<String, Commandable> commands) {
        Invoker.commands = commands;
    }

    public static String history() {
        StringBuilder history = new StringBuilder();
        Console.write("\n");
        for (String commandes : commandHistory) {
            if (!commandes.equals(null)) history.append("  • ").append(commandes).append("; \n");
        }
        return history.toString();
    }

    public void regist(Commandable... commands) {
        for (Commandable command : commands)
            Invoker.commands.put(command.getName(), command);

    }

    public static Map<String, Commandable> getCommands() {
        return commands;
    }

    public  String executeCommand(String commandName) throws IOException {
        commandName = commandName.replace(" *", "");
        String[] nameAndArgument = commandName.split(" ");
        if (!commandName.equals("")) {
            if (commands.get(nameAndArgument[0]) == null) {
                return ("Ошибка ввода, введите \"help\".");
            } else {
                if (commands.get(nameAndArgument[0]) instanceof CommandWithoutArg) {
                    try {
                        String s = nameAndArgument[1];
                        return ("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (Exception e) {
                        commandHistory.addLast(nameAndArgument[0]);
                        return commands.get(nameAndArgument[0]).execute(null);
                    }
                } else {
                    try {
                        String s = nameAndArgument[2];
                        return ("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (IndexOutOfBoundsException e1) {
                        try {
                            commandHistory.addLast(nameAndArgument[0] + " " + nameAndArgument[1].trim());
                            return commands.get(nameAndArgument[0]).execute(nameAndArgument[1].trim());
                        } catch (IndexOutOfBoundsException | FileNotFoundException e2) {
                            return ("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}