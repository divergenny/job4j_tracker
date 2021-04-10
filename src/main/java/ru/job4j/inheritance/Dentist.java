package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int priceOfSeal;

    public Dentist(String name, String surname, String education, String birthday, long curedPatients) {
        super(name, surname, education, birthday, curedPatients);
    }

    public int getPriceOfSeal() {
        return priceOfSeal;
    }

    public void setPriceOfSeal(int priceOfSeal) {
        this.priceOfSeal = priceOfSeal;
    }

    public String dentalExamination() {
        return "Dental examination in progress...";
    }

    public String pullOutTooth() {
        return "Pull out a tooth in progress...";
    }
}
