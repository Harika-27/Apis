package com.brs.component;

import java.util.List;

public class RequestParameter {
	List<Buyer> buyer;
	
	public List<Buyer> getBuyer() {
		return buyer;
	}
	public void setBuyer(List<Buyer> buyer) {
		this.buyer = buyer;
	}
	@Override
	public String toString() {
		return "RequestParameter [buyer=" + buyer + "]";
	}
}
