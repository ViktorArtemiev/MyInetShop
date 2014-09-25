package ua.lviv.myshop.dao.impl;

import org.hibernate.Session;
import ua.lviv.myshop.dao.UserDao;
import ua.lviv.myshop.domain.User;
import ua.lviv.myshop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Override
    public void addUser(User user) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
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
    public void deleteUser(User user) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
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
    public void updateUser(int id, User user) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            User tmp = (User) session.get(User.class, id);
            tmp.setFirstName(user.getFirstName());
            tmp.setLastName(user.getLastName());
            tmp.setEmail(user.getEmail());
            session.update(tmp);
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
    public User getUser(int id) throws SQLException {
        User result = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (User) session.get(User.class, id);
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
    public List<User> getAllUsers() throws SQLException {
        List<User> result = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.createCriteria(User.class).list();
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
