package Commands;

import Controller.Collection;
import Controller.Commandable;
import SpaceMarine.SpaceMarine;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

public class Remove_any_by_category implements Commandable {
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

    @Override
    public String getName() {
        return "remove_any_by_category";
    }
}
