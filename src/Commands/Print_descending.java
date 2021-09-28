package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import SpaceMarine.SpaceMarine;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;

public class Print_descending extends AbstractCommand {

    public Print_descending() {
        super("print_descending", "вывод элементов коллекции в порядке убывания");
    }

    @Override
    public String execute(Object o) throws IOException {
        if (Collection.getSize() == 0) return "Коллекция пустая";
        ArrayDeque<String> deque = new ArrayDeque();
        for (Map.Entry<Integer, SpaceMarine> spaceMarineEntry : Collection.getCollection().entrySet())
            deque.addFirst(spaceMarineEntry.getValue().toString());
        String res = "";
        while (!deque.isEmpty()) {
            res += deque.pop() + "\n";
        }
        return res;
    }
}
