package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr(""));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
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

    private static void showItems(Item[] items) {
        for (int index = 0; index < items.length; index++) {
            System.out.println(items[index]);
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item createdItem = new Item(name);
        tracker.add(createdItem);
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] allItems = tracker.findAll();
        showItems(allItems);
    }

    public static void editItem(Input input, Tracker tracker) {
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
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int itemToDelete = Integer.parseInt(input.askStr("Which item do you want to delete?"
                + System.lineSeparator() + "Write ID of item: "));
        if (tracker.delete(itemToDelete)) {
            System.out.println("Successfully deleted!");
        } else {
            System.out.println("Something went wrong... Try Again! :)");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        int id = Integer.parseInt(input.askStr("Which item do you want to find?"
                + System.lineSeparator() + "Write ID of item: "));
        Item foundItem = tracker.findById(id);
        if (null == foundItem) {
            System.out.println("The item with this id was not found");
        } else {
            System.out.println(foundItem);
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String applicationName = input.askStr("What is name of item do you want to find? "
                + System.lineSeparator() + "Write name of item: ");
        Item[] foundItems = tracker.findByName(applicationName);
        if (foundItems.length > 0) {
            showItems(foundItems);
        } else {
            System.out.println("Item with this name were not found");
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
