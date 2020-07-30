package com.bfs.main.dao.implementation;


import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class EmployeeDao extends HibernateDao {

    public EmployeeDao() { setClazz(Employee.class); }

    public void updateOnboard(Employee employee){
        getCurrentSession().update(employee);
    }

    public Employee getEmployeeById(int id) {
        Employee employee;
        try{
            Session session = this.sessionFactory.getCurrentSession();
            String HQL = "FROM Employee WHERE id=:id";
            Query query = session.createQuery(HQL);
            query.setParameter("id", id);
            employee = (Employee) query.uniqueResult();
            System.out.println("Retrieved Employee successfully");
            return employee;
        } catch (HibernateException e) {
            System.out.println("Failed to retrieve Employee");
            e.printStackTrace();
            return null;
        }
    }


    public List<Employee> getEmployee(){
        List<Employee> employeeList;
        try{
            Session session = this.sessionFactory.openSession();
            String HQL = "FROM Employee";
            Query query = session.createQuery(HQL);
            employeeList = query.list();
            System.out.println("Retrieved Employee List successfully");
            return employeeList;
        } catch (HibernateException e) {
            System.out.println("Failed to retrieve Employee");
            e.printStackTrace();
            return null;
        }
    }


    public Employee updateName(Employee employee) {
        try{
            Session session = this.sessionFactory.openSession();
            session.getTransaction().begin();
            String HQL = "UPDATE Employee SET firstName=:f, middleName=:m, lastName=:l WHERE id=:id";
            Query query = session.createQuery(HQL);
            query.setParameter("f", employee.getFirstName());
            query.setParameter("m", employee.getMiddleName());
            query.setParameter("l", employee.getLastName());
            query.setParameter("id", employee.getId());
            query.executeUpdate();
            session.getTransaction().commit();
            return employee;
        } catch (HibernateException e) {
            System.out.println("Failed to update Employee");
            e.printStackTrace();
            return null;
        }
    }

    public Employee updateEmployment(Employee employee) {
        try{
            Session session = this.sessionFactory.openSession();
            session.getTransaction().begin();
            String HQL = "UPDATE Employee SET title=:t, managerId=:m, startDate=:s, endDate=:e";
            Query query = session.createQuery(HQL);
            query.setParameter("t", employee.getTitle());
            query.setParameter("m", employee.getManagerId());
            query.setParameter("s", employee.getStartDate());
            query.setParameter("e", employee.getEndDate());
            query.executeUpdate();
            session.getTransaction().commit();
            return employee;
        } catch (HibernateException e) {
            System.out.println("Failed to update Employee");
            e.printStackTrace();
            return null;
        }
    }

    public Employee updateDocument(Employee employee) {
        try{
            Session session = this.sessionFactory.openSession();
            session.getTransaction().begin();
            String HQL = "UPDATE Employee SET ssn=:ssn, license=:license, licenseED=:exp";
            Query query = session.createQuery(HQL);
            query.setParameter("ssn", employee.getSsn());
            query.setParameter("license", employee.getLicense());
            query.setParameter("exp", employee.getLicenseED());
            query.executeUpdate();
            session.getTransaction().commit();
            return employee;
        } catch (HibernateException e) {
            System.out.println("Failed to update Employee");
            e.printStackTrace();
            return null;
        }
    }


}
