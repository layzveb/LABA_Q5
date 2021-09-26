package Commands;

import Controller.Collection;
import Controller.Commandable;
import SpaceMarine.SpaceMarine;

import java.util.Map;

public class Remove_key implements Commandable {
    String name = "remove_key";

    @Override
    public String execute(Object arg) {
        try {
            if (Collection.getSize() == 0) return ("Коллекция и так пустая.");
            else {
                for (Map.Entry<Integer, SpaceMarine> entry : Collection.getCollection().entrySet())
                    if (entry.getKey() == Integer.parseInt((String) arg)) {
                        Collection.remove(entry.getKey());
                        return ("Космический корабль с id[" + arg + "] успешно удален.");
                    }
                return ("Космический корабль с указанным id не найден.");
            }
        } catch (Exception e) {
            return ("Аргумент команды должен быть типа \"int\"");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}

