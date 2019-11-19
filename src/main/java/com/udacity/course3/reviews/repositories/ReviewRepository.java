package com.udacity.course3.reviews.repositories;

import com.udacity.course3.reviews.entities.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Integer> {
    List<Review> findByProductId(Integer productId);
}
