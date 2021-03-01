package com.kaustubh.moviereviews.portal.api;

import com.kaustubh.moviereviews.portal.models.Review;
import com.kaustubh.moviereviews.portal.models.User;
import com.kaustubh.moviereviews.portal.services.ReviewsService;
import com.kaustubh.moviereviews.portal.services.UsersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersAPI {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ReviewsService reviewsService;

    @GetMapping("/{userId}")
    @ApiOperation("GET user by ID")
    @ApiResponse(code = 200, message = "User retrieved")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User res = usersService.getUser(userId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{userId}/reviews/all")
    @ApiOperation("GET all reviews for user ID")
    @ApiResponse(code = 200, message = "Reviews retrieved")
    public ResponseEntity<List<Review>> getReviews(@PathVariable String userId) {
        List<Review> res = reviewsService.getUserReviews(userId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/register")
    @ApiOperation("POST method to add new user")
    @ApiResponse(code = 201, message = "User successfully registered")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String res = usersService.addUser(user);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    @ApiOperation("PUT method to edit existing actor")
    @ApiResponse(code = 201, message = "User successfully updated")
    public ResponseEntity<User> editUser(@PathVariable String userId, @RequestBody User user) {
        User res = usersService.editUser(userId, user);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
