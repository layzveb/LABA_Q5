package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;

import java.text.CollationKey;

public class Max_by_id implements CommandWithoutArg {
    String name = "max_by_id";

    @Override
    public String execute(Object arg) {
        if (Collection.getSize() == 0) return ("Коллекция пустая.");
        else
            //treemap автоматически сортирует по возрастанию ключа, поэтому достаточно просто достать крайний элемент
            return Collection.getCollection().lastEntry().getValue().toString();

    }

    @Override
    public String getName() {
        return name;
    }
}

