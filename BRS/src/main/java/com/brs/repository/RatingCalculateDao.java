package com.brs.repository;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.brs.component.*;

@Repository
public class RatingCalculateDao {
	
	@Autowired
    private HibernateTemplate template;
 
    public HibernateTemplate getTemplate() {
        return template;
    }
 
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
	
	public List<ReferenceMaster> updateBuyerRatingInDatabase(RequestParameter rp)
    {
    	List<ReferenceMaster> l=new ArrayList<>();
    	List<Buyer> bid=rp.getBuyer();
    	for(Buyer b:bid)
    	{
    		List<Orders> ord=b.getOrders();
    		int count_del=0,count_return=0,count_cancel=0,rating=0;
    		for(Orders o:ord)
    		{
    			String status=o.getCust_order_status();
    			if(status.equals(""))
    				count_del++;
    			else if(status.equals("returned"))
    				count_return++;
    			else if(status.equals("cancelled"))
    				count_cancel++;
    		}
    		if(count_del>=4)
    			rating+=count_del/4;
    		else if(count_return>=2)
    			rating-=count_return/2;
    		else if(count_cancel>=4)
    			rating-=count_cancel/4;
    		ReferenceMaster rme=new ReferenceMaster();
    		rme.setReferenceId(b.getBuyer_id());
    		rme.setReferenceType("buyer");
    		Date d=Calendar.getInstance().getTime();
    		rme.setLastModifiedDate(d);
    		Session session;
    		try
        	{
        		ReferenceMaster rm = (ReferenceMaster) getTemplate().get(ReferenceMaster.class, b.getBuyer_id());
        		int rating2=rm.getRatingWeight();
        		session = getTemplate().getSessionFactory().openSession();
        		Transaction tx=null;
        		try
         	    {
        	    	tx=session.beginTransaction();
        	    	rme.setRatingWeight(rating+rating2);
       		    	rme.setCreatedDate(rm.getCreatedDate());
               		Query q=session.createQuery("update ReferenceMaster set rating_wt =:rating_wt,last_modi_date=:ld where ref_id=:ref_id");
               		q.setParameter("rating_wt",rating+rating2);
               		q.setParameter("ref_id",b.getBuyer_id());
               		q.setParameter("ld",d);
               		System.out.println(q.executeUpdate());
               		tx.commit();
               		l.add(rme);
               		}
               	catch (TransactionException exe) {
               		if (tx!=null) tx.rollback();
               		throw exe;
               		}
        	    finally {
        	    	session.close();
        	    	}
        		}
        	catch(NullPointerException e)
        	{
       			ReferenceMaster rm = (ReferenceMaster) getTemplate().get(ReferenceMaster.class, b.getBuyer_id());
        	    session = getTemplate().getSessionFactory().openSession();
        	    Transaction tx=null;
       		    try
       		    {
       		    	tx=session.beginTransaction();
       		    	session=getTemplate().getSessionFactory().getCurrentSession();
       		    	rme.setRatingWeight(5);
       		    	rme.setCreatedDate(rm.getCreatedDate());
            		session.persist(rme);
            	    tx.commit();
             	    l.add(rme);
             	    }
                	catch (TransactionException exe) {
        		        if (tx!=null) tx.rollback();
        		        throw exe;
        			    }
        			finally {
        		        session.close();
        		    }
        		}
        	}	
    	return l;
    }
}