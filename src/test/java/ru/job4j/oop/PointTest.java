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
    public void whenFirstPoint2and4and5SecondPoint4and8and8Then4() {
        Point a = new Point(2, 4, 5);
        Point b = new Point(4, 8, 8);
        double result = a.distance3d(b);
        assertEquals(result, 5.38, 0.01);
    }
}