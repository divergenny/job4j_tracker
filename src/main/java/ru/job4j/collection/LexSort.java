package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftValues = left.split("\\.");
        String[] rightValues = right.split("\\.");
        int result = 0;
        boolean flagEqual = true;
        int leftValuesLength = leftValues.length;
        int rightValuesLength = rightValues.length;
        int itrLength = (Math.min(leftValuesLength, rightValuesLength) - 1);
        for (int index = 0; index < itrLength; index++) {
            int leftNum = Integer.parseInt(leftValues[index]);
            int rightNum = Integer.parseInt(rightValues[index]);
            result = Integer.compare(leftNum, rightNum);
            if (result != 0) {
                flagEqual = false;
                break;
            }
        }
        if (flagEqual && leftValuesLength != rightValuesLength) {
            return leftValuesLength > rightValuesLength ? 1 : -1;
        }
        return result;
    }
}
