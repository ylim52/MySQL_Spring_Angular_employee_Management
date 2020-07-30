package com.bfs.authentication.dao;


import com.bfs.authentication.domain.ApplicationWorkFlow;
import com.bfs.authentication.domain.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

//import javafx.application.Application;

@Repository("applicationWorkFlowDao")
public class ApplicationWorkFlowDao extends HibernateDao {

    public ApplicationWorkFlowDao(){ setClazz(ApplicationWorkFlow.class);}

    public void addApplication(ApplicationWorkFlow application){
        getCurrentSession().merge(application);
    }

    public void updateApplication(ApplicationWorkFlow application){
        getCurrentSession().update(application);
    }

    public List<ApplicationWorkFlow> getAll(){
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<ApplicationWorkFlow> criteria = builder.createQuery(ApplicationWorkFlow.class);
        criteria.from(ApplicationWorkFlow.class);
        List<ApplicationWorkFlow> applications = getCurrentSession().createQuery(criteria).getResultList();
        return applications;
    }

    public ApplicationWorkFlow getCurrentStatus(int id) {
        ApplicationWorkFlow applicationWorkFlow;
        try{
            Session session = this.sessionFactory.getCurrentSession();
            String HQL = "FROM ApplicationWorkFlow WHERE employee.id=:id";
            Query query = session.createQuery(HQL);
            query.setParameter("id", id);
            applicationWorkFlow = (ApplicationWorkFlow) query.uniqueResult();
            System.out.println("Retrieved Application successfully");
            return applicationWorkFlow;
        } catch (HibernateException e) {
            System.out.println("Failed to retrieve Application");
            e.printStackTrace();
            return null;
        }
    }

    public ApplicationWorkFlow getLastKey(){
        javax.persistence.Query query = getCurrentSession().createQuery("from ApplicationWorkFlow order by ID DESC");
        query.setMaxResults(1);
        List<ApplicationWorkFlow> last = query.getResultList();
        return last.get(0);
    }
}
