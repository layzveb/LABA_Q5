package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import Exceptions.WrongCommandFormat;

import java.text.CollationKey;

public class Max_by_id extends AbstractCommand {

    public Max_by_id() {
        super("max_by_id", "вывести любой объект из коллекции, значение поля id которого является максимальным");
    }

    @Override
    public String execute(Object arg) {
        try {
            if (!arg.equals("")) {
                if (Collection.getSize() == 0) return ("Коллекция пустая.");
                else
                    return Collection.getCollection().lastEntry().getValue().toString();
            } else throw new WrongCommandFormat();
        } catch (WrongCommandFormat e) {
            return "Данной команде не нужен аргумент. Проверьте аргументацию\n";
        }
    }
}

