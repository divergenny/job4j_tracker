package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr(""));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String msg = "Enter name: ";
                String name = input.askStr(msg);
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] item = tracker.findAll();
                showItems(item);
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                String msg = "Which Item would you want to Edit?"
                                    + System.lineSeparator() + "Your choice: ";
                int input2 = Integer.parseInt(input.askStr(msg));
                System.out.print("What is new value for Item?"
                                    + System.lineSeparator() + "New value: ");
                String newValue = input.askStr(msg);
                Item replaceItem = new Item(newValue);
                if (tracker.replace(input2, replaceItem)) {
                    System.out.println("Successfully modified!");
                } else {
                    System.out.println("Something went wrong... Try Again! :)");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                String msg = "Which item do you want to delete?"
                                    + System.lineSeparator() + "Write ID of item: ";
                int itemToDelete = Integer.parseInt(input.askStr(msg));
                if (tracker.delete(itemToDelete)) {
                    System.out.println("Successfully deleted!");
                } else {
                    System.out.println("Something went wrong... Try Again! :)");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                String msg = "Which item do you want to find?"
                                    + System.lineSeparator() + "Write ID of item: ";
                int id = Integer.parseInt(input.askStr(msg));
                Item item = tracker.findById(id);
                if (null == item) {
                    System.out.println("The item with this id was not found");
                } else {
                    System.out.println(item);
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                String msg = "What is name of item do you want to find? "
                        + System.lineSeparator() + "Write name of item: ";
                String applicationName = input.askStr(msg);
                Item[] foundItems = tracker.findByName(applicationName);
                if (foundItems.length > 0) {
                    showItems(foundItems);
                } else {
                    System.out.println("Item with this name were not found");
                }

            } else if (select == 6) {
                System.out.println("=== Have a nice day! :) ===");
                run = false;
            } else {
                System.out.println("You pressed the wrong key, try again");
            }
        }
    }

    private void showMenu() {
        System.out.println("\t\tMenu");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
        System.out.print("Select: ");
    }

    private void showItems(Item[] items) {
        for (int index = 0; index < items.length; index++) {
            System.out.println(items[index]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
