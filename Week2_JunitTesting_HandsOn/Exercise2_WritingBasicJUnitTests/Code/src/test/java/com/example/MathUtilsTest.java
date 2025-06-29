package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MathUtilsTest {

    MathUtils math = new MathUtils();

    @Test
    public void testAdd() {
        assertEquals(5, math.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, math.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(15, math.multiply(3, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(4, math.divide(8, 2));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> math.divide(10, 0));
    }
}
