package ua.lviv.myshop.general;

import ua.lviv.myshop.dao.BucketDao;
import ua.lviv.myshop.dao.ProductDao;
import ua.lviv.myshop.dao.UserDao;
import ua.lviv.myshop.dao.impl.ProductDaoImpl;
import ua.lviv.myshop.dao.impl.UserBucket;
import ua.lviv.myshop.dao.impl.UserDaoImpl;

public class Factory {
    public static Factory instance = new Factory();
    public ProductDao productDao;
    public UserDao userDao;
    public BucketDao bucketDao;

    public static Factory getInstance() {
        return instance;
    }

    public ProductDao getProductDao() {
        if (productDao == null) {
            productDao = new ProductDaoImpl();
        }
        return productDao;
    }

    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    public BucketDao getBucketDao() {
        if (bucketDao == null) {
            bucketDao = new UserBucket();
        }
        return bucketDao;
    }
}
