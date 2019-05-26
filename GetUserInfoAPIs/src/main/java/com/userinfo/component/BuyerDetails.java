package com.userinfo.component;

public class BuyerDetails {
	private String buyer_id,order_id,cust_order_status;
	private int order_num;
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	public String getCust_order_status() {
		return cust_order_status;
	}
	public void setCust_order_status(String cust_order_status) {
		this.cust_order_status = cust_order_status;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	
}
