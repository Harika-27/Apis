package com.brs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.repository.FetchRatingDao;


@Service
public class FetchRatingService {

	@Autowired
	FetchRatingDao fd;
	
	@Transactional
    public int getRating(String id) {
        return fd.getRating(id);
    }   
}
