package com.udacity.course3.reviews.util;

import com.udacity.course3.reviews.entities.Comment;
import com.udacity.course3.reviews.entities.Product;
import com.udacity.course3.reviews.entities.Review;
import com.udacity.course3.reviews.repositories.CommentRepository;
import com.udacity.course3.reviews.repositories.ProductRepository;
import com.udacity.course3.reviews.repositories.ReviewRepository;

import java.util.Arrays;

public class TestData {
    public static Product createDummyProduct(ProductRepository productRepository){
        Product product = new Product();
        product.setName("Product 1");
        product.setDescription("Best product we have made so far!");
        return productRepository.save(product);
    }

    public static Review createDummyReview(ReviewRepository reviewRepository, Integer productId){
        Review review = new Review();
        review.setTitle("Fair review");
        review.setDescription("This review is very fair.");
        review.setScore(5);
        review.setUsername("fify");
        review.setProductId(productId);
        return reviewRepository.save(review);
    }
    public static Comment createDummyComment(CommentRepository commentRepository, Integer reviewId){
        Comment comment = new Comment();
        comment.setText("I like your review.");
        comment.setUsername("fify-lover");
        comment.setReviewId(reviewId);
        return commentRepository.save(comment);
    }

    public static Iterable<Review> createDummyReviewsWithScores(ReviewRepository reviewRepository, Integer productId){
        Iterable<Review> reviews = Arrays.asList(
                new Review("Nice","I like it",5,"user1",productId),
                new Review("Cool","I enjoy it",5,"user2",productId),
                new Review("Ok","Don't know yet",3,"user3",productId),
                new Review("Love it","Great product",5,"user4",productId),
                new Review("Quite bad","Regret buying it",2,"user5",productId),
                new Review("Terrible","I want my money back",1,"user6",productId),
                new Review("Splendid","Awesome product",5,"user7",productId),
                new Review("Had worse","Broke after 1 year",3,"user8",productId),
                new Review("Had better","Too expensive for what it gives",4,"user9",productId),
                new Review("Super","Love it",5,"user10",productId)
        );

        return reviewRepository.saveAll(reviews);
    }
}
