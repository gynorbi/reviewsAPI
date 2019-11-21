package com.udacity.course3.reviews.jpa;

import com.udacity.course3.reviews.mongo.ReviewDocumentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ReviewDocumentRepositoryTests {

    @Autowired
    private ReviewDocumentRepository reviewDocumentRepository;

    @Test
    public void autowiringWorks(){
        Assert.assertNotNull(reviewDocumentRepository);
    }

    /*@Test
    public void findReviewDocumentsWithLowScore(){
        List<ReviewDocument> reviews1 = TestData.createDummyReviewDocumentsWithScores(reviewDocumentRepository);
        List<ReviewDocument> reviews2 = TestData.createDummyReviewDocumentsWithScores(reviewDocumentRepository);
        List<Integer> reviewDocumentIds = reviews1.stream().map(reviewDocument -> reviewDocument.getId()).collect(Collectors.toList());

        List<ReviewDocument> actualReviews = reviewDocumentRepository.findLowScoreByProductId(reviewDocumentIds);

        Assert.assertEquals("There should be 2 low reviews (score 1 and 2).",2,actualReviews.size());
        for(ReviewDocument r:actualReviews){
            Assert.assertTrue("Score is either 1 or 2",r.getScore() == 1 || r.getScore() == 2);
        }
    }

    @Test
    public void findReviewDocumentsWithMediumScore(){
        List<ReviewDocument> reviews1 = TestData.createDummyReviewDocumentsWithScores(reviewDocumentRepository);
        List<ReviewDocument> reviews2 = TestData.createDummyReviewDocumentsWithScores(reviewDocumentRepository);
        List<Integer> reviewDocumentIds = reviews1.stream().map(reviewDocument -> reviewDocument.getId()).collect(Collectors.toList());

        List<ReviewDocument> actualReviews = reviewDocumentRepository.findMediumScoreByProductId(reviewDocumentIds);

        Assert.assertEquals("There should be 3 medium reviews (score 3 and 4).", 3,actualReviews.size());
        for(ReviewDocument r:actualReviews){
            Assert.assertTrue("Score is either 3 or 4",r.getScore() == 3 || r.getScore() == 4);
        }
    }

    @Test
    public void findReviewDocumentsWithHighScore(){
        List<ReviewDocument> reviews1 = TestData.createDummyReviewDocumentsWithScores(reviewDocumentRepository);
        List<ReviewDocument> reviews2 = TestData.createDummyReviewDocumentsWithScores(reviewDocumentRepository);
        List<Integer> reviewDocumentIds = reviews1.stream().map(reviewDocument -> reviewDocument.getId()).collect(Collectors.toList());

        List<ReviewDocument> actualReviews = reviewDocumentRepository.findHighScoreByProductId(reviewDocumentIds);

        Assert.assertEquals("There should be 5 high reviews (score 5).", 5, actualReviews.size());
        for(ReviewDocument r:actualReviews){
            Assert.assertTrue("Score is 5",r.getScore() == 5);
        }
    }*/
}
