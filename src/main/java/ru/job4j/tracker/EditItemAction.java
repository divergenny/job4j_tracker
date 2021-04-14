package ru.job4j.tracker;

public class EditItemAction implements UserAction {
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int numberOfItem = Integer.parseInt(input.askStr("Which Item would you want to Edit?"
                + System.lineSeparator() + "Your choice: "));
        String newValue = input.askStr("What is new value for Item?"
                + System.lineSeparator() + "New value: ");
        Item replaceItem = new Item(newValue);
        if (tracker.replace(numberOfItem, replaceItem)) {
            System.out.println("Successfully modified!");
        } else {
            System.out.println("Something went wrong... Try Again! :)");
        }
        return true;
    }
}
