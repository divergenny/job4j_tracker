package ru.job4j.tracker;

import java.io.IOException;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] item = tracker.findAll();
                showItems(item);
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Which Item would you want to Edit? \nYour choice: ");
                int input = Integer.parseInt(scanner.nextLine());
                System.out.print("What is new value for Item? \nNew value: ");
                String newValue = scanner.nextLine();
                Item replaceItem = new Item(newValue);
                if (tracker.replace(input, replaceItem)) {
                    System.out.println("Successfully modified!");
                } else {
                    System.out.println("Something went wrong... Try Again! :)");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Which item do you want to delete? \nWrite ID of item: ");
                int itemToDelete = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(itemToDelete)) {
                    System.out.println("Successfully deleted!");
                } else {
                    System.out.println("Something went wrong... Try Again! :)");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Which item do you want to find? \nWrite ID of item: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (null == item) {
                    System.out.println("The application with this id was not found");
                } else {
                    System.out.println(item);
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("What is name of application do you want to find? "
                        + "\nWrite name of application: ");
                String applicationName = scanner.nextLine();
                Item[] foundItems = tracker.findByName(applicationName);
                if (foundItems.length > 0) {
                    showItems(foundItems);
                } else {
                    System.out.println("Applications with this name were not found");
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

    public void cls() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
