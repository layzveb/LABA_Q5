package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import Utilites.WriterToFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Save extends AbstractCommand {

    public Save() {
        super("save", "сохранение коллекции в файл");
    }

    @Override
    public String execute(Object o) throws IOException {
        WriterToFile.writeCollection(Collection.getCollection());
        return "Коллекция успешно сохранена.";
    }
}

