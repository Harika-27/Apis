package com.brs.component;

import java.util.List;

public class Buyer {
	String buyer_id;
	List<Orders> orders;
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Buyer [buyer_id=" + buyer_id + ", orders=" + orders + "]";
	}
}
