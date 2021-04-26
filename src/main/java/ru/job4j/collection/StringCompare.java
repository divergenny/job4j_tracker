package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        boolean flagEqual = true;
        int leftLength = left.length();
        int rightLength = right.length();
        int length = Math.min(leftLength, rightLength);
        for (int index = 0; index < length; index++) {
            result = Character.compare(left.charAt(index), right.charAt(index));
            if (result != 0) {
                flagEqual = false;
                break;
            }
        }
        if (leftLength != rightLength && flagEqual) {
            return leftLength < rightLength ? -1 : 1;
        }
        return result;
    }
}
