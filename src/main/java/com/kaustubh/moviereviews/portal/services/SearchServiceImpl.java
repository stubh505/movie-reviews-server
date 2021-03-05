package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.dao.ActorsDAO;
import com.kaustubh.moviereviews.portal.dao.MoviesDAO;
import com.kaustubh.moviereviews.portal.exceptions.SearchResultsNotFoundException;
import com.kaustubh.moviereviews.portal.models.Actor;
import com.kaustubh.moviereviews.portal.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Autowired
    private MoviesDAO moviesDAO;
    @Autowired
    private ActorsDAO actorsDAO;
    @Autowired
    private Environment environment;

    @Override
    public List<Object> search(String query) {
        List<Movie> movieList = moviesDAO.searchMovie(query);
        List<Actor> actorList = actorsDAO.searchActor(query);

        if (movieList == null) {
            if (actorList == null)
                throw new SearchResultsNotFoundException(environment.getProperty("SEARCH_404"));
            else
                return Collections.singletonList(actorList);
        } else {
            if (actorList == null)
                return Collections.singletonList(movieList);
            else {
                List<Object> objects = new ArrayList<>(movieList);
                objects.addAll(actorList);
                return objects;
            }
        }
    }
}
