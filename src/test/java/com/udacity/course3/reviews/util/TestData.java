package com.udacity.course3.reviews.util;

import com.udacity.course3.reviews.entities.Comment;
import com.udacity.course3.reviews.entities.Product;
import com.udacity.course3.reviews.entities.Review;
import com.udacity.course3.reviews.repositories.CommentRepository;
import com.udacity.course3.reviews.repositories.ProductRepository;
import com.udacity.course3.reviews.repositories.ReviewRepository;

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
}
