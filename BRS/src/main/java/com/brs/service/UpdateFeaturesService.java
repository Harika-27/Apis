package com.brs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.repository.UpdateFeaturesDao;

@Service
public class UpdateFeaturesService {
	@Autowired
	UpdateFeaturesDao fd;
	
	@Transactional
    public List<Integer> getFeatures(int ratingWt) {
        return fd.getFeatures(ratingWt);
    }   
}
