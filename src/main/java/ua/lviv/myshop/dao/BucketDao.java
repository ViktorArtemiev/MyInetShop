package ua.lviv.myshop.dao;

import ua.lviv.myshop.dao.impl.UserBucket;
import ua.lviv.myshop.domain.Bucket;

import java.sql.SQLException;
import java.util.List;

public interface BucketDao {
    public void addUserProducts(Bucket bucketucket) throws SQLException;
    public List<Bucket> getUserBuckets();
}
