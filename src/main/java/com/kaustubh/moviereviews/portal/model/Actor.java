package com.kaustubh.moviereviews.portal.model;

import com.kaustubh.moviereviews.portal.enums.Country;

import java.time.LocalDate;

public class Actor {
    private String name;
    private String image;
    private LocalDate dateOfBirth;
    private Country country;

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
}
