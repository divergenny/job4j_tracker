package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = false;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String textOrigin : origin) {
            check.add(textOrigin);
        }
        int count = 0;
        for (String textDuplicate : text) {
            if (check.contains(textDuplicate)) {
                count++;
            }
        }
        if (count > Math.ceil((origin.length - 1) * 0.8)) {
            rsl = true;
        }
        return rsl;
    }
}
