package com.bfs.main.dao.implementation;

import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.Role;
import com.bfs.main.domain.UserRole;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("userRoleDao")
public class UserRoleDao extends HibernateDao {

    public UserRoleDao() { setClazz(UserRole.class);}

    public List<UserRole> getAll(){
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<UserRole> criteria = builder.createQuery(UserRole.class);
        criteria.from(UserRole.class);
        List<UserRole> userRoles = getCurrentSession().createQuery(criteria).getResultList();
        return userRoles;
    }

    public List<UserRole> getByUserID(Integer ID){
        CriteriaBuilder cbd = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<UserRole> cq = cbd.createQuery(UserRole.class);
        Root<UserRole> root = cq.from(UserRole.class);
        cq.select(root);
        cq.where(cbd.equal(root.get("UserID"), ID));
        Query<UserRole> query = getCurrentSession().createQuery(cq);
        List<UserRole> maps = query.getResultList();
        return maps;
    }
}
