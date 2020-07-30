package com.bfs.main.dao.implementation;

import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.ApplicationWorkFlow;
import com.bfs.main.domain.Employee;
import com.bfs.main.domain.PersonalDocument;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository("personalDocumentDao")
public class PersonalDocumentDao extends HibernateDao {

    public PersonalDocumentDao(){ setClazz(PersonalDocument.class);}

    public List<PersonalDocument> getAll(){
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<PersonalDocument> criteria = builder.createQuery(PersonalDocument.class);
        criteria.from(PersonalDocument.class);
        List<PersonalDocument> documents = getCurrentSession().createQuery(criteria).getResultList();
        return documents;
    }

    public PersonalDocument uploadDocument(PersonalDocument personalDocument) {
        try{
            Session session = this.sessionFactory.openSession();
            session.getTransaction().begin();
            session.save(personalDocument);
            session.getTransaction().commit();
            return personalDocument;
        } catch (HibernateException e) {
            System.out.println("Failed to update Employee");
            e.printStackTrace();
            return null;
        }
    }

    public List<PersonalDocument> getDocuments(Employee employee) {
        List<PersonalDocument> personalDocuments;
        try{
            Session session = this.sessionFactory.openSession();
            String HQL = "FROM PersonalDocument WHERE employee=:employee";
            Query query = session.createQuery(HQL);
            query.setParameter("employee", employee);
            personalDocuments = query.list();
            System.out.println("Retrieved Personal Documents successfully");
            return personalDocuments;
        } catch (HibernateException e) {
            System.out.println("Failed to retrieve personal documents");
            e.printStackTrace();
            return null;
        }
    }
}
