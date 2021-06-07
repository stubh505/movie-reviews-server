package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.dao.ReviewsDAO;
import com.kaustubh.moviereviews.portal.exceptions.InvalidReviewException;
import com.kaustubh.moviereviews.portal.exceptions.ReviewNotFoundException;
import com.kaustubh.moviereviews.portal.models.Review;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ReviewServiceTest {

    @Mock
    ReviewsDAO reviewsDAO;

    @Mock
    Environment environment;

    @InjectMocks
    ReviewsService reviewsService = new ReviewsServiceImpl();

    @Test
    public void addReviewValidTest () {
        Mockito.when(reviewsDAO.addReview(Mockito.any(Review.class))).thenReturn("reviews");
        String res = reviewsService.addReview("M1001", new Review());

        Assert.assertNotNull(res);
    }

    @Test
    public void addReviewValidTestNoResult () {
        Mockito.when(reviewsDAO.addReview(Mockito.any(Review.class))).thenReturn("");
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidReviewException.class, () -> reviewsService.addReview("M1001", new Review()));
    }

    @Test
    public void addReviewValidTestNull () {
        Mockito.when(reviewsDAO.addReview(Mockito.any(Review.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidReviewException.class, () -> reviewsService.addReview("M1001", new Review()));
    }

    @Test
    public void addReviewInvalidTestNull () {
        Mockito.when(reviewsDAO.addReview(Mockito.any(Review.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidReviewException.class, () -> reviewsService.addReview("M1001", null));
    }

    @Test
    public void getAllValidTest () {
        List<Review> review = new ArrayList<>();
        review.add(new Review());
        Mockito.when(reviewsDAO.getAllReviews("M1001")).thenReturn(review);
        List<Review> res = reviewsService.getAllReviews("M1001");

        Assert.assertNotNull(res);
    }

    @Test
    public void getAllValidTestNoResult () {
        List<Review> review = new ArrayList<>();
        Mockito.when(reviewsDAO.getAllReviews(Mockito.anyString())).thenReturn(review);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(ReviewNotFoundException.class, () -> reviewsService.getAllReviews("M1001"));
    }

    @Test
    public void getAllValidTestNull () {
        Mockito.when(reviewsDAO.getAllReviews(Mockito.anyString())).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(ReviewNotFoundException.class, () -> reviewsService.getAllReviews("M1001"));
    }

    @Test
    public void getUserValidTest () {
        List<Review> review = new ArrayList<>();
        review.add(new Review());
        Mockito.when(reviewsDAO.getUserReviews("M1001")).thenReturn(review);
        List<Review> res = reviewsService.getUserReviews("M1001");

        Assert.assertNotNull(res);
    }

    @Test
    public void getUserValidTestNoResult () {
        List<Review> review = new ArrayList<>();
        Mockito.when(reviewsDAO.getUserReviews(Mockito.anyString())).thenReturn(review);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(ReviewNotFoundException.class, () -> reviewsService.getUserReviews("M1001"));
    }

    @Test
    public void getUserValidTestNull () {
        Mockito.when(reviewsDAO.getUserReviews(Mockito.anyString())).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(ReviewNotFoundException.class, () -> reviewsService.getUserReviews("M1001"));
    }

    @Test
    public void getUserInvalidTest () {
        Mockito.when(reviewsDAO.getUserReviews(Mockito.anyString())).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidReviewException.class, () -> reviewsService.getUserReviews(""));
    }

    @Test
    public void editReviewValidTestNoResult () {
        Mockito.when(reviewsDAO.editReview(Mockito.anyString(), Mockito.any(Review.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidReviewException.class, () -> reviewsService.editReview("A1001", new Review()));
    }

    @Test
    public void editReviewValidTestNull () {
        Mockito.when(reviewsDAO.editReview(Mockito.anyString(), Mockito.any(Review.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidReviewException.class, () -> reviewsService.editReview("A1001", new Review()));
    }

    @Test
    public void editReviewInvalidTestNull () {
        Mockito.when(reviewsDAO.editReview(Mockito.anyString(), Mockito.any(Review.class))).thenReturn(new Review());
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidReviewException.class, () -> reviewsService.editReview("A1001", null));
    }

    @Test
    public void deleteReviewValidTestNoResult () {
        Mockito.when(reviewsDAO.deleteReview(Mockito.anyString())).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(ReviewNotFoundException.class, () -> reviewsService.deleteReview("A1001"));
    }

    @Test
    public void deleteReviewValidTestNull () {
        Mockito.when(reviewsDAO.deleteReview(Mockito.anyString())).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(ReviewNotFoundException.class, () -> reviewsService.deleteReview("A1001"));
    }

    @Test
    public void deleteReviewInvalidTestNull () {
        Mockito.when(reviewsDAO.deleteReview(Mockito.anyString())).thenReturn("M101");
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidReviewException.class, () -> reviewsService.deleteReview(""));
    }
}
