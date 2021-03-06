package Commands;

import Controller.Collection;
import Controller.CommandWithObject;
import Exceptions.WrongCommandFormat;
import SpaceMarine.SpaceMarine;
import SpaceMarine.SpaceMarineGenerator;

import java.util.InputMismatchException;

public class Update extends AbstractCommand {

    public Update() {
        super("update", "[id] обновление значения элемента коллекции, id которого равен заданному");
    }

    @Override
    public String execute(Object arg) {
        try {
            if (!arg.equals("")) {
                int id = Integer.parseInt(String.valueOf(arg));
                if (!Collection.isKeyFree(id)) {
                    SpaceMarine spaceMarine = SpaceMarineGenerator.generate();
                    spaceMarine.setId(id);
                    Collection.update(id, spaceMarine);
                    return ("Космический корабль с id [" + arg + "] успешно обновлен.");
                } else return ("Космический корабль с указанным id не найден.");
            } else throw new WrongCommandFormat();
        } catch (WrongCommandFormat e) {
            return "Данной команде НУЖЕН аргумент. Проверьте аргументацию\n";
        } catch (NumberFormatException | InputMismatchException e) {
            return ("Аргумент команды должен быть типа \"int\"");
        } catch (NullPointerException e) {
            return ("Неверно указаны данные.");
        }
    }
}

