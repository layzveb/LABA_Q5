package Utilites;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReaderFromFile {

    public String readFromFile(String filename) throws FileNotFoundException {
        try {
            String data = "";
            filename = filename.trim();
            String[] in = filename.split(" ");
            StringBuilder filter = new StringBuilder();
            for (String i : in) {
                if (!i.equals("")) {
                    filter.append(i).append(" ");
                }
            }
            filename = filter.toString().trim();
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                data += scanner.nextLine().trim() + "\n";
            scanner.close();
            WriterToFile.setFilename(filename);
            Console.write("Файл " +ColorEdit.CYAN_BOLD+ filename +ColorEdit.RESET+ " найден.");
            return data;
        } catch (FileNotFoundException | NullPointerException e) {
            while (filename.trim().equals("") || filename.equals(null)) {
                Console.write(ColorEdit.RED_BOLD + "Вы не указали имя файла.\n" + ColorEdit.RESET + "Введите имя файла:");
                String newFilename = Console.read();
                if (!(newFilename.trim().equals(""))) {
                    String[] in = newFilename.trim().split(" ");
                    StringBuilder filter = new StringBuilder();
                    for (String i : in) {
                        if (!i.equals("")) {
                            filter.append(i).append(" ");
                        }
                    }
                    String data = "";
                    filename = filter.toString().trim();
                    WriterToFile.setFilename(filename);
                    File file = new File(filename);
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine())
                        data += scanner.nextLine().trim() + "\n";
                    scanner.close();
                    WriterToFile.setFilename(filename);
                    Console.write("Файл " +ColorEdit.CYAN_BOLD+ filename +ColorEdit.RESET+ " найден.");
                    return data;
                }
            }
            Console.write("Файл " + ColorEdit.CYAN_BOLD + filename + ColorEdit.RESET + " не найден... \nСоздан новый файл " + ColorEdit.CYAN_BOLD + filename + ColorEdit.RESET + ".");
            return "";
        }
    }
}