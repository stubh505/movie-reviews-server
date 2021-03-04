package com.kaustubh.moviereviews.portal.api;

import com.kaustubh.moviereviews.portal.models.Actor;
import com.kaustubh.moviereviews.portal.models.Movie;
import com.kaustubh.moviereviews.portal.services.ActorsService;
import com.kaustubh.moviereviews.portal.services.MoviesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsAPI {

    @Autowired
    private ActorsService actorsService;

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/all")
    @ApiOperation("GET all actors")
    @ApiResponse(code = 200, message = "Actors retrieved successfully")
    public ResponseEntity<List<Actor>> getActors() {
        List<Actor> res = actorsService.getAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{actorId}")
    @ApiOperation("GET actor by ID")
    @ApiResponse(code = 200, message = "Actor retrieved successfully")
    public ResponseEntity<Actor> getActorById(@PathVariable String actorId) {
        Actor res = actorsService.getActorById(actorId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{actorId}/movies")
    @ApiOperation("GET all movies for actor ID")
    @ApiResponse(code = 200, message = "Movies retrieved successfully")
    public ResponseEntity<List<Movie>> getMovies(@PathVariable String actorId) {
        List<Movie> res = moviesService.getMoviesOfActor(actorId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ApiOperation("POST method to add new actor")
    @ApiResponse(code = 201, message = "Actor added successfully")
    public ResponseEntity<String> addActors(@RequestBody Actor actor) {
        String res = actorsService.addActor(actor);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{actorId}")
    @ApiOperation("PUT method to edit existing actor")
    @ApiResponse(code = 201, message = "Actor updated successfully")
    public ResponseEntity<Actor> editActors(@PathVariable String actorId, @RequestBody Actor actor) {
        Actor res = actorsService.editActor(actorId, actor);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
