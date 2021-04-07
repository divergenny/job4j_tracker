package ru.job4j.oop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PointTest  {

    @Test
    public void whenFirstPoint2and4SecondPoint4and8Then4() {
        Point a = new Point(2, 4);
        Point b = new Point(4, 8);
        double result = a.distance(b);
        assertEquals(result, 4.47, 0.01);
    }

    @Test
    public void whenFirstPoint4and6SecondPoint12and14Then11() {
        Point a = new Point(4, 6);
        Point b = new Point(12, 14);
        double result = a.distance(b);
        assertEquals(result, 11.31, 0.01);
    }

    @Test
    public void whenFirstPoint5and5SecondPoint4and4Then1() {
        Point a = new Point(5, 5);
        Point b = new Point(4, 4);
        double result = a.distance(b);
        assertEquals(result, 1.41, 0.01);
    }

    @Test
    public void whenFirstPoint0and0SecondPoint0and0Then0() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        double result = a.distance(b);
        assertEquals(result, 0, 0.01);
    }

    @Test
    public void whenFirstPoint2and4and5SecondPoint4and8and8Then4() {
        Point a = new Point(2, 4, 5);
        Point b = new Point(4, 8, 8);
        double result = a.distance3d(b);
        assertEquals(result, 5.38, 0.01);
    }
}