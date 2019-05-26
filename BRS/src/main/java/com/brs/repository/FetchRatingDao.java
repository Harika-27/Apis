package com.brs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.brs.component.ReferenceMaster;

@Repository
public class FetchRatingDao {

	@Autowired
    private HibernateTemplate template;
 
    public HibernateTemplate getTemplate() {
        return template;
    }
 
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    
    public int getRating(String id) {     
        ReferenceMaster rm = (ReferenceMaster) getTemplate().get(ReferenceMaster.class, id);
        System.out.println(rm.toString());
        return rm.getRatingWeight();
    }
}
