package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SortByNameItemTest {
    @Test
    public void whenSortItemsByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Certificate"),
                new Item(2, "Best"),
                new Item(3, "Absolutely")
        );
        List<Item> expected = Arrays.asList(
                new Item(3, "Absolutely"),
                new Item(2, "Best"),
                new Item(1, "Certificate")
        );
        Collections.sort(items, new SortByNameItem());
        assertThat(items, is(expected));
    }

    @Test
    public void whenReverseSortItemsByName() {
        List<Item> items = Arrays.asList(
                new Item(3, "Absolutely"),
                new Item(1, "Certificate"),
                new Item(2, "Best")
        );
        List<Item> expected = Arrays.asList(
                new Item(1, "Certificate"),
                new Item(2, "Best"),
                new Item(3, "Absolutely")
        );
        Collections.sort(items, Collections.reverseOrder(new SortByNameItem()));
        assertThat(items, is(expected));
    }
}