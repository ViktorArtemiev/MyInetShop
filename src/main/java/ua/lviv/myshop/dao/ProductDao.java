package ua.lviv.myshop.dao;

import ua.lviv.myshop.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    public void addProduct(Product product) throws SQLException;
    public void deleteProduct(Product product) throws SQLException;
    public void updateProduct(Product product) throws SQLException;
    public Product getProduct(int id) throws SQLException;
    public List<Product> getAllProducts() throws SQLException;

}
