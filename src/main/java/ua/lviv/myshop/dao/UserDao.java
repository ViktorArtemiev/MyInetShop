package ua.lviv.myshop.dao;

import ua.lviv.myshop.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public void addUser(User user) throws SQLException;
    public void deleteUser(User user) throws SQLException;
    public void updateUser(int id, User user) throws SQLException;
    public User getUser(int id) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
}
