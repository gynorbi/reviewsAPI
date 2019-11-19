package com.udacity.course3.reviews.repositories;

import com.udacity.course3.reviews.entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Integer> {
}