package Commands;

import Controller.Commandable;
import Controller.Invoker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Execute_script implements Commandable {
    static ArrayList<String> exScrHistory = new ArrayList<>();

    @Override
    public String execute(Object arg) throws IOException {
        try {
            exScrHistory.add("execute_script " + (String) arg);
            String result = "";
            File file = new File((String) arg);
            Scanner in = new Scanner(file);
            Invoker commands = new Invoker();
            String exFileName = "";
            while (in.hasNextLine()) {
                String command = in.nextLine();
                String[] exArg = command.split(" ");
                if (exArg.length == 2) {
                    exFileName = exArg[1];
                }
                if (!(command.equals(""))) {
                    if (!(command.equals("execute_script " + exFileName))) {
                        result += ("Команда \"" + command + "\":\n");
                        result += commands.executeCommand(command);
                        result += "\n";
                    } else {
                        if (exScrHistory.contains("execute_script " + exFileName)) {
                            result += ("Команда \"" + command + "\": невыполнима во избежание бесконечной рекурсии .\n\n");
                        } else {
                            exScrHistory.add("execute_script " + exFileName);
                            result += ("Выполнение вложенного скрипта \"" + command + "\":\n");
                            result += commands.executeCommand(command);
                            result += "Выполнение вложенного скрипта завершено.\n\n";
                        }
                    }
                }
            }
            exScrHistory.clear();
            return result;
        } catch (NullPointerException | FileNotFoundException e) {
            return ("Указанный файл не найден.");
        }
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}
