package com.udacity.course3.reviews.repositories;

import com.udacity.course3.reviews.entities.Product;
import com.udacity.course3.reviews.entities.Review;
import com.udacity.course3.reviews.util.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryTests {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void autowiringWorks(){
        Assert.assertNotNull(productRepository);
        Assert.assertNotNull(reviewRepository);
    }

    @Test
    public void findReviewOnNonExistingProduct(){
        List<Review> comments = reviewRepository.findByProductId(100);
        Assert.assertEquals("There should be no reviews.", 0, comments.size());
    }

    @Test
    public void findReviewOnExistingProduct(){
        Product product = TestData.createDummyProduct(productRepository);
        Review review = TestData.createDummyReview(reviewRepository,product.getId());

        List<Review> reviews = reviewRepository.findByProductId(product.getId());

        Assert.assertEquals("There should be one review.", 1, reviews.size());
        Assert.assertEquals("The review should be the same as the inserted one.", review.getId(), reviews.get(0).getId());
    }

    @Test
    public void findReviewWithLowScoreForExistingProduct(){
        Product product1 = TestData.createDummyProduct(productRepository);
        Product product2 = TestData.createDummyProduct(productRepository);
        Iterable<Review> reviews1 = TestData.createDummyReviewsWithScores(reviewRepository, product1.getId());
        Iterable<Review> reviews2 = TestData.createDummyReviewsWithScores(reviewRepository, product2.getId());

        List<Review> actualReviews = reviewRepository.findLowScoreByProductId(product1.getId());

        Assert.assertEquals("There should be 2 low reviews (score 1 and 2).",2,actualReviews.size());
        for(Review r:actualReviews){
            Assert.assertTrue("Score is either 1 or 2",r.getScore() == 1 || r.getScore() == 2);
        }
    }

    @Test
    public void findReviewWithMediumScore(){
        Product product1 = TestData.createDummyProduct(productRepository);
        Product product2 = TestData.createDummyProduct(productRepository);
        Iterable<Review> reviews1 = TestData.createDummyReviewsWithScores(reviewRepository, product1.getId());
        Iterable<Review> reviews2 = TestData.createDummyReviewsWithScores(reviewRepository, product2.getId());

        List<Review> actualReviews = reviewRepository.findMediumScoreByProductId(product1.getId());

        Assert.assertEquals("There should be 3 medium reviews (score 3 and 4).", 3,actualReviews.size());
        for(Review r:actualReviews){
            Assert.assertTrue("Score is either 3 or 4",r.getScore() == 3 || r.getScore() == 4);
        }
    }

    @Test
    public void findReviewWithHighScore(){
        Product product1 = TestData.createDummyProduct(productRepository);
        Product product2 = TestData.createDummyProduct(productRepository);
        Iterable<Review> reviews1 = TestData.createDummyReviewsWithScores(reviewRepository, product1.getId());
        Iterable<Review> reviews2 = TestData.createDummyReviewsWithScores(reviewRepository, product2.getId());

        List<Review> actualReviews = reviewRepository.findHighScoreByProductId(product1.getId());

        Assert.assertEquals("There should be 5 high reviews (score 5).", 5, actualReviews.size());
        for(Review r:actualReviews){
            Assert.assertTrue("Score is 5",r.getScore() == 5);
        }
    }
}
