package com.brs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.brs.component.ReferenceMaster;
import com.brs.component.RequestParameter;
import com.brs.service.RatingCalculateService;


@RestController
public class RatingCalculateController {
	@Autowired
	RatingCalculateService cservice;

	 @RequestMapping(value="/updateBuyerRatingInDatabase", method=RequestMethod.POST, headers="Accept=application/json",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public List<ReferenceMaster> getBuyerRatingInDatabase(@RequestBody RequestParameter rp) {
	    	System.out.println(rp);
	    	List<ReferenceMaster> list = cservice.updateBuyerRatingInDatabase(rp);      
	        return list;
	 }
	 
}
