package Commands;

import Controller.CommandWithoutArg;
import Controller.Invoker;

import java.util.ArrayList;

public class History implements CommandWithoutArg {
    String name = "history";

    @Override
    public String execute(Object o) {

    return Invoker.history();

//        ArrayList<String> history = Invoker.getHistory();
//        if (history.size() == 0) {
//
//            return "История пустая.";
//
//        } else {
//
//            int numOfCommands = history.size();
//            System.out.println("Последние выполненные команды:");
//            String res = "";
//            try {
//                for (int i = numOfCommands; i > numOfCommands - 8; i--)
//                    res += history.get(i);
//            } catch (IndexOutOfBoundsException e) {
//                for (int i = 0; i < numOfCommands; i++)
//                    res += history.get(i);
//            }
//            return res;
//
//        }
    }

    @Override
    public String getName() {
        return name;
    }
}

