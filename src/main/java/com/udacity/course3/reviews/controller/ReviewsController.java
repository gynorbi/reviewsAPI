package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entities.Review;
import com.udacity.course3.reviews.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    private ReviewService reviewService;

    public ReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<?> createReviewForProduct(
            @PathVariable("productId") Integer productId,
            @Valid @RequestBody Review review) {
        reviewService.addReviewToProduct(productId,review);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @param score The score range of the review. 1 and 2 -> low; 3 and 4 -> medium; 5 -> high
     * @return The list of reviews or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<?>> listReviewsForProduct(@PathVariable("productId") Integer productId,
                                                         @RequestParam(required = false, value = "score") String score) {
        Iterable<?> reviews = reviewService.getReviewsForProduct(productId, score);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}