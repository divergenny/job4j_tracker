package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int itemToDelete = Integer.parseInt(input.askStr("Which item do you want to delete?"
                + System.lineSeparator() + "Write ID of item: "));
        if (tracker.delete(itemToDelete)) {
            System.out.println("Successfully deleted!");
        } else {
            System.out.println("Something went wrong... Try Again! :)");
        }
        return true;
    }
}
