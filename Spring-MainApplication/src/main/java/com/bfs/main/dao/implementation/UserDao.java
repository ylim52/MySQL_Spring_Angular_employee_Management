package com.bfs.main.dao.implementation;

import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.ApplicationWorkFlow;
import com.bfs.main.domain.Person;
import com.bfs.main.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("userDao")
public class UserDao extends HibernateDao {

    public UserDao() { setClazz(User.class); }

    public List<User> getAll(){
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        criteria.from(User.class);
        List<User> users = getCurrentSession().createQuery(criteria).getResultList();
        return users;
    }

    public List<User> findByUsername(String username){
        CriteriaBuilder cbd = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cbd.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        cq.where(cbd.equal(root.get("Username"),username));
        Query<User> query = getCurrentSession().createQuery(cq);
        List<User> users = query.getResultList();
        return users;
    }

    public List<User> findByEmail(String email){
        CriteriaBuilder cbd = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cbd.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        cq.where(cbd.equal(root.get("Email"),email));
        Query<User> query = getCurrentSession().createQuery(cq);
        List<User> users = query.getResultList();
        return users;
    }
}