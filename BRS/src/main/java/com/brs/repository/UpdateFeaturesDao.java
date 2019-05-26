package com.brs.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.brs.component.Rating_attributes_mapping;

@Repository
public class UpdateFeaturesDao {
	@Autowired
    private HibernateTemplate template;
 
    public HibernateTemplate getTemplate() {
        return template;
    }
 
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    
    public List<Integer> getFeatures(int ratingWt) {
    	Session session;
    	List<Rating_attributes_mapping> l;
    	List<Integer> r=new ArrayList<>();
    	session = getTemplate().getSessionFactory().openSession();
	    Transaction tx=null;
	    try {
	    	tx = session.beginTransaction();    
		    Criteria crit = session.createCriteria(Rating_attributes_mapping.class);
		   	crit.add(Restrictions.eq("rwt",ratingWt));
	        l=crit.list(); 
		    for(Rating_attributes_mapping ram:l)
		    	r.add(ram.getAttributeId());
		    tx.commit();
		    return r;
		    }
		    catch (Exception ex) {
		        if (tx!=null) tx.rollback();
		        throw ex;
		    }
		    finally {
		        session.close();
		    }
    }
}
