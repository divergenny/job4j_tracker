package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item chair = new Item("Chair");
        Item sofa = new Item("Sofa");
        Tracker tracker = new Tracker();
        tracker.add(chair);
        tracker.add(sofa);
        Item test = tracker.findById(2);
        System.out.println("Name: " + test.getName() + ", ID: " + test.getId());
        System.out.println("\n-----------------------\n");
        System.out.println(chair.toString());
        System.out.println(sofa.toString());
    }
}
