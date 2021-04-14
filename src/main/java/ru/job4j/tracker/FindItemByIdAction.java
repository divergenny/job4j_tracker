package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by Id ====");
        int id = Integer.parseInt(input.askStr("Which item do you want to find?"
                + System.lineSeparator() + "Write ID of item: "));
        Item foundItem = tracker.findById(id);
        if (null == foundItem) {
            out.println("The item with this id was not found");
        } else {
            out.println(foundItem);
        }
        return true;
    }
}
