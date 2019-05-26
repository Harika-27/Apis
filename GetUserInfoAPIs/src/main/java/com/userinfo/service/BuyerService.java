package com.userinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userinfo.component.BuyerDetails;
import com.userinfo.repository.BuyerDao;

@Service
public class BuyerService {
 
    @Autowired
    private BuyerDao bdao;
 
    public List<String> getBuyerIds() {
        return bdao.getBuyerIds();
    }
    
    public List<BuyerDetails> getBuyerDetails(String bid)
    {
    	return bdao.getBuyerDetails(bid);
    }
}