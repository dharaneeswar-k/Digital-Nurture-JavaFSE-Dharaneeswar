package com.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class PerformanceTesterTest {

    @Test
    void testPerformanceWithinTimeLimit() {
        PerformanceTester tester = new PerformanceTester();

        assertTimeout(Duration.ofMillis(1000), () -> {
            tester.performTask();
        });
    }
}
