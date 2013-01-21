package com.antwerkz.jfokus.mongo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.antwerkz.jfokus.mongo.dao.JfokusDao;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

@Entity(JfokusDao.PRODUCT_ORDERS)
public class ProductOrder extends JfokusEntity {
    private Date orderDate;
    private ObjectId userId;
    @Embedded
    private List<Product> products = new ArrayList<>();
    private Boolean fulfilled;
    private Double total = 0.0;
    private Integer size = 0;

    public ProductOrder() {
    }

    public ProductOrder(final DBObject next) {
        fromDBObject(next);
    }

    public void fromDBObject(final DBObject dbObject) {
        super.fromDBObject(dbObject);
        orderDate = get(dbObject, "orderDate");
        userId = get(dbObject, "userId");
        total = get(dbObject, "total");
        size = get(dbObject, "size");
        BasicDBList list = get(dbObject, "products");
        for (Object o : list) {
            products.add(new Product((DBObject) o));
        }
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

    public void add(final Product product) {
        products.add(product);
        total += product.getPrice();
        size++;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(final Double total) {
        this.total = total;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(final ObjectId userId) {
        this.userId = userId;
    }

    public Boolean getFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(final Boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof ProductOrder) {
            ObjectId id = ((ProductOrder) obj).getId();
            return id != null && id.equals(getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getId() == null ? super.hashCode() : getId().hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ProductOrder {");
        sb.append(" id=").append(getId());
        sb.append(", fulfilled=").append(fulfilled);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", user=").append(userId);
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}
