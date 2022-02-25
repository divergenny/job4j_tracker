package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.model.Item;

public class EditItemAction implements UserAction {
    private final Output out;

    public EditItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit item ====");
        int numberOfItem = Integer.parseInt(input.askStr("Which Item would you want to Edit?"
                + System.lineSeparator() + "Your choice: "));
        String newValue = input.askStr("What is new value for Item?"
                + System.lineSeparator() + "New value: ");
        Item replaceItem = new Item(newValue);
        if (tracker.replace(numberOfItem, replaceItem)) {
            out.println("Successfully modified!");
        } else {
            out.println("Something went wrong... Try Again! :)");
        }
        return true;
    }
}
