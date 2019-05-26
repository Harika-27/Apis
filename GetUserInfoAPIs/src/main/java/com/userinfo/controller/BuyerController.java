package com.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.component.BuyerDetails;
import com.userinfo.service.BuyerService;



@RestController
public class BuyerController {
 
    @Autowired
    private BuyerService bservice;
 
    
    @RequestMapping(value="/getBuyerIds", method=RequestMethod.GET, headers="Accept=application/json")
    public List<String> getBuyerIds() {
        List<String> list = bservice.getBuyerIds();      
        return list;
    }
    
    @RequestMapping(value="/getBuyerDetails/{bid}", method=RequestMethod.GET, headers="Accept=application/json")
    public List<BuyerDetails> getBuyerDetails(@PathVariable(name="bid") String bid) {
        List<BuyerDetails> list = bservice.getBuyerDetails(bid);      
        return list;
    }
}
