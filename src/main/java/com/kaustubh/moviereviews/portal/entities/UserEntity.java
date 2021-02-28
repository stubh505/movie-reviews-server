package com.kaustubh.moviereviews.portal.entities;

import com.kaustubh.moviereviews.portal.enums.UserType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_entity")
public class UserEntity {

    @Id
    @GenericGenerator(
            name = "idGen",
            strategy = "com.kaustubh.moviereviews.portal.entities.IdGen",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "entity_name",
                            value = "user_entity"),
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_prefix",
                            value = "U")
            })
    @GeneratedValue(generator = "idGen")
    private String userId;
    @Column(length = 30)
    private String userName;
    @Column(length = 70)
    private String name;
    @Column(length = 100)
    private String email;
    @Column(length = 150)
    private String password;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoining;
    private int reviewCount;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "user_type")
    @Type(type = "pgsql_enum")
    private UserType userType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
