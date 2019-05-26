package com.userinfo.component;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
import org.springframework.stereotype.Component;
 
@Entity
@Table(name="Orders")
@Component
public class Orders {
 
    @Id
    @Column(name="ID")
    private String id;
 
    @Column(name="buyer_id")
    private String buyer_id;
 
    @Column(name="Order_Num")
    private int order_num;
    
    @Column(name="order_status")
    private String order_status;
 
    @Column(name="Amount")
    private double amt;
    
    @Column(name="Customer_Address")
    private String ca;
    
    @Column(name="Customer_Email")
    private String ce;
    
    @Column(name="Customer_Name")
    private String cn;
    
    @Column(name="Customer_Phone")
    private String cp;
    
    @Column(name="Order_Date")
    private Date order_date;
    
    @Column(name="payment_type")
    private String pt;
    
    @Column(name="customer_order_status")
    private String cust_order_status;
    
    public Orders() { }

	public Orders(String id, String buyer_id, int order_num, String order_status, double amt, String ca, String ce,
			String cn, String cp, Date order_date, String pt, String cust_order_status) {
		super();
		this.id = id;
		this.buyer_id = buyer_id;
		this.order_num = order_num;
		this.order_status = order_status;
		this.amt = amt;
		this.ca = ca;
		this.ce = ce;
		this.cn = cn;
		this.cp = cp;
		this.order_date = order_date;
		this.pt = pt;
		this.cust_order_status = cust_order_status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

	public String getCe() {
		return ce;
	}

	public void setCe(String ce) {
		this.ce = ce;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getCust_order_status() {
		return cust_order_status;
	}

	public void setCust_order_status(String cust_order_status) {
		this.cust_order_status = cust_order_status;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", buyer_id=" + buyer_id + ", order_num=" + order_num + ", order_status="
				+ order_status + ", amt=" + amt + ", ca=" + ca + ", ce=" + ce + ", cn=" + cn + ", cp=" + cp
				+ ", order_date=" + order_date + ", pt=" + pt + ", cust_order_status=" + cust_order_status + "]";
	}
	
}