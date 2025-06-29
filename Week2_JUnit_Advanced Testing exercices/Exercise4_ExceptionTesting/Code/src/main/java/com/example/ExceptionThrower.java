package com.example;

public class ExceptionThrower {

    public void throwException(boolean shouldThrow) {
        if (shouldThrow) {
            throw new IllegalArgumentException("An exception was thrown");
        }
    }
}
