package ru.job4j.tracker;


import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item chair = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = chair.getTime().format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
        chair.setName("Chair");
        chair.setId(1);
        Item sofa = new Item(2, "Sofa");
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
