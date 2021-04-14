package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String applicationName = input.askStr("What is name of item do you want to find? "
                + System.lineSeparator() + "Write name of item: ");
        Item[] foundItems = tracker.findByName(applicationName);
        if (foundItems.length > 0) {
            showItems(foundItems);
        } else {
            System.out.println("Item with this name were not found");
        }
        return true;
    }

    private static void showItems(Item[] items) {
        for (int index = 0; index < items.length; index++) {
            System.out.println(items[index]);
        }
    }
}
