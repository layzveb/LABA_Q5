package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import SpaceMarine.SpaceMarine;

import java.util.Map;

public class Show implements CommandWithoutArg {
    String name = "show";

    @Override
    public String execute(Object o) {
        String res = "";
        if (Collection.getSize() == 0) return ("Коллекция пустая.");
        else for (Map.Entry<Integer, SpaceMarine> entry : Collection.getCollection().entrySet())
            res += entry.getValue() +"\n";
        return res;
    }

    @Override
    public String getName() {
        return name;
    }
}
