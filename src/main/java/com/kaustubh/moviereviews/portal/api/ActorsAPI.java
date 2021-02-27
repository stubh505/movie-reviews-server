package com.kaustubh.moviereviews.portal.api;

import com.kaustubh.moviereviews.portal.models.Actor;
import com.kaustubh.moviereviews.portal.models.Movie;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsAPI {

    @GetMapping("/all")
    @ApiOperation("GET all actors")
    @ApiResponse(code = 200, message = "Okay")
    public ResponseEntity<List<Actor>> getActors() {
        return null;
    }

    @GetMapping("/{actorId}")
    @ApiOperation("GET actor by ID")
    @ApiResponse(code = 200, message = "Okay")
    public ResponseEntity<Actor> getActorById(@PathVariable String actorId) {
        return null;
    }

    @GetMapping("/{actorId}/movies/all")
    @ApiOperation("GET all movies for actor ID")
    @ApiResponse(code = 200, message = "Okay")
    public ResponseEntity<List<Movie>> getMovies() {
        return null;
    }

    @PostMapping("/add")
    @ApiOperation("POST method to add new actor")
    @ApiResponse(code = 201, message = "Created")
    public ResponseEntity<String> addActors() {
        return null;
    }

    @PutMapping("/add")
    @ApiOperation("PUT method to edit existing actor")
    @ApiResponse(code = 201, message = "Created")
    public ResponseEntity<Actor> editActors() {
        return null;
    }
}
