package com.kaustubh.moviereviews.portal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SearchResultsNotFoundException extends RuntimeException {

    public SearchResultsNotFoundException(String m) {
        super(m);
    }
}
