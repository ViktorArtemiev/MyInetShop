package ua.lviv.myshop.dao.impl;

import org.hibernate.Session;
import ua.lviv.myshop.dao.ProductDao;
import ua.lviv.myshop.domain.Product;
import ua.lviv.myshop.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    @Override
    public void addProduct(Product product) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(product);
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
    public void deleteProduct(Product product) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(product);
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
    public void updateProduct(Product product) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(product);
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
    public Product getProduct(int id) throws SQLException {
        Product result = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Product) session.get(Product.class, id);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> result = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.createCriteria(Product.class).list();
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
