package com.udacity.course3.reviews.services;

import com.udacity.course3.reviews.controller.ProductNotFoundException;
import com.udacity.course3.reviews.controller.ReviewNotFoundException;
import com.udacity.course3.reviews.entities.Comment;
import com.udacity.course3.reviews.entities.CommentDocument;
import com.udacity.course3.reviews.entities.Review;
import com.udacity.course3.reviews.entities.ReviewDocument;
import com.udacity.course3.reviews.jpa.CommentRepository;
import com.udacity.course3.reviews.jpa.ProductRepository;
import com.udacity.course3.reviews.jpa.ReviewRepository;
import com.udacity.course3.reviews.mongo.ReviewDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private ReviewDocumentRepository reviewDocumentRepository;
    private ReviewRepository reviewRepository;
    private ProductRepository productRepository;
    private CommentRepository commentRepository;

    public ReviewService(ReviewDocumentRepository reviewDocumentRepository, ReviewRepository reviewRepository, ProductRepository productRepository, CommentRepository commentRepository) {
        this.reviewDocumentRepository = reviewDocumentRepository;
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.commentRepository = commentRepository;
    }

    public void addCommentToReview(Integer reviewId, Comment comment) throws ReviewNotFoundException {
            ReviewDocument reviewDocument = reviewDocumentRepository.findById(reviewId).orElseThrow(()-> new ReviewNotFoundException(reviewId));
            comment.setReviewId(reviewId);
            Comment savedComment = commentRepository.save(comment);
            CommentDocument newComment = new CommentDocument(savedComment.getText(),savedComment.getUsername());

            List<CommentDocument> previousComments = Optional.ofNullable(reviewDocument.getComments()).orElse(new ArrayList<>());
            previousComments.add(newComment);
            reviewDocument.setComments(previousComments);
            reviewDocumentRepository.save(reviewDocument);
    }

    public List<?> getCommentsForReview(Integer reviewId) throws ReviewNotFoundException {
        ReviewDocument reviewDocument = reviewDocumentRepository.findById(reviewId).orElseThrow(()-> new ReviewNotFoundException(reviewId));
        return Optional.ofNullable(reviewDocument.getComments()).orElse(Collections.emptyList());

    }

    public void addReviewToProduct(Integer productId, Review review) throws ProductNotFoundException{
        if(productRepository.existsById(productId)){
            review.setProductId(productId);
            Review savedReview = reviewRepository.save(review);
            ReviewDocument reviewDocument = new ReviewDocument(
                            savedReview.getId(), savedReview.getTitle(),
                            savedReview.getDescription(), savedReview.getScore(),
                            savedReview.getUsername(),null);
            reviewDocumentRepository.save(reviewDocument);
        }
        else{
            throw new ProductNotFoundException(productId);
        }
    }

    public Iterable<?> getReviewsForProduct(Integer productId, String score) throws ProductNotFoundException {
        if (!productRepository.existsById(productId)) {
            throw new ProductNotFoundException(productId);
        }
        List<Integer> reviewIds = reviewRepository.findByProductId(productId)
                .stream().map(Review::getId).collect(Collectors.toList());
        if (score != null && score.toLowerCase().equals("low")) {
            return reviewDocumentRepository.findLowScoreReviews(reviewIds);
        } else if (score != null && score.toLowerCase().equals("medium")) {
            return reviewDocumentRepository.findMediumScoreReviews(reviewIds);
        } else if (score != null && score.toLowerCase().equals("high")) {
            return reviewDocumentRepository.findHighScoreReviews(reviewIds);
        } else {
            return reviewDocumentRepository.findAllById(reviewIds);
        }
    }
}
