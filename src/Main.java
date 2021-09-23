import Commands.*;
import Controller.Collection;
import Controller.Invoker;
import Utilites.Console;
import Utilites.ReaderFromFile;
import Utilites.WriterToFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);
            String filepath = System.getenv("collection");
            if (filepath == null) {
                Console.write("Вы не указали переменную окружения.");
                filepath = "";
                while (filepath.equals("")) {
                    Console.write("Введите имя файла:\n~ ");
                    filepath = scanner.nextLine();
                }
            } else {
                Console.write(new StringBuilder().append("Программа работает с файлом \"").append(filepath).append("\", указанным в переменной окруженя \"collection\"").toString());
            }
            WriterToFile.setFilename(filepath);
            Collection.setDateCreation(LocalDateTime.now());
            Invoker invoker = new Invoker();
            invoker.regist(new Clear(), new Execute_script(), new Exit(), new Help(), new History(), new Info(),
                    new Insert(), new Max_by_id(), new Remove_key(), new Replace_if_greater(), new Save(), new Show(),
                    new Update(), new Print_descending(), new Remove_any_by_category());
            Console.write(Collection.fillCollection(ReaderFromFile.readFromFile(filepath)));
            while (true) {
                String commandName = Console.read();
                if (!commandName.equals(""))
                    Console.write(invoker.executeCommand(commandName));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Console.write("Прерывание работы программы");
        }
    }
}
