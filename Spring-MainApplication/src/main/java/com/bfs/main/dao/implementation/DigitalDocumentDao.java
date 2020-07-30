package com.bfs.main.dao.implementation;

import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.DigitalDocument;
import com.bfs.main.domain.VisaStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository("digitalDocumentDao")
public class DigitalDocumentDao extends HibernateDao {

    public DigitalDocumentDao() { setClazz(DigitalDocument.class); }

    public List<DigitalDocument> getAll(){
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<DigitalDocument> criteria = builder.createQuery(DigitalDocument.class);
        criteria.from(DigitalDocument.class);
        List<DigitalDocument> digitalDocuments = getCurrentSession().createQuery(criteria).getResultList();
        return digitalDocuments;
    }
}