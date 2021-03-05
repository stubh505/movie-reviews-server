package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.exceptions.SearchResultsNotFoundException;

import java.util.List;

public interface SearchService {

    /**
     * Service method to search movies or actors by name
     *
     * @param query search query
     * @return List of actors/movies
     * @throws SearchResultsNotFoundException when no results returned
     */
    List<Object> search(String query);
}
