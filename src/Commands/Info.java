package Commands;

import Controller.CommandWithoutArg;
import Controller.Collection;


public class Info implements CommandWithoutArg {
    String name = "info";

    @Override
    public String execute(Object o) {
        return Collection.getInfo();
    }

    @Override
    public String getName() {
        return name;
    }
}
