package ru.job4j.inheritance;

public class Builder extends Engineer {
    private boolean certificate;

    public Builder(String name, String surname, String education,
                   String birthday, int numberProjects, boolean certificate) {
        super(name, surname, education, birthday, numberProjects);
        this.certificate = certificate;
    }

    public boolean isCertificate() {
        return certificate;
    }

    public String buildArchitecture() {
        return "Building...";
    }
}
