package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entities.Comment;
import com.udacity.course3.reviews.jpa.CommentRepository;
import com.udacity.course3.reviews.jpa.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    private CommentRepository commentRepository;
    private ReviewRepository reviewRepository;

    public CommentsController(CommentRepository commentRepository, ReviewRepository reviewRepository) {
        this.commentRepository = commentRepository;
        this.reviewRepository = reviewRepository;
    }

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<?> createCommentForReview(
            @PathVariable("reviewId") Integer reviewId,
            @Valid @RequestBody Comment comment) {
        if(reviewRepository.existsById(reviewId)){
            comment.setReviewId(reviewId);
            Comment savedComment = commentRepository.save(comment);
            return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
        }
        else{
            throw new ReviewNotFoundException(reviewId);
        }
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public List<?> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {

        if(reviewRepository.existsById(reviewId)){
            return commentRepository.findByReviewId(reviewId);
        }
        else{
            throw new ReviewNotFoundException(reviewId);
        }
    }
}