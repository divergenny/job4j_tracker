package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FactTest {
    @Test
    public void whenCalcFact5() {
        Fact test = new Fact();
        int result = test.calc(5);
        assertThat(result, is(120));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalcFactWithNegativeNumber() {
        Fact test = new Fact();
        int result = test.calc(-1);
    }
}