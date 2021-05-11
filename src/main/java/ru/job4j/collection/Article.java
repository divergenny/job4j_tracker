package ru.job4j.collection;

import java.util.HashMap;

public class Article {
    public static boolean generateBy(String origin, String line) {
        HashMap<Integer, String> originWords = new HashMap<>();
        String[] originText = origin.split("[., :;!]");
        String[] lineText = line.split("[., :;!]");
        for (int index = 0; index < originText.length; index++) {
            originWords.put(index, originText[index]);
        }
        for (String word : lineText) {
            if (!originWords.containsValue(word)) {
                return false;
            }
        }
        return true;
    }
}
