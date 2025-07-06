package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String userName = "Alice";
        int userAge = 30;

        logger.info("User {} has logged in", userName);
        logger.warn("User {} is reaching the age limit: {}", userName, userAge);
        logger.error("An error occurred for user {}", userName);
    }
}
