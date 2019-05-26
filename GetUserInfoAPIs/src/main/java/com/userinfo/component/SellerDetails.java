package com.userinfo.component;

public class SellerDetails {
	private String seller_id,order_id,cust_order_status;
	private int order_num;
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
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
	@Override
	public String toString() {
		return "SellerDetails [seller_id=" + seller_id + ", order_id=" + order_id + ", cust_order_status="
				+ cust_order_status + ", order_num=" + order_num + "]";
	}
}
