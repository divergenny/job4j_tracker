package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book howStartNewLife = new Book("How to start a new life on Monday and not quit on Tuesday", 272);
        Book howStartThink = new Book("How to start thinking on Monday and not stop on Tuesday", 330);
        Book thinkSlowlyDecideQuickly = new Book("Think slowly... decide quickly", 710);
        Book cleanCode = new Book("Clean Code: A Handbook of Agile Software Craftsmanship", 464);
        Book[] books = new Book[4];
        books[0] = howStartNewLife;
        books[1] = howStartThink;
        books[2] = thinkSlowlyDecideQuickly;
        books[3] = cleanCode;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + ". This book have " + bk.getPages() + " pages.");
        }
        System.out.println("Change 0 element with third.");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + ". This book have " + bk.getPages() + " pages.");
        }
        System.out.println("Show books where written: Clean Code");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName().contains("Clean Code")) {
                System.out.println(bk.getName() + ". This book have " + bk.getPages() + " pages.");
            }
        }
    }
}
