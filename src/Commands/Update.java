package Commands;

import Controller.Collection;
import Controller.CommandWithObject;
import SpaceMarine.SpaceMarine;
import SpaceMarine.SpaceMarineGenerator;

import java.util.InputMismatchException;

public class Update implements CommandWithObject {
    String name = "update";

    @Override
    public String execute(Object arg) {
        try {
            int id = Integer.parseInt((String) arg);
            if (!Collection.isKeyFree(id)) {
                SpaceMarine spaceMarine = SpaceMarineGenerator.generate();
                spaceMarine.setId(id);
                Collection.update(id, spaceMarine);
                return ("Космический корабль с id[" + arg + "] успешно обновлен.");
            } else return ("Космический корабль с указанным id не найден.");
        } catch (NumberFormatException | InputMismatchException e) {
            return ("Аргумент команды должен быть типа \"int\"");
        } catch (NullPointerException e) {
            return ("Неверно указаны данные.");
        }
    }

    @Override
    public String getName() {
        return name;
    }

}

