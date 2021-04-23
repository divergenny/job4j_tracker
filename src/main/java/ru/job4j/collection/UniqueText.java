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
        for (String textDuplicate : text) {
            rsl = check.contains(textDuplicate);
            if (!rsl) {
                break;
            }
        }
        return rsl;
    }
}
