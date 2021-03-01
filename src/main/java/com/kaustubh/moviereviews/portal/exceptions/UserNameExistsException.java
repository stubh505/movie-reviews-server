package com.kaustubh.moviereviews.portal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNameExistsException extends InvalidUserException {
    public UserNameExistsException() {
        super("Username already registered, please try a new one");
    }
}
