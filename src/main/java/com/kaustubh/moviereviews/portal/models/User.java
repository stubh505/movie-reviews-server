package com.kaustubh.moviereviews.portal.models;

import com.kaustubh.moviereviews.portal.enums.UserType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel("User Model")
public class User {

    @ApiModelProperty("Generated user id")
    private String userId;
    @ApiModelProperty(value = "Unique user name with 30 characters", required = true)
    private String userName;
    @ApiModelProperty(value = "Name of user with 70 characters", required = true)
    private String name;
    @ApiModelProperty(value = "Unique user email with 100 characters", required = true)
    private String email;
    @ApiModelProperty(value = "Unique user password that matches requirement", required = true)
    private String password;
    @ApiModelProperty(value = "User date of birth that matches requirement (16 years+)", required = true)
    private LocalDate dateOfBirth;
    @ApiModelProperty(value = "User date of joining added by system")
    private LocalDate dateOfJoining;
    @ApiModelProperty(value = "User review count updated by system")
    private int reviewCount;
    @ApiModelProperty(value = "User roles")
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

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", userType=" + userType +
                '}';
    }
}
