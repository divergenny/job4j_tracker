package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CountingFunctionInRange {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (; start < end; start++) {
            rsl.add(func.apply((double) start));
        }
        return rsl;
    }
}
