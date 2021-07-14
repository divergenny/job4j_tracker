package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подходящих пользователей.
     */

    public ArrayList<Person> find(String key) {
        Predicate<Person> byName = (p) -> p.getName().contains(key);
        Predicate<Person> bySurname = (p) -> p.getSurname().contains(key);
        Predicate<Person> byPhone = (p) -> p.getPhone().contains(key);
        Predicate<Person> byAddress = (p) -> p.getAddress().contains(key);
        Predicate<Person> combine = byName.or(bySurname.or(byPhone.or(byAddress)));
        ArrayList<Person> result = new ArrayList<Person>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

}
