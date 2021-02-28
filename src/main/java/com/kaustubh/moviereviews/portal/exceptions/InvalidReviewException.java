package com.kaustubh.moviereviews.portal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidReviewException extends RuntimeException {

    public InvalidReviewException(String m) {
        super(m);
    }
}
