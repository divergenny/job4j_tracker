package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class ConversionTest {

    @Test
    public void convertMatrixToListOfNum() {
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        Conversion convert = new Conversion();
        List<Integer> rsl = convert.convertMatrixToListOfNum(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        Assert.assertEquals(rsl, expected);
    }
}
