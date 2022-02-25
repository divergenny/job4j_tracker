package ru.job4j.tracker;

import ru.job4j.tracker.action.*;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Store tracker = new SqlTracker();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new CreateItemAction(output));
        actions.add(new ShowAllItemsAction(output));
        actions.add(new EditItemAction(output));
        actions.add(new DeleteItemAction(output));
        actions.add(new FindItemByIdAction(output));
        actions.add(new FindItemByNameAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
    }
}
