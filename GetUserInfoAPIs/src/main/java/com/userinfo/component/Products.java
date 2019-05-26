package com.userinfo.component;

import java.sql.Blob;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Products")
@Component
public class Products {
	@Id
	@Column(name="Code")
	private String code;
	
	@Column(name="Create_date")
    private Date create_date;
	
	@Column(name="Image")
    private Blob image;
	
	@Column(name="Name")
    private String name;
	
	@Column(name="Price")
    private double price;
	
	@Column(name="seller_id")
    private String seller_id;

	public Products()
	{
		
	}
	public Products(String code, Date create_date, Blob image, String name, double price, String seller_id) {
		super();
		this.code = code;
		this.create_date = create_date;
		this.image = image;
		this.name = name;
		this.price = price;
		this.seller_id = seller_id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	@Override
	public String toString() {
		return "Products [code=" + code + ", create_date=" + create_date + ", image=" + image + ", name=" + name
				+ ", price=" + price + ", seller_id=" + seller_id + "]";
	}

	
	
}
