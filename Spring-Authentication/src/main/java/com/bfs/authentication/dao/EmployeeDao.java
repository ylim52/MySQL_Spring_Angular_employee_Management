package com.bfs.authentication.dao;


import com.bfs.authentication.domain.Employee;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EmployeeDao extends HibernateDao {

    public EmployeeDao() { setClazz(Employee.class); }

    public void addEmployee(){
        Employee employee = new Employee();
        getCurrentSession().merge(employee);
    }

    public void addEmployee(Employee employee){
        getCurrentSession().merge(employee);
    }

    public List<Employee> getAll(){
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery  = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        List<Employee> employees = getCurrentSession().createQuery(criteriaQuery).getResultList();
        return employees;
    }

    public Employee getById(Integer id){
        return getCurrentSession().get(Employee.class, id);
    }

    public Employee getLastKey(){
        Query query = getCurrentSession().createQuery("from Employee order by id DESC");
        query.setMaxResults(1);
        List<Employee> last = query.getResultList();
        return last.get(0);
    }

    public void updateEmployee(Employee employee){
        getCurrentSession().update(employee);
    }

}
