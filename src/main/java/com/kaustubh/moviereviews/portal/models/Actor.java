package com.kaustubh.moviereviews.portal.models;

import com.kaustubh.moviereviews.portal.enums.Country;
import com.kaustubh.moviereviews.portal.enums.Gender;

import java.time.LocalDate;

public class Actor {
    private String actorId;
    private String name;
    private String image;
    private LocalDate dateOfBirth;
    private Country country;
    private Gender gender;
    private int movieCount;

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Country getCountry() {
        return country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getMovieCount() {
        return movieCount;
    }

    public void setMovieCount(int movieCount) {
        this.movieCount = movieCount;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId='" + actorId + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", country=" + country +
                ", gender=" + gender +
                ", movieCount=" + movieCount +
                '}';
    }
}
