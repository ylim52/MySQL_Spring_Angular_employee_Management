package com.bfs.main.dao.implementation;

import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.Address;
import com.bfs.main.domain.ApplicationWorkFlow;
import com.bfs.main.domain.Employee;
import com.bfs.main.domain.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository("addressDao")
public class AddressDao extends HibernateDao {

    public AddressDao() { setClazz(Address.class); }

    public List<Address> getAll(){
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Address> criteria = builder.createQuery(Address.class);
        criteria.from(Address.class);
        List<Address> addresses = getCurrentSession().createQuery(criteria).getResultList();
        return addresses;
    }

    public Employee updateAddress(Employee employee) {
        try{
            Session session = this.sessionFactory.openSession();
            session.getTransaction().begin();
            String HQL = "UPDATE Address SET " +
                    "AddressLine1=:a1, " +
                    "AddressLine2=:a2, " +
                    "City=:city, " +
                    "StateName=:sN, " +
                    "StateAbbr=:sA, " +
                    "Zipcode=:zip " +
                    "WHERE id=:id";
            Query query = session.createQuery(HQL);
            query.setParameter("a1", employee.getAddress().getAddressLine1());
            query.setParameter("a2", employee.getAddress().getAddressLine2());
            query.setParameter("city", employee.getAddress().getCity());
            query.setParameter("sN", employee.getAddress().getStateName());
            query.setParameter("sA", employee.getAddress().getStateAbbr());
            query.setParameter("zip", employee.getAddress().getZipcode());
            query.setParameter("id", employee.getId());
            query.executeUpdate();
            session.getTransaction().commit();
            return employee;
        } catch (HibernateException e) {
            System.out.println("Failed to retrieve Employee");
            e.printStackTrace();
            return null;
        }
    }

}
