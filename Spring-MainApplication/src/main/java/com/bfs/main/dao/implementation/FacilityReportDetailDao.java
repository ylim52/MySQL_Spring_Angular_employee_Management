package com.bfs.main.dao.implementation;

import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.Employee;
import com.bfs.main.domain.FacilityReport;
import com.bfs.main.domain.FacilityReportDetail;
import com.bfs.main.security.CookieUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository("facilityReportDetailDao")
public class FacilityReportDetailDao extends HibernateDao {
    CookieUtil cookieUtil;

    public FacilityReportDetailDao() { setClazz(FacilityReportDetail.class); }

    public List<FacilityReportDetail> getAll(){
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<FacilityReportDetail> criteria = builder.createQuery(FacilityReportDetail.class);
        criteria.from(FacilityReportDetail.class);
        List<FacilityReportDetail> reportDetails = getCurrentSession().createQuery(criteria).getResultList();
        return reportDetails;
    }

    public FacilityReportDetail updateComments(FacilityReportDetail facilityReportDetail) {
        try {
            Session session = this.sessionFactory.openSession();
            session.getTransaction().begin();
            String HQL = "UPDATE FacilityReportDetail SET comments=:c, createdDate=:cd where id=:id";
            Query query = session.createQuery(HQL);
            query.setParameter("c", facilityReportDetail.getComments());
            query.setParameter("cd", facilityReportDetail.getCreatedDate());
            query.setParameter("id", facilityReportDetail.getID());
            query.executeUpdate();
            session.getTransaction().commit();
            return facilityReportDetail;
        } catch (HibernateException e) {
            System.out.println("Failed to update Detail");
            e.printStackTrace();
            return null;
        }
    }
}