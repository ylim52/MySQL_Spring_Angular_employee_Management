package com.bfs.main.dao.implementation;

import com.bfs.main.dao.HibernateDao;
import com.bfs.main.domain.House;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseDao extends HibernateDao {
    public HouseDao () {
        setClazz(House.class);
    }

    public List<House> getHouse() {
        List<House> houseList;
        try {
            Session session = this.sessionFactory.openSession();
            String HQL = "FROM House";
            Query query = session.createQuery(HQL);
            houseList = query.list();
            System.out.println("Retrieved House List successfully");
            return houseList;
        } catch (HibernateException e) {
            System.out.println("Failed to retrieve House");
            e.printStackTrace();
            return null;
        }
    }

    public House getHouseById(int id) {
        House house;
        try{
            Session session = this.sessionFactory.openSession();
            String HQL = "FROM House WHERE id=:id";
            Query query = session.createQuery(HQL);
            query.setParameter("id", id);
            house = (House) query.uniqueResult();
            System.out.println("Retrieved House successfully");
            return house;
        } catch (HibernateException e) {
            System.out.println("Failed to retrieve House");
            e.printStackTrace();
            return null;
        }
    }

}
