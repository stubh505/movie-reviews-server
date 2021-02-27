package com.kaustubh.moviereviews.portal.entities;

import com.kaustubh.moviereviews.portal.enums.Country;
import com.kaustubh.moviereviews.portal.enums.Language;
import com.kaustubh.moviereviews.portal.enums.Rating;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movie")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class MoviesEntity {

    @Id
    @GenericGenerator(
            name = "idGen",
            strategy = "com.kaustubh.moviereviews.portal.entities.IdGen",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "entity_name",
                            value = "movie"),
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_prefix",
                            value = "M")
            })
    @GeneratedValue(generator = "idGen")
    private String movieId;
    @Column(length = 100)
    private String name;
    private LocalDate releaseDate;
    @Column(length = 70)
    private String director;
    @Column(length = 1000)
    private String castActor;
    @Column(length = 2000)
    private String synopsys;
    @Column(length = 100)
    private String genre;
    private String poster;
    private String trailer;
    private int length;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "rating_type")
    @Type(type = "pgsql_enum")
    private Rating rating;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "language_type")
    @Type(type = "pgsql_enum")
    private Language language;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "country_type")
    @Type(type = "pgsql_enum")
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

    public String getCastActor() {
        return castActor;
    }

    public void setCastActor(String cast) {
        this.castActor = cast;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
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
}
