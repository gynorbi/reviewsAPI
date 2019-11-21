package com.udacity.course3.reviews.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("reviews")
public class ReviewDocument {
    @Id
    private Integer id;
    private String title;
    private String description;
    private Integer score;
    private String username;
    private List<CommentDocument> comments;

    public ReviewDocument() { }

    public ReviewDocument(Integer id, String title, String description, Integer score, String username, List<CommentDocument> comments) {
        this.id = id;
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