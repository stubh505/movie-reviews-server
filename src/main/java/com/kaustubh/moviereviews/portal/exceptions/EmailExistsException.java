package com.kaustubh.moviereviews.portal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailExistsException extends InvalidUserException {
    public EmailExistsException() {
        super("Email already registered, please login");
    }
}