package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftValues = left.split("\\.");
        String[] rightValues = right.split("\\.");
        return Integer.compare(Integer.parseInt(leftValues[0]), Integer.parseInt(rightValues[0]));
    }
}
