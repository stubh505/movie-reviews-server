package com.kaustubh.moviereviews.portal.api;

import com.kaustubh.moviereviews.portal.models.Actor;
import com.kaustubh.moviereviews.portal.models.Movie;
import com.kaustubh.moviereviews.portal.services.ActorsService;
import com.kaustubh.moviereviews.portal.services.MoviesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "GET all actors", notes = "Returns list of actors")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Actors retrieved successfully"),
                    @ApiResponse(code = 404, message = "No actors retrieved")
            }
    )
    public ResponseEntity<List<Actor>> getActors() {
        List<Actor> res = actorsService.getAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{actorId}")
    @ApiOperation(value = "GET actor by ID", notes = "Returns actor")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Actor retrieved successfully"),
                    @ApiResponse(code = 404, message = "No actor retrieved")
            }
    )
    public ResponseEntity<Actor> getActorById(@PathVariable String actorId) {
        Actor res = actorsService.getActorById(actorId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{actorId}/movies")
    @ApiOperation(value = "GET all movies for actor ID", notes = "Returns list of movies")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Movies retrieved successfully"),
                    @ApiResponse(code = 404, message = "No movies retrieved")
            }
    )
    public ResponseEntity<List<Movie>> getMovies(@PathVariable String actorId) {
        List<Movie> res = moviesService.getMoviesOfActor(actorId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ApiOperation(value = "POST method to add new actor", notes = "Returns new actor id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Actor added successfully"),
                    @ApiResponse(code = 400, message = "Invalid actor details provided")
            }
    )
    public ResponseEntity<String> addActors(@RequestBody Actor actor) {
        String res = actorsService.addActor(actor);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{actorId}")
    @ApiOperation(value = "PUT method to edit existing actor", notes = "Returns new actor body")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Actor updated successfully"),
                    @ApiResponse(code = 400, message = "Invalid actor details provided")
            }
    )
    public ResponseEntity<Actor> editActors(@PathVariable String actorId, @RequestBody Actor actor) {
        Actor res = actorsService.editActor(actorId, actor);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
