package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionThrowerTest {

    @Test
    void testThrowException() {
        ExceptionThrower thrower = new ExceptionThrower();

        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(true);
        });
    }

    @Test
    void testNoException() {
        ExceptionThrower thrower = new ExceptionThrower();

        // No exception should be thrown here
        thrower.throwException(false);
    }
}
