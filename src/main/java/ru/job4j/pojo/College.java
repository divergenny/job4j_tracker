package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student denis = new Student();
        denis.setName("Denis");
        denis.setSurname("Kim");
        denis.setPatronymic("Valeryevich");
        denis.setGroup("304C");
        denis.setDateOfReceipt("10.04.2021");

        System.out.println(denis.getSurname() + " "
                + denis.getName() + " "
                + denis.getPatronymic() + " is studying in group: "
                + denis.getGroup() + " and date of receipt is: "
                + denis.getDateOfReceipt() + ".");
    }
}
