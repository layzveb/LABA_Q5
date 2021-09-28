package Commands;

import Controller.Collection;
import Controller.Commandable;
import SpaceMarine.SpaceMarine;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

public class Remove_any_by_category extends AbstractCommand {

    public Remove_any_by_category() {super("remove_any_by_category [category]", "удалить из коллекции один элемент, значение поля category которого эквивалентно заданному");}

    @Override
    public String execute(Object o) throws IOException {
        String sampleCategory = (String) o;
        try {
            for (Map.Entry<Integer, SpaceMarine> spaceMarineEntry : Collection.getCollection().entrySet()) {
                if (spaceMarineEntry.getValue().getCategory().toString().equals(sampleCategory.toUpperCase())) {
                    Collection.remove(spaceMarineEntry.getKey());
                    return "Удален элемент с id: " + spaceMarineEntry.getKey();
                }
            }
            return "Элементов схожей категории не было обнаружено.";
        } catch (ClassCastException e) {
            return "Неверный аргумент команды.";
        }
    }
}
