package ru.job4j.inheritance;

public class Dentist extends Doctor {
    public String dentalExamination() {
        return "Dental examination in progress...";
    }

    public String pullOutTooth() {
        return "Pull out a tooth in progress...";
    }
}
