package com.udacity.course3.reviews.jpa;

import com.udacity.course3.reviews.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findByReviewId(Integer reviewId);
}