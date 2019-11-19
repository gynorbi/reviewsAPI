package com.udacity.course3.reviews.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(){ }

    public ProductNotFoundException(Integer id){
        super("Product with id '"+id+"' was not found!");
    }
}
