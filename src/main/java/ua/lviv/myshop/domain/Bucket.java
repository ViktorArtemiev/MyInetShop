package ua.lviv.myshop.domain;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "bucket")
public class Bucket {
    @Id
    @Column(name = "bucket_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @JoinColumn(name = "product_id" , referencedColumnName = "id")
    private Product product;

    public Bucket() {
    }

    public Bucket(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProducts() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + product +
                '}';
    }
}
