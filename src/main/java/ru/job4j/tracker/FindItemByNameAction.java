package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ====");
        String applicationName = input.askStr("What is name of item do you want to find? "
                + System.lineSeparator() + "Write name of item: ");
        Item[] foundItems = tracker.findByName(applicationName);
        if (foundItems.length > 0) {
            for (int index = 0; index < foundItems.length; index++) {
                out.println(foundItems[index]);
            }
        } else {
            out.println("Item with this name were not found");
        }
        return true;
    }
}
