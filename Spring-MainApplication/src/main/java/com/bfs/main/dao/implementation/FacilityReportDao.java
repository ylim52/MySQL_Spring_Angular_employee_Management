package com.bfs.main.dao.implementation;

import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.Employee;
import com.bfs.main.domain.FacilityReport;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository("facilityReportDao")
public class FacilityReportDao extends HibernateDao {

    public FacilityReportDao() { setClazz(FacilityReport.class); }

    public List<FacilityReport> getAll(){
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<FacilityReport> criteria = builder.createQuery(FacilityReport.class);
        criteria.from(FacilityReport.class);
        List<FacilityReport> facilityReports = getCurrentSession().createQuery(criteria).getResultList();
        return facilityReports;
    }

    public void addFacilityReport() {
        try {
            Session session = this.sessionFactory.openSession();
            session.getTransaction().begin();
            String HQL = "INSERT INTO FacilityReport (title, description, reportDate, status)" +
                    "SELECT title, description, reportDate, status FROM FacilityReport";
            Query query = session.createQuery(HQL);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("Failed to update Employee");
            e.printStackTrace();
        }
    }

}