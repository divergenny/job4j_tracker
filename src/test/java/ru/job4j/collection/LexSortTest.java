package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortNum1and2and2Dot1() {
        String[] input = {
                "1.0. Task.",
                "2.1. Task.",
                "1. Task.",
                "1.0. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "1.0. Task.",
                "1.0. Task.",
                "2. Task.",
                "2.1. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortDataFromCourseExample() {
        String[] input = {
                "6.2.3. Task.",
                "6.3. Task.",
                "6.2.2. Task.",
                "6.2.1. Task.",
                "6.2. Task.",
                "6.1. Task.",
                "6.0.3. Массивы и цикл for.",
                "6.0.1. Обьявление массива.",
                "6.0.2. Заполнение массива."
        };
        String[] out = {
                "6.0.1. Обьявление массива.",
                "6.0.2. Заполнение массива.",
                "6.0.3. Массивы и цикл for.",
                "6.1. Task.",
                "6.2. Task.",
                "6.2.1. Task.",
                "6.2.2. Task.",
                "6.2.3. Task.",
                "6.3. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}