package ru.job4j.stream;

import java.util.Comparator;

public class SortByCity implements Comparator<Address> {
    @Override
    public int compare(Address firstCity, Address secondCity) {
        return firstCity.getCity().compareTo(secondCity.getCity());
    }
}
