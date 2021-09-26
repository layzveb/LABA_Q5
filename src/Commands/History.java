package Commands;

import Controller.CommandWithoutArg;
import Controller.Invoker;

public class History implements CommandWithoutArg {
    String name = "history";

    @Override
    public String execute(Object o) {

    return Invoker.history();

    }

    @Override
    public String getName() {
        return name;
    }
}

