package com.antwerkz.jfokus.jpa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import org.bson.types.ObjectId;

@Entity("orders")
public class ProductOrder {
    @Id
    private ObjectId id;
    private Date orderDate;
    private ObjectId userId;
    private List<Product> products;
    private Address shippingAddress;
    private Boolean fulfilled;

    public ObjectId getId() {
        return id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(final Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(final ObjectId userId) {
        this.userId = userId;
    }

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
        sb.append(", user=").append(userId);
        sb.append(", products=").append(products);
        sb.append(", shippingAddress=").append(shippingAddress);
        sb.append('}');
        return sb.toString();
    }
}
