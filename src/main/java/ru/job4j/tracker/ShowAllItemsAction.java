package ru.job4j.tracker;

public class ShowAllItemsAction implements UserAction {
    private final Output out;

    public ShowAllItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ====");
        Item[] allItems = tracker.findAll();
        for (int index = 0; index < allItems.length; index++) {
            out.println(allItems[index]);
        }
        return true;
    }
}
