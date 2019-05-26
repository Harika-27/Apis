package com.brs.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Rating_attributes_mapping")
@Component
public class Rating_attributes_mapping {
	@Column(name="rating_weight")
    private int rwt;
 
    @Id
    @Column(name="id")
    private int raid;
    
    @Column(name="attribute_id")
    private int aid;
    
    public Rating_attributes_mapping()
    {
    	
    }
    
    public Rating_attributes_mapping(int w,int ai,int rid)
    {
    	this.rwt=w;
    	this.aid=ai;
    	this.raid=rid;
    }
    
    public int getRatingWt()
    {
    	return rwt;
    }
    public void setRatingWt(int w)
    {
    	this.rwt=w;
    }
    
    public int getAttributeId()
    {
    	return aid;
    }
    public void setAttributeId(int w)
    {
    	this.aid=w;
    }
    
    public int getId()
    {
    	return raid;
    }
    public void setId(int w)
    {
    	this.raid=w;
    }
}
