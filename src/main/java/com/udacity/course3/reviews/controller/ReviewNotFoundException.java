package com.udacity.course3.reviews.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReviewNotFoundException extends RuntimeException {

    public ReviewNotFoundException(){ }

    public ReviewNotFoundException(Integer id){
        super("Review with id '"+id+"' was not found!");
    }
}
