package com.userinfo.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.userinfo.component.BuyerDetails;
import com.userinfo.component.Orders;


@Repository
public class BuyerDao {
 
    @Autowired
    private HibernateTemplate template;
 
    public HibernateTemplate getTemplate() {
        return template;
    }
 
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
 
    // Get all countries from the database  
    public List<String> getBuyerIds() {          
        List<Orders> o = getTemplate().loadAll(Orders.class);

        List<String> bId=new ArrayList<>();
        for(Orders c : o)
        {
        	bId.add(c.getBuyer_id());
        	System.out.println(c.toString());
        }
 
        return bId;
    }
    
    public List<BuyerDetails> getBuyerDetails(String bid)
    {
    	Session session;
    	List<Orders> l;
    	List<BuyerDetails> r=new ArrayList<>();
    	session=getTemplate().getSessionFactory().openSession();
    	Transaction tx=null;
	    try {
	    	tx = session.beginTransaction();
		    Criteria crit = session.createCriteria(Orders.class);
		   	crit.add(Restrictions.eq("buyer_id",bid));
		   	Calendar cal=Calendar.getInstance();
		   	cal.add(Calendar.DATE, -2);
		   	Date date=cal.getTime();
		   	crit.add(Restrictions.eq("order_date",date));
	        l=crit.list();
	        for(Orders o:l)
        	{
	        	BuyerDetails bd=new BuyerDetails();
	            bd.setBuyer_id(o.getBuyer_id());
	            bd.setOrder_id(o.getId());
	            bd.setCust_order_status(o.getCust_order_status());
	            bd.setOrder_num(o.getOrder_num());	 
	            r.add(bd);
	       	}
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