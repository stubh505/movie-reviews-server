package com.kaustubh.moviereviews.portal.entities;

import com.kaustubh.moviereviews.portal.enums.Country;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "actor")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class ActorEntity {

    @Id
    @GenericGenerator(
            name = "idGen",
            strategy = "com.kaustubh.moviereviews.portal.entities.IdGen",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "entity_name",
                            value = "actor"),
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_prefix",
                            value = "A")
            })
    @GeneratedValue(generator = "idGen")
    private String actorId;
    @Column(length = 70)
    private String name;
    private String image;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "country_type")
    @Type(type = "pgsql_enum")
    private Country country;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public void setCountry(Country country) {
        this.country = country;
    }
}
