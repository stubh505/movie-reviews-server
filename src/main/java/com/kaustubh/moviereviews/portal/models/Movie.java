package com.kaustubh.moviereviews.portal.models;

import com.kaustubh.moviereviews.portal.enums.Country;
import com.kaustubh.moviereviews.portal.enums.Genre;
import com.kaustubh.moviereviews.portal.enums.Language;
import com.kaustubh.moviereviews.portal.enums.Rating;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    private String movieId;
    private String name;
    private LocalDate releaseDate;
    private String director;
    private List<Actor> cast;
    private String synopsys;
    private List<Genre> genre;
    private String poster;
    private String trailer;
    private String review;
    private String reviewCount;
    private int length;
    private Rating rating;
    private Language language;
    private Country country;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(String reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", name='" + name + '\'' +
                ", cast=" + cast +
                ", releaseDate=" + releaseDate +
                ", director='" + director + '\'' +
                ", synopsys='" + synopsys + '\'' +
                ", genre=" + genre +
                ", poster='" + poster + '\'' +
                ", trailer='" + trailer + '\'' +
                ", length=" + length +
                ", rating=" + rating +
                ", language=" + language +
                ", country=" + country +
                '}';
    }
}
