package ru.job4j.inheritance;

public class Doctor extends Profession {
    private long curedPatients;

    public Doctor(String name, String surname,
                  String education, String birthday, long curedPatients) {
        super(name, surname, education, birthday);
        this.curedPatients = curedPatients;
    }

    public long getCuredPatients() {
        return curedPatients;
    }

    public String diagnosisHeal() {
        return "You are healthy!";
    }
}
