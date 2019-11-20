package com.udacity.course3.reviews.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Please provide a non-empty title")
    private String title;
    private String description;
    @NotNull(message = "Please provide a score")
    @Min(value = 1,message = "Score should be at least 1")
    @Max(value = 5,message = "Score should be maximum 5")
    private Integer score;
    @NotEmpty(message = "Please provide a username")
    private String username;
    private Integer productId;
    @OneToMany(mappedBy = "reviewId")
    private List<Comment> comments;

    public Review() { }

    public Review(String title, String description, Integer score, String username, Integer productId) {
        this.title = title;
        this.description = description;
        this.score = score;
        this.username = username;
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
