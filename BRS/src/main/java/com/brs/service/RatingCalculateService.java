package com.brs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.component.ReferenceMaster;
import com.brs.component.RequestParameter;
import com.brs.repository.RatingCalculateDao;


@Service
public class RatingCalculateService {

	@Autowired
	RatingCalculateDao cdao;
	
	@Transactional
	public List<ReferenceMaster> updateBuyerRatingInDatabase(RequestParameter rp) {
		return cdao.updateBuyerRatingInDatabase(rp);
	}
}
