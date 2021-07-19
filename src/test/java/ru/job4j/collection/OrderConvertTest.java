package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = List.of(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenDuplicatesInOrder() {
        List<Order> orders = List.of(
                new Order("4s4s", "Trouser"),
                new Order("4s4s", "Trousers"),
                new Order("3sfe", "Dress")
        );
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(2));
    }
}