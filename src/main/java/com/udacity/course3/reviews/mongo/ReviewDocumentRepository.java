package com.udacity.course3.reviews.mongo;

import com.udacity.course3.reviews.entities.ReviewDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDocumentRepository extends MongoRepository<ReviewDocument,Integer> {
   /* @Query("SELECT r FROM ReviewDocument r WHERE r.id IN (:reviewDocumentIds) AND r.score <= 2")
    List<ReviewDocument> getLowScoreReviews(List<Integer> reviewDocumentIds);
    @Query("SELECT r FROM ReviewDocument r WHERE r.id IN (:reviewDocumentIds) AND r.score BETWEEN 3 AND 4")
    List<ReviewDocument> getMediumScoreReviews(List<Integer> reviewDocumentIds);
    @Query("SELECT r FROM ReviewDocument r WHERE r.id IN (:reviewDocumentIds) AND r.score = 5")
    List<ReviewDocument> getHighScoreReviews(List<Integer> reviewDocumentIds);*/
}
