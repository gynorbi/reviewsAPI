package com.udacity.course3.reviews.repositories;

import com.udacity.course3.reviews.entities.Comment;
import com.udacity.course3.reviews.entities.Product;
import com.udacity.course3.reviews.entities.Review;
import com.udacity.course3.reviews.util.TestData;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTests {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void autowiringWorks(){
        Assert.assertNotNull(productRepository);
        Assert.assertNotNull(reviewRepository);
        Assert.assertNotNull(commentRepository);
    }

    @Test
    public void findCommentOnNonExistingReview(){
        List<Comment> comments = commentRepository.findByReviewId(100);
        Assert.assertEquals("There should be no comments.", 0, comments.size());
    }

    @Test
    public void findCommentOnExistingReview(){
        Product product = TestData.createDummyProduct(productRepository);
        Review review = TestData.createDummyReview(reviewRepository,product.getId());
        Comment comment = TestData.createDummyComment(commentRepository,review.getId());

        List<Comment> comments = commentRepository.findByReviewId(review.getId());

        Assert.assertEquals("There should be one comment.", 1, comments.size());
        Assert.assertEquals("The comment should be the same as the inserted one.", comment.getId(), comments.get(0).getId());
    }
}
