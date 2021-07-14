package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CountingFunctionInRange {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int initial = start; initial < end; initial++) {
            rsl.add(func.apply((double) initial));
        }
        return rsl;
    }
}
