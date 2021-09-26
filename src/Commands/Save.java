package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import Utilites.WriterToFile;

import java.io.FileNotFoundException;

public class Save implements CommandWithoutArg {
    String name = "save";

    @Override
    public String execute(Object o) throws FileNotFoundException {
        WriterToFile.writeCollection(Collection.getCollection());
        return "Коллекция успешно сохранена.";
    }


    @Override
    public String getName() {
        return name;
    }
}

