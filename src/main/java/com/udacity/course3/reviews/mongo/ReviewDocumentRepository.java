package com.udacity.course3.reviews.mongo;

import com.udacity.course3.reviews.entities.ReviewDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDocumentRepository extends MongoRepository<ReviewDocument,Integer> {
    @Query("{_id:{$in:?0},score:{$lte:2}}")
    List<ReviewDocument> findLowScoreReviews(List<Integer> reviewDocumentIds);
    @Query("{_id:{$in:?0},score:{$gte:3,$lte:4}}")
    List<ReviewDocument> findMediumScoreReviews(List<Integer> reviewDocumentIds);
    @Query("{_id:{$in:?0},score:5}")
    List<ReviewDocument> findHighScoreReviews(List<Integer> reviewDocumentIds);
}
