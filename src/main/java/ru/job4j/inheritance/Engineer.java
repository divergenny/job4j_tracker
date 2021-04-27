package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int numberProjects;

    public Engineer(String name, String surname,
                    String education, String birthday, int numberProjects) {
        super(name, surname, education, birthday);
        this.numberProjects = numberProjects;
    }

    public int getNumberProjects() {
        return numberProjects;
    }

    public String makeDiagram() {
        return "Drawing up a diagram in the process...";
    }
}
