package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import SpaceMarine.SpaceMarine;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;

public class Print_descending implements CommandWithoutArg {
    @Override
    public String execute(Object o) throws IOException {
        if (Collection.getSize() == 0) return "Коллекция пустая";
        //Так как у нас отсортированная мапа, мы просто запоминаем текстовое представление объектов
        //в двунаправленной очереди, а потом когда выводим инормацию достаем с конца наши тексотовые представления
        ArrayDeque<String> deque = new ArrayDeque();
        for (Map.Entry<Integer, SpaceMarine> spaceMarineEntry : Collection.getCollection().entrySet())
            deque.addFirst(spaceMarineEntry.getValue().toString());
        String res = "";
        while (!deque.isEmpty()) {
            res += deque.pop().toString() + "\n";
        }
        return res;
    }

    @Override
    public String getName() {
        return "print_descending";
    }
}
