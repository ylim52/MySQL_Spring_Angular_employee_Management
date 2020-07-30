package com.bfs.main.dao.implementation;

import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.ApplicationWorkFlow;
//import javafx.application.Application;
import com.bfs.main.domain.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("applicationWorkFlowDao")
public class ApplicationWorkFlowDao extends HibernateDao {

    public ApplicationWorkFlowDao(){ setClazz(ApplicationWorkFlow.class);}

    public void addApplication(ApplicationWorkFlow application){
        getCurrentSession().merge(application);
    }

    public ApplicationWorkFlow updateApplication(ApplicationWorkFlow application){
        getCurrentSession().update(application);
        return application;
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

    public List<ApplicationWorkFlow> findByType(String type){
        CriteriaBuilder cbd = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<ApplicationWorkFlow> cq = cbd.createQuery(ApplicationWorkFlow.class);
        Root<ApplicationWorkFlow> root = cq.from(ApplicationWorkFlow.class);
        cq.select(root);
        cq.where(cbd.equal(root.get("type"),type));
        Query<ApplicationWorkFlow> query = getCurrentSession().createQuery(cq);
        List<ApplicationWorkFlow> applications = query.getResultList();
        return applications;
    }
}
