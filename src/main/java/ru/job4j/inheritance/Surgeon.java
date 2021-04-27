package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private boolean operationalExperience;

    public Surgeon(String name, String surname,
                   String education, String birthday,
                   long curedPatients, boolean operationalExperience) {
        super(name, surname, education, birthday, curedPatients);
        this.operationalExperience = operationalExperience;
    }

    public boolean isOperationalExperience() {
        return operationalExperience;
    }

    public String doOperation() {
        return "Surgery operation in process...";
    }
}
