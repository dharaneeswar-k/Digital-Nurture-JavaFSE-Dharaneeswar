package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(3)
    void testC() {
        System.out.println("Running testC");
        assertTrue(true);
    }

    @Test
    @Order(1)
    void testA() {
        System.out.println("Running testA");
        assertTrue(true);
    }

    @Test
    @Order(2)
    void testB() {
        System.out.println("Running testB");
        assertTrue(true);
    }
}
