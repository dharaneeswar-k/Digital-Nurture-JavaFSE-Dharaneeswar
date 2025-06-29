package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenCheckerTest {

    private final EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 10, 100, 0, -2})
    void testIsEvenWithEvenNumbers(int number) {
        assertTrue(checker.isEven(number), number + " should be even");
    }
}
