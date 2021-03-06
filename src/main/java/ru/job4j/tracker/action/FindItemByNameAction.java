package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.model.Item;

import java.util.List;

public class FindItemByNameAction implements UserAction {
    private final Output out;

    public FindItemByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find items by name ====");
        String applicationName = input.askStr("What is name of item do you want to find? "
                + System.lineSeparator() + "Write name of item: ");
        List<Item> foundItems = tracker.findByName(applicationName);
        if (foundItems.size() > 0) {
            for (int index = 0; index < foundItems.size(); index++) {
                out.println(foundItems.get(index));
            }
        } else {
            out.println("Item with this name were not found");
        }
        return true;
    }
}
