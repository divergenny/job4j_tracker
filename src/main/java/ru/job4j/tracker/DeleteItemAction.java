package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    private final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ====");
        int itemToDelete = Integer.parseInt(input.askStr("Which item do you want to delete?"
                + System.lineSeparator() + "Write ID of item: "));
        if (tracker.delete(itemToDelete)) {
            out.println("Successfully deleted!");
        } else {
            out.println("Something went wrong... Try Again! :)");
        }
        return true;
    }
}
