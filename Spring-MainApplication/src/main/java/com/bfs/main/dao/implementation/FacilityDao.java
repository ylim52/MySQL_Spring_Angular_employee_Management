package com.bfs.main.dao.implementation;

import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.Facility;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository("facilityDao")
public class FacilityDao extends HibernateDao {

    public FacilityDao () {
        setClazz(Facility.class);
    }

    public List<Facility> getAll(){
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Facility> criteria = builder.createQuery(Facility.class);
        criteria.from(Facility.class);
        List<Facility> facilities = getCurrentSession().createQuery(criteria).getResultList();
        return facilities;
    }


}
