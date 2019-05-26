package com.brs.component;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
import org.springframework.stereotype.Component;
 
@Entity
@Table(name="Reference_master")
@Component
public class ReferenceMaster {
 
    @Id
    @Column(name="reference_id")
    private String ref_id;
 
    @Column(name="rating_weight")
    private int rating_wt;
    
    @Column(name="reference_type")
    private String ref_type;
    
    @Column(name="created_date")
    private Date cr_date;
 
    @Column(name="last_modified_date")
    private Date last_modi_date;
    
    public ReferenceMaster() { }
 
    public ReferenceMaster(String r,int rw,String type,Date cd,Date lmd) {   
        this.ref_id=r;
        this.rating_wt=rw;
        this.ref_type=type;
        this.cr_date=cd;
        this.last_modi_date=lmd;
    }
 
    public String getReferenceId() {
        return ref_id;
    }
    public void setReferenceId(String bid) {
        this.ref_id = bid;
    }
    
    public int getRatingWeight() {
        return rating_wt;
    }
    public void setRatingWeight(int bid) {
        this.rating_wt = bid;
    }
    public String getReferenceType() {
        return ref_type;
    }
    public void setReferenceType(String bid) {
        this.ref_type = bid;
    }
    public Date getCreatedDate()
    {
    	return cr_date;
    }
    public void setCreatedDate(Date d)
    {
    	this.cr_date=d;
    }
    public Date getLastModifiedDate()
    {
    	return last_modi_date;
    }
    public void setLastModifiedDate(Date d)
    {
    	this.last_modi_date=d;
    }
    @Override
    public String toString() {
        return "Reference_master [referenceId=" + ref_id + ", ratingWeight=" + rating_wt + ", referenceType=" + ref_type +  ", lastModifiedDate=" + last_modi_date +", createdDate=" + cr_date + "]";
    }
}