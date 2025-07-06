package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class LoggingAspect {

    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // Proceed to the actual method
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println("Execution Time of " + joinPoint.getSignature().getName() + "(): " + (end - start) + " ms");

        return result;
    }
}
