package ru.job4j.stream;

import java.math.BigInteger;

public class Professor {
    private String name;
    private String surname;
    private byte age;
    private String login;
    private String password;
    private boolean activated;
    private String gender;
    private BigInteger salary;

    @Override
    public String toString() {
        return "Professor{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", login='" + login + '\''
                + ", password='" + password + '\''
                + ", activated=" + activated
                + ", gender='" + gender + '\''
                + ", salary=" + salary
                + '}';
    }

    static class Builder {
        private String name;
        private String surname;
        private byte age;
        private String login;
        private String password;
        private boolean activated;
        private String gender;
        private BigInteger salary;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildLogin(String login) {
            this.login = login;
            return this;
        }

        Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        Builder buildActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Builder buildSalary(BigInteger salary) {
            this.salary = salary;
            return this;
        }

        Professor build() {
            Professor professor = new Professor();
            professor.name = name;
            professor.surname = surname;
            professor.age = age;
            professor.login = login;
            professor.password = password;
            professor.activated = activated;
            professor.gender = gender;
            professor.salary = salary;
            return professor;
        }

    }

    public static void main(String[] args) {
        Professor professor = new Builder()
                .buildName("name")
                .buildSurname("surname")
                .buildAge((byte) 32)
                .buildLogin("login")
                .buildPassword("password")
                .buildActivated(true)
                .buildGender("male")
                .buildSalary(BigInteger.valueOf(300000))
                .build();
        System.out.println(professor);
    }
}
