package ua.lviv.myshop.dao.impl;

import org.hibernate.Session;
import ua.lviv.myshop.dao.BucketDao;
import ua.lviv.myshop.domain.Bucket;
import ua.lviv.myshop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class UserBucket implements BucketDao {
    @Override
    public void addUserProducts(Bucket bucket) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(bucket);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Bucket> getUserBuckets() {
        List<Bucket> result = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.createCriteria(Bucket.class).list();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }
}
