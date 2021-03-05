package com.kaustubh.moviereviews.portal.api;

import com.kaustubh.moviereviews.portal.models.Review;
import com.kaustubh.moviereviews.portal.models.User;
import com.kaustubh.moviereviews.portal.services.ReviewsService;
import com.kaustubh.moviereviews.portal.services.UsersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "GET user by ID", notes = "Returns user details")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "User retrieved successfully"),
                    @ApiResponse(code = 404, message = "No user retrieved")
            }
    )
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User res = usersService.getUser(userId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{userId}/reviews/all")
    @ApiOperation(value = "GET all reviews for user ID", notes = "Returns list of reviews")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Review retrieved successfully"),
                    @ApiResponse(code = 404, message = "No review retrieved")
            }
    )
    public ResponseEntity<List<Review>> getReviews(@PathVariable String userId) {
        List<Review> res = reviewsService.getUserReviews(userId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{userId}/reviews/{reviewId}")
    @ApiOperation(value = "PUT method to edit review for user ID", notes = "Returns new review body")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Review updated successfully"),
                    @ApiResponse(code = 404, message = "No review retrieved"),
                    @ApiResponse(code = 400, message = "Invalid review details provided")
            }
    )
    public ResponseEntity<Review> editReview(@PathVariable String reviewId, @RequestBody Review review) {
        Review res = reviewsService.editReview(reviewId, review);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/reviews/{reviewId}")
    @ApiOperation(value = "GET all reviews for user ID", notes = "Returns deleted review Id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 204, message = "Review deleted successfully"),
                    @ApiResponse(code = 404, message = "No review retrieved")
            }
    )
    public ResponseEntity<String> deleteReview(@PathVariable String reviewId) {
        String res = reviewsService.deleteReview(reviewId);
        return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/register")
    @ApiOperation(value = "POST method to add new user", notes = "Returns new user id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "User registered successfully"),
                    @ApiResponse(code = 400, message = "Invalid user details provided")
            }
    )
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String res = usersService.addUser(user);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    @ApiOperation(value = "PUT method to edit existing actor", notes = "Returns new user body")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "User updated successfully"),
                    @ApiResponse(code = 404, message = "No user retrieved"),
                    @ApiResponse(code = 400, message = "Invalid user details provided")
            }
    )
    public ResponseEntity<User> editUser(@PathVariable String userId, @RequestBody User user) {
        User res = usersService.editUser(userId, user);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
