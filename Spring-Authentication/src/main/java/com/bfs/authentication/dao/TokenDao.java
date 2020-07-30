package com.bfs.authentication.dao;

import com.bfs.authentication.domain.Token;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("tokenDao")
public class TokenDao extends HibernateDao{

    public TokenDao () {
        setClazz(Token.class);
    }

    public List<Token> findByToken(String token){
        CriteriaBuilder cbd = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Token> cq = cbd.createQuery(Token.class);
        Root<Token> root = cq.from(Token.class);
        cq.select(root);
        cq.where(cbd.equal(root.get("Token"), token));
        Query<Token> query = getCurrentSession().createQuery(cq);
        List<Token> tokens = query.getResultList();
        return tokens;
    }
}
