package com.udacity.course3.reviews.services;

import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    /*private ReviewDocumentRepository reviewDocumentRepository;
    private ReviewRepository reviewRepository;
    private ProductRepository productRepository;

    public ReviewService(ReviewDocumentRepository reviewDocumentRepository, ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewDocumentRepository = reviewDocumentRepository;
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    public Iterable<ReviewDocument> getReviewsWithComments(Integer productId) throws ProductNotFoundException {
        if(!productRepository.existsById(productId)){
            throw  new ProductNotFoundException(productId);
        }
        List<Review> reviews = reviewRepository.findByProductId(productId);
        List<Integer> reviewDocumentIds = reviews.stream().map(Review::getReviewDocumentId).collect(Collectors.toList());
        return reviewDocumentRepository.findAllById(reviewDocumentIds);
    }

    public void saveReview(ReviewDocument reviewDocument, Integer productId){
        ReviewDocument savedReview = reviewDocumentRepository.save(reviewDocument);
        Review review = new Review();
        review.setProductId(productId);
        review.setReviewDocumentId(savedReview.getId());
        reviewRepository.save(review);
    }

    public Iterable<ReviewDocument> getReviewsByScore(Integer productId, String score){
        if(!productRepository.existsById(productId)){
            throw  new ProductNotFoundException(productId);
        }
        List<Review> reviews = reviewRepository.findByProductId(productId);
        List<Integer> reviewDocumentIds = reviews.stream().map(Review::getReviewDocumentId).collect(Collectors.toList());
        if (score != null && score.toLowerCase().equals("low")) {
            return reviewDocumentRepository.findLowScoreByProductId(reviewDocumentIds);
        } else if (score != null && score.toLowerCase().equals("medium")) {
            return reviewDocumentRepository.findMediumScoreByProductId(reviewDocumentIds);
        } else if (score != null && score.toLowerCase().equals("high")) {
            return reviewDocumentRepository.findHighScoreByProductId(reviewDocumentIds);
        } else {
            return reviewDocumentRepository.findAllById(reviewDocumentIds);
        }
    }*/
}
