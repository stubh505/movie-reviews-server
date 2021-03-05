package com.kaustubh.moviereviews.portal.models;

import com.kaustubh.moviereviews.portal.enums.Country;
import com.kaustubh.moviereviews.portal.enums.Genre;
import com.kaustubh.moviereviews.portal.enums.Language;
import com.kaustubh.moviereviews.portal.enums.Rating;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.List;

@ApiModel("Movie Model")
public class Movie {

    @ApiModelProperty(value = "Generated movie Id")
    private String movieId;
    @ApiModelProperty(value = "Movie name", required = true)
    private String name;
    @ApiModelProperty(value = "Movie Release date", required = true)
    private LocalDate releaseDate;
    @ApiModelProperty(value = "Movie director", required = true)
    private String director;
    @ApiModelProperty(value = "List of Actors", required = true)
    private List<Actor> cast;
    @ApiModelProperty(value = "Movie Synopsys", required = true)
    private String synopsys;
    @ApiModelProperty(value = "List of movie genres", required = true)
    private List<Genre> genre;
    @ApiModelProperty(value = "Link to poster image", required = true)
    private String poster;
    @ApiModelProperty(value = "Link to movie trailer", required = true)
    private String trailer;
    @ApiModelProperty(value = "Numeric review rating, calculated by system")
    private String review;
    @ApiModelProperty(value = "Number of movie reviews, updated by system")
    private String reviewCount;
    @ApiModelProperty(value = "Length of movie in minutes", required = true)
    private int length;
    @ApiModelProperty(value = "Movie Rating", required = true)
    private Rating rating;
    @ApiModelProperty(value = "Movie Language", required = true)
    private Language language;
    @ApiModelProperty(value = "Movie country", required = true)
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
