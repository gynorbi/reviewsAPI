package com.udacity.course3.reviews.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document("reviews")
public class ReviewDocument {
    @Id
    private Integer id;
    //@NotEmpty(message = "Please provide a non-empty title")
    private String title;
    private String description;
    //@NotNull(message = "Please provide a score")
    // @Min(value = 1,message = "Score should be at least 1")
    //@Max(value = 5,message = "Score should be maximum 5")
    private Integer score;
    //@NotEmpty(message = "Please provide a username")
    private String username;
    private List<CommentDocument> comments;

    public ReviewDocument() { }

    public ReviewDocument(String title, String description, Integer score, String username, List<CommentDocument> comments) {
        this.title = title;
        this.description = description;
        this.score = score;
        this.username = username;
        this.comments = comments;
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

    public List<CommentDocument> getComments() {
        return comments;
    }

    public void setComments(List<CommentDocument> comments) {
        this.comments = comments;
    }
}