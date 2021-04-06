package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() { }

    public void printIfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error defCnstr = new Error();
        Error paramCnstr1 = new Error(true, 1, "202");
        Error paramCnstr2 = new Error(false, 0, "404");
        defCnstr.printIfo();
        paramCnstr1.printIfo();
        paramCnstr2.printIfo();
    }
}
