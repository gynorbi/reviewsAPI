package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entities.Review;
import com.udacity.course3.reviews.repositories.ProductRepository;
import com.udacity.course3.reviews.repositories.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    private ProductRepository productRepository;
    private ReviewRepository reviewRepository;

    public ReviewsController(ProductRepository productRepository, ReviewRepository reviewRepository) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
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
            @RequestBody Review review) {
        if(productRepository.existsById(productId)){
            review.setProductId(productId);
            Review savedReview = reviewRepository.save(review);
            return new ResponseEntity<>(savedReview,HttpStatus.CREATED);
        }
       else{
           throw new ProductNotFoundException(productId);
        }
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @param score The score range of the review. 1 and 2 -> low; 3 and 4 -> medium; 5 -> high
     * @return The list of reviews or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") Integer productId,
                                                         @RequestParam(required = false, value = "score") String score) {
        if (!productRepository.existsById(productId)) {
            throw new ProductNotFoundException(productId);
        }
        List<Review> productReviews;
        if (score != null && score.toLowerCase().equals("low")) {
            productReviews = reviewRepository.findLowScoreByProductId(productId);
        } else if (score != null && score.toLowerCase().equals("medium")) {
            productReviews = reviewRepository.findMediumScoreByProductId(productId);
        } else if (score != null && score.toLowerCase().equals("high")) {
            productReviews = reviewRepository.findHighScoreByProductId(productId);
        } else {
            productReviews = reviewRepository.findByProductId(productId);
        }
        return new ResponseEntity<>(productReviews, HttpStatus.OK);
    }
}