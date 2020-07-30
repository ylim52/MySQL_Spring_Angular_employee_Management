package com.bfs.authentication.dao;

import com.bfs.authentication.domain.Contact;
import com.bfs.authentication.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RoleDao")
public class RoleDao extends HibernateDao{

    public RoleDao() { setClazz(Role.class); }

    public Role getLastKey(){
        javax.persistence.Query query = getCurrentSession().createQuery("from Role order by ID DESC");
        query.setMaxResults(1);
        List<Role> last = query.getResultList();
        return last.get(0);
    }
}
