package com.bfs.main.dao.implementation;


import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.RegistrationToken;
import com.bfs.main.domain.Role;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("registrationTokenDao")
public class RegistrationTokenDao extends HibernateDao {

    public RegistrationTokenDao(){
        setClazz(RegistrationToken.class);
    }

    public void addToken(RegistrationToken token){
        getCurrentSession().merge(token);
    }

    public List<RegistrationToken> getAll(){
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<RegistrationToken> criteria = builder.createQuery(RegistrationToken.class);
        criteria.from(RegistrationToken.class);
        List<RegistrationToken> tokens = getCurrentSession().createQuery(criteria).getResultList();
        return tokens;
    }

    public void updateToken(RegistrationToken token){
        getCurrentSession().update(token);
    }
}
