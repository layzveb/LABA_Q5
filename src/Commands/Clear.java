package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;

public class Clear implements CommandWithoutArg {
    String name = "clear";
    String description = "очищает коллекцию";

    @Override
    public String execute(Object o) {
        if (Collection.getSize() == 0) return ("Коллекция итак пустая.");
        else {
            Collection.clear();
            return ("Коллекция очищена");
        }
    }

    @Override
    public String getName() {
        return name;
    }

//    @Override
//    public String toString() {return name + description;}
//

}