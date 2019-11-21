package com.udacity.course3.reviews.jpa;

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
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void autowiringWorks(){
        Assert.assertNotNull(productRepository);
    }

    @Test
    public void averageCalculationIsCorrect(){
        Product product = TestData.createDummyProduct(productRepository);
        Iterable<Review> reviews = TestData.createDummyReviewsWithScores(reviewRepository,product.getId());

        Double actualAverage = productRepository.getAverageScoreById(product.getId());

        Assert.assertEquals("Average should be correct",3.8,actualAverage, 0.000001D);
    }
}
