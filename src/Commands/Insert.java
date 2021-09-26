package Commands;

import Controller.Collection;
import Controller.CommandWithObject;
import SpaceMarine.SpaceMarine;
import SpaceMarine.SpaceMarineGenerator;

import java.util.InputMismatchException;

public class Insert implements CommandWithObject {
    String name = "insert";

    @Override
    public String execute(Object arg) {
        try {
            int id = Integer.parseInt((String) arg);
            if (Collection.isKeyFree(id)) {
                SpaceMarine spaceMarine = SpaceMarineGenerator.generate();
                spaceMarine.setId(id);

                Collection.insert(id, spaceMarine);

                return "Космический корабль залетел в коллекцию.";
            } else return "Космический корабль с указанным id же существует.";
        } catch (NumberFormatException e) {
            return "Аргумент команды должен быть типа \"int\"";
        } catch (NullPointerException e) {
            return "Неверно указаны данные.";
        }
    }

    @Override
    public String getName() {
        return name;
    }

}

