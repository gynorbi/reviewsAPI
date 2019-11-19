package com.udacity.course3.reviews.repositories;

import com.udacity.course3.reviews.entities.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Integer> {
    List<Review> findByProductId(Integer productId);

    @Query("SELECT r FROM Review r WHERE r.productId = :productId AND r.score <= 2")
    List<Review> findLowScoreByProductId(Integer productId);
    @Query("SELECT r FROM Review r WHERE r.productId = :productId AND r.score BETWEEN 3 AND 4")
    List<Review> findMediumScoreByProductId(Integer productId);
    @Query("SELECT r FROM Review r WHERE r.productId = :productId AND r.score = 5")
    List<Review> findHighScoreByProductId(Integer productId);
}
