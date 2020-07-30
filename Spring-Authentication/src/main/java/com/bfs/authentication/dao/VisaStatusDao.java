package com.bfs.authentication.dao;

import com.bfs.authentication.domain.VisaStatus;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("visaStatusDao")
public class VisaStatusDao extends HibernateDao {

    public VisaStatusDao() { setClazz(VisaStatus.class); }

    public List<VisaStatus> getVisaStatus(){
        List<VisaStatus> visaStatusList;
        try{
            Session session = this.sessionFactory.openSession();
            String HQL = "FROM VisaStatus";
            Query query = session.createQuery(HQL);
            visaStatusList = query.list();
            System.out.println("Retrieved VisaStatus List successfully");
            return visaStatusList;
        } catch (HibernateException e) {
            System.out.println("Failed to retrieve VisaStatus");
            e.printStackTrace();
            return null;
        }
    }

    public VisaStatus getVisaStatusById(int id) {
        VisaStatus visaStatus;
        try{
            Session session = this.sessionFactory.openSession();
            String HQL = "FROM VisaStatus WHERE id=:id";
            Query query = session.createQuery(HQL);
            query.setParameter("id", id);
            visaStatus = (VisaStatus) query.uniqueResult();
            System.out.println("Retrieved VisaStatus successfully");
            return visaStatus;
        } catch (HibernateException e) {
            System.out.println("Failed to retrieve VisaStatus");
            e.printStackTrace();
            return null;
        }
    }


    public Integer updateVisa(VisaStatus visa) {
        try{
            Session session = this.sessionFactory.openSession();
            session.persist(visa);
            return 1;
        } catch (HibernateException e) {
            System.out.println("Failed to update VisaStatus");
            e.printStackTrace();
            return -1;
        }
    }
}
