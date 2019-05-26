package com.userinfo.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Order_details")
@Component
public class Order_Details {
	
	@Id
    @Column(name="ID")
    private String oid;
	
	@Column(name="Amount")
	private double amount;
	
	@Column(name="Price")
	private double price;
	
	@Column(name="Quanity")
	private int quantity;
	
	@Column(name="ORDER_ID")
	private String order_id;
	
	@Column(name="PRODUCT_ID")
	private String product_id;

	public Order_Details()
	{
		
	}
	
	public Order_Details(String oid, double amount, double price, int quantity, String order_id, String product_id) {
		super();
		this.oid = oid;
		this.amount = amount;
		this.price = price;
		this.quantity = quantity;
		this.order_id = order_id;
		this.product_id = product_id;
	}

	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	@Override
	public String toString() {
		return "Order_Details [oid=" + oid + ", amount=" + amount + ", price=" + price + ", quantity=" + quantity
				+ ", order_id=" + order_id + ", product_id=" + product_id + "]";
	}
	
}