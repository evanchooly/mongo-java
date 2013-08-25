package com.antwerkz.mongo.model;

import java.util.HashMap;
import java.util.Map;

import com.google.code.morphia.annotations.Entity;
import com.mongodb.DBObject;

@Entity("products")
public class Product extends MongoEntity {
    private String name;
    private Double price;  // i know.  doubles are bad for money...

    public Product() {
    }

    public Product(final String name, final Double price) {
        this.name = name;
        this.price = price;
    }

    public Product(final DBObject dbObject) {
        super(dbObject);
        name = get(dbObject, "name");
        price = get(dbObject, "price");
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Product");
        sb.append("{id=").append(getId());
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("_id", getId());
        map.put("name", name);
        map.put("price", price);

        return map;
    }
}
