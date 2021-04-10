package ru.job4j.pojo;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class ShopDropTest {
    @Test
    public void whenDropFirst() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] rsl = ShopDrop.leftShift(products, 0);
        assertThat(rsl[0].getName(), is("Bread"));
        assertThat(rsl[1], is(nullValue()));
    }

    @Test
    public void whenDropLast() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] rsl = ShopDrop.leftShift(products, 1);
        assertThat(rsl[0].getName(), is("Milk"));
        assertThat(rsl[1], is(nullValue()));
    }

    @Test
    public void whenDropMiddle() {
        Product[] products = new Product[7];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Eag", 7);
        products[3] = new Product("Cake", 7);
        products[4] = new Product("Meat", 7);
        products[5] = new Product("Corn", 7);
        Product[] rsl = ShopDrop.leftShift(products, 4);
        assertThat(rsl[0].getName(), is("Milk"));
        assertThat(rsl[1].getName(), is("Bread"));
        assertThat(rsl[2].getName(), is("Eag"));
        assertThat(rsl[3].getName(), is("Cake"));
        assertThat(rsl[4].getName(), is("Corn"));
        assertThat(rsl[5], is(nullValue()));
        assertThat(rsl[6], is(nullValue()));
    }
}