package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        int id = Integer.parseInt(input.askStr("Which item do you want to find?"
                + System.lineSeparator() + "Write ID of item: "));
        Item foundItem = tracker.findById(id);
        if (null == foundItem) {
            System.out.println("The item with this id was not found");
        } else {
            System.out.println(foundItem);
        }
        return true;
    }
}
