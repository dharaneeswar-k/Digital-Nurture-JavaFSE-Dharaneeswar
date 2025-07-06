package com.example.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, 100})
    void testIsEven(int input) {
        assertTrue(MathUtils.isEven(input), input + " should be even");
    }
}
