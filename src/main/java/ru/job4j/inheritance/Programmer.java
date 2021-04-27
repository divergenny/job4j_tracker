package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String[] languages = new String[10];

    public Programmer(String name, String surname,
                      String education, String birthday,
                      int numberProjects, String[] languages) {
        super(name, surname, education, birthday, numberProjects);
        this.languages = languages;
    }

    public String[] getLanguages() {
        return languages;
    }

    public String writeProcedure() {
        return "Writing procedure in progress...";
    }

    public String debugProgramme() {
        return "Debug programme in progress...";
    }
}
