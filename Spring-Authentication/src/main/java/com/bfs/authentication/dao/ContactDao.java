package com.bfs.authentication.dao;


import com.bfs.authentication.domain.Contact;
import com.bfs.authentication.domain.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

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

    public void addContact(Contact contact){
        getCurrentSession().merge(contact);
    }

    public void addNewContact(){
        Contact contact = new Contact();
        getCurrentSession().merge(contact);
    }

    public Contact getLastKey(){
        javax.persistence.Query query = getCurrentSession().createQuery("from Contact order by ID DESC");
        query.setMaxResults(1);
        List<Contact> last = query.getResultList();
        return last.get(0);
    }

}