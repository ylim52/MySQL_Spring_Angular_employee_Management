package com.bfs.main.dao.implementation;

import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.Address;
import com.bfs.main.domain.Contact;
import com.bfs.main.domain.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository("contactDao")
public class ContactDao extends HibernateDao {

    public ContactDao() { setClazz(Contact.class); }

    public List<Contact> getContact(){
        List<Contact> contactList;
        try{
            Session session = this.sessionFactory.openSession();
            String HQL = "FROM Contact";
            Query query = session.createQuery(HQL);
            contactList = query.list();
            System.out.println("Retrieved Contact List successfully");
            return contactList;
        } catch (HibernateException e) {
            System.out.println("Failed to retrieve Quiz");
            e.printStackTrace();
            return null;
        }
    }

    public Contact getContactById(int id) {
        Contact contact;
        try{
            Session session = this.sessionFactory.getCurrentSession();
            String HQL = "FROM Contact WHERE id=:id";
            Query query = session.createQuery(HQL);
            query.setParameter("id", id);
            contact = (Contact) query.uniqueResult();
            System.out.println("Retrieved Employee successfully");
            return contact;
        } catch (HibernateException e) {
            System.out.println("Failed to retrieve Employee");
            e.printStackTrace();
            return null;
        }
    }
}
