package com.udacity.course3.reviews.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Please provide a non-empty name")
    private String name;
    @NotNull(message = "Please provide a description")
    private String description;
    @OneToMany(mappedBy = "productId")
    private List<Review> reviews;
    @Transient
    private Double average;

    public Product() { }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }
}
