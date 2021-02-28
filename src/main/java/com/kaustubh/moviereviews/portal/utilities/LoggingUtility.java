package com.kaustubh.moviereviews.portal.utilities;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingUtility {

    private final Logger logger = LoggerFactory.getLogger(LoggingUtility.class);

    @AfterThrowing(throwing = "e", pointcut = "execution(* com.kaustubh.moviereviews.portal.services.*Impl.*(..))")
    public void logServiceExceptions (Exception e) {
        logger.error(e.getMessage(), e);
    }

    @AfterThrowing(throwing = "e", pointcut = "execution(* com.kaustubh.moviereviews.portal.dao.*Impl.*(..))")
    public void logDAOExceptions (Exception e) {
        logger.error(e.getMessage(), e);
    }
}
