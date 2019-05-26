package com.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.component.SellerDetails;
import com.userinfo.service.SellerService;

@RestController
public class SellerController {
	@Autowired
    private SellerService cservice;
 
   
	@RequestMapping(value="/getSellerDetails/{sid}", method=RequestMethod.GET, headers="Accept=application/json")
    public List<SellerDetails> getSellerDetails(@PathVariable(name="sid") String sid) {
        List<SellerDetails> list = cservice.getSellerDetails(sid);      
        return list;
    }
   
}
