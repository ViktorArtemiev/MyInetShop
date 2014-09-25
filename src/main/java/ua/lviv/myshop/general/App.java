package ua.lviv.myshop.general;

//import ua.lviv.myshop.dao.BucketDao;
import ua.lviv.myshop.dao.ProductDao;
import ua.lviv.myshop.dao.UserDao;
import ua.lviv.myshop.domain.Product;
import ua.lviv.myshop.domain.User;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        Factory factory = Factory.getInstance();
        UserDao userDao = factory.getUserDao();
        ProductDao productDao = factory.getProductDao();
//        BucketDao bucketDao = factory.getBucketDao();

        userDao.addUser(new User("Victor", "Artemjev", "vitman@ukr.net"));
        userDao.addUser(new User("Monica", "Gellar", "monica@gmail.com"));
        userDao.addUser(new User("Ross", "Tribiani", "tribiani@outlook.com"));

        productDao.addProduct(new Product("description 1", "product 1", 799.00));
        productDao.addProduct(new Product("description 2", "product 2", 899.00));
        productDao.addProduct(new Product("description 3", "product 3", 999.00));
        productDao.addProduct(new Product("description 4", "product 4", 1099.00));
        productDao.addProduct(new Product("description 5", "product 5", 2099.00));
        productDao.addProduct(new Product("description 6", "product 6", 50099.00));

        for (User user : userDao.getAllUsers()) {
            System.out.println(user);
        }

        System.out.println("*******************************");

        System.out.println(productDao.getProduct(1));

        for (Product product : productDao.getAllProducts()) {
            System.out.println(product);
        }

        productDao.deleteProduct(productDao.getProduct(1));
        System.out.println("*******************************");
        for (Product product : productDao.getAllProducts()) {
            System.out.println(product);
        }

        System.out.println("==================SELECT=================");
        User tmp = userDao.getUser(2);
        System.out.println(tmp);

        System.out.println("==================UPDATE=================");
        userDao.updateUser( 2, new User("Joe", "iiii", "fnjkwn"));
        for (User user : userDao.getAllUsers()) {
            System.out.println(user);
        }
    }
}
