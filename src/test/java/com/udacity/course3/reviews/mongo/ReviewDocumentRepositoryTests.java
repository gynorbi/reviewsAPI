package com.udacity.course3.reviews.mongo;

import com.udacity.course3.reviews.entities.ReviewDocument;
import com.udacity.course3.reviews.util.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ReviewDocumentRepositoryTests {

    @Autowired
    private ReviewDocumentRepository reviewDocumentRepository;

    @Test
    public void autowiringWorks(){
        Assert.assertNotNull(reviewDocumentRepository);
    }

    @Test
    public void savingReviewDocumentWorks(){
        ReviewDocument reviewDocument = new ReviewDocument(1,"review1","",5,"fify",null);
        reviewDocumentRepository.save(reviewDocument);
        ReviewDocument actualDocument = reviewDocumentRepository.findById(1).orElseThrow(()-> new AssertionError("Document was not found"));
        Assert.assertEquals("Id should be the same", actualDocument.getId(), reviewDocument.getId());
        Assert.assertEquals("Title should be the same", actualDocument.getTitle(),reviewDocument.getTitle());
    }
    @Test
    public void findReviewDocumentsWithLowScore(){
        List<ReviewDocument> reviews1 = TestData.createDummyReviewDocumentsWithScores(reviewDocumentRepository);
        List<Integer> reviewDocumentIds = Arrays.asList(1,3,5,7,9,10);

        List<ReviewDocument> actualReviews = reviewDocumentRepository.findLowScoreReviews(reviewDocumentIds);

        Assert.assertEquals("There should be 1 low review (score 1 and 2).",1,actualReviews.size());
        for(ReviewDocument r:actualReviews){
            Assert.assertTrue("Score is either 1 or 2",r.getScore() == 1 || r.getScore() == 2);
        }
    }

    @Test
    public void findReviewDocumentsWithMediumScore(){
        List<ReviewDocument> reviews1 = TestData.createDummyReviewDocumentsWithScores(reviewDocumentRepository);
        List<Integer> reviewDocumentIds = Arrays.asList(1,3,5,7,9,10);

        List<ReviewDocument> actualReviews = reviewDocumentRepository.findMediumScoreReviews(reviewDocumentIds);

        Assert.assertEquals("There should be 2 medium reviews (score 3 and 4).", 2,actualReviews.size());
        for(ReviewDocument r:actualReviews){
            Assert.assertTrue("Score is either 3 or 4",r.getScore() == 3 || r.getScore() == 4);
        }
    }

    @Test
    public void findReviewDocumentsWithHighScore(){
        List<ReviewDocument> reviews1 = TestData.createDummyReviewDocumentsWithScores(reviewDocumentRepository);
        List<Integer> reviewDocumentIds = Arrays.asList(1,3,5,7,9,10);

        List<ReviewDocument> actualReviews = reviewDocumentRepository.findHighScoreReviews(reviewDocumentIds);

        Assert.assertEquals("There should be 3 high reviews (score 5).", 3, actualReviews.size());
        for(ReviewDocument r:actualReviews){
            Assert.assertTrue("Score is 5",r.getScore() == 5);
        }
    }
}
