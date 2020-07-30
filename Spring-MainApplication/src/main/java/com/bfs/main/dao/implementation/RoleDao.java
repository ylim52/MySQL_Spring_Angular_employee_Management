package com.bfs.main.dao.implementation;

import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.Role;
import com.bfs.main.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository("roleDao")
public class RoleDao extends HibernateDao {

    public RoleDao() { setClazz(Role.class); }

    public List<Role> getAll(){
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Role> criteria = builder.createQuery(Role.class);
        criteria.from(Role.class);
        List<Role> roles = getCurrentSession().createQuery(criteria).getResultList();
        return roles;
    }
}