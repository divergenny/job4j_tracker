package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] testValues = {"image 1", "image 2", "image 33"};
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + ":" + left.length());
            return right.length() - left.length();
        };
        Arrays.sort(testValues, cmpDescSize);
        for (String val : testValues) {
            System.out.println(val);
        }
    }
}
