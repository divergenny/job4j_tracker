package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23),
                new Attachment("image 10", 24)
        };
        String[] testValues = {"image 1", "image 2", "image 33"};
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        Arrays.sort(atts, comparator);
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right) ->
                Integer.compare(right.length(), left.length());
        Arrays.sort(testValues, cmpText);
        for (String val : testValues) {
            System.out.println(val);
        }
        Arrays.sort(testValues, cmpDescSize);
        for (String val : testValues) {
            System.out.println(val);
        }
    }
}
