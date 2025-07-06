package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingWithAppenders {

    private static final Logger logger = LoggerFactory.getLogger(LoggingWithAppenders.class);

    public static void main(String[] args) {
        logger.debug("Debug message: Application started");
        logger.info("Info message: Executing logging test");
        logger.warn("Warning message: Simulated warning");
        logger.error("Error message: Simulated error occurred");
    }
}
