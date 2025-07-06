package com.library.aspect;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

    public void logBefore(JoinPoint joinPoint) {
        System.out.println("🔹 [Before] Calling: " + joinPoint.getSignature().getName());
    }

    public void logAfter(JoinPoint joinPoint) {
        System.out.println("🔸 [After] Finished: " + joinPoint.getSignature().getName());
    }
}
