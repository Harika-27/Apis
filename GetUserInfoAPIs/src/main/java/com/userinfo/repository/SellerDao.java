package com.userinfo.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.userinfo.component.Order_Details;
import com.userinfo.component.Orders;
import com.userinfo.component.Products;
import com.userinfo.component.SellerDetails;

@Repository
public class SellerDao {
	@Autowired
    private HibernateTemplate template;
 
    public HibernateTemplate getTemplate() {
        return template;
    }
 
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    
    public List<SellerDetails> getSellerDetails(String sid)
    {
    	Session session;
    	List<Orders> l;
    	List<SellerDetails> r=new ArrayList<>();
    	session=getTemplate().getSessionFactory().openSession();
    	Transaction tx=null;
	    try {
	    	tx = session.beginTransaction();
		    Criteria crit = session.createCriteria(Orders.class);
		    Calendar cal=Calendar.getInstance();
		    cal.add(Calendar.DATE, -2);
		   	Date date=cal.getTime();
		   	crit.add(Restrictions.eq("order_date",date));
            l=crit.list();
	        for(Orders o:l)
	        {
	        	List<Order_Details> l1;
		       	Criteria c2=session.createCriteria(Order_Details.class);
		       	c2.add(Restrictions.eq("order_id",o.getId()));
		       	l1=c2.list();
		       	for(Order_Details od:l1)
		       	{
		       		List<Products> l2;
		       		Criteria c3=session.createCriteria(Products.class);
		       		c3.add(Restrictions.eq("code",od.getProduct_id()));
		       		c3.add(Restrictions.eq("seller_id",sid));
	        		l2=c3.list();
	        		for(Products p:l2)
	        		{
		        		SellerDetails sd=new SellerDetails();
		       			sd.setOrder_id(o.getId());
		       			sd.setSeller_id(p.getSeller_id());
		       			sd.setOrder_num(o.getOrder_num());
		       			sd.setCust_order_status(o.getCust_order_status());
		       			r.add(sd);
		       		}
	        	}	    	
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