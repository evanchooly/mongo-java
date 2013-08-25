package com.antwerkz.jpa.jpa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class ProductOrder {
    private Long id;
    private Date orderDate;
    private User user;
    private List<Product> products;
    private Address shippingAddress;
    private Boolean fulfilled;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(final Date orderDate) {
        this.orderDate = orderDate;
    }

    @ManyToMany
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    @ManyToOne
    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(final Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Boolean getFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(final Boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public void add(final Product product) {
        if(products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ProductOrder {");
        sb.append(" id=").append(id);
        sb.append(", fulfilled=").append(fulfilled);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", user=").append(user);
        sb.append(", products=").append(products);
        sb.append(", shippingAddress=").append(shippingAddress);
        sb.append('}');
        return sb.toString();
    }
}
