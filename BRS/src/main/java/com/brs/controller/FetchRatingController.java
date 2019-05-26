package com.brs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brs.service.FetchRatingService;


@RestController
public class FetchRatingController {
	
	@Autowired
	FetchRatingService frs;
	
	@RequestMapping(value="/getRating/{id}", method=RequestMethod.GET, headers="Accept=application/json")
    public int getRating(@PathVariable(name="id") String id) {
        return frs.getRating(id);
    }
}
