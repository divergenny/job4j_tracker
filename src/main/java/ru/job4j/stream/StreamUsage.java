package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(-2);
        integers.add(-6);
        integers.add(5);
        integers.add(-5);
        integers.add(6);
        List<Integer> positiveInt = integers.stream()
                .filter(number -> number >= 0)
                .collect(Collectors.toList());
        positiveInt.forEach(System.out::println);
    }
}
