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
        Assert.assertTrue("There should be no reviews.",comments.size() == 0);
    }

    @Test
    public void findReviewOnExistingProduct(){
        Product product = TestData.createDummyProduct(productRepository);
        Review review = TestData.createDummyReview(reviewRepository,product.getId());

        List<Review> reviews = reviewRepository.findByProductId(product.getId());

        Assert.assertTrue("There should be one review.",reviews.size() == 1);
        Assert.assertEquals("The review should be the same as the inserted one.", review.getId(), reviews.get(0).getId());

    }
}
