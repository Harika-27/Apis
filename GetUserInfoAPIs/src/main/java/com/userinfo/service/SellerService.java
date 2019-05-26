package com.userinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userinfo.component.SellerDetails;
import com.userinfo.repository.SellerDao;


@Service
public class SellerService {

	 @Autowired
	    private SellerDao cdao;
	 
	    public List<SellerDetails> getSellerDetails(String sid) {
	        return cdao.getSellerDetails(sid);
	    }
}
