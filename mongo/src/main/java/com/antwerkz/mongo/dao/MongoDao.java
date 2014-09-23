package com.antwerkz.mongo.dao;

import com.antwerkz.mongo.model.MongoEntity;
import com.antwerkz.mongo.model.Product;
import com.antwerkz.mongo.model.ProductOrder;
import com.antwerkz.mongo.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.mongodb.morphia.Datastore;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class MongoDao {
    public static final String PRODUCT_ORDERS = "product_orders";

    @Inject
    private DB db;

    @Inject
    private Datastore ds;

    @Inject
    private Jongo jongo;

    public void save(MongoEntity entity) {
        ds.save(entity);
    }

    public void clearAll() {
        System.out.println("Clearing all data");
        db.dropDatabase();
    }

    public User findUserWithDriver(final ObjectId userId) {
        BasicDBObject query = new BasicDBObject("_id", userId);

        try (DBCursor cursor = db.getCollection("users").find(query)) {
            if (cursor.hasNext()) {
                return new User(cursor.next());
            }
        }
        return null;
    }

    public List<ProductOrder> findFulfilledOrders() {
        List<ProductOrder> orders = new ArrayList<>();

        DBCursor cursor = db.getCollection("product_orders")
                .find(new BasicDBObject("filled", true))
                .limit(2);
        while (cursor.hasNext()) {
            orders.add(new ProductOrder(cursor.next()));
        }

        return orders;
    }

    public Iterable<ProductOrder> findFulfilledOrdersWithJongo() {
        return jongo.getCollection("product_orders")
                .find("{fulfilled : true}")
                .limit(2)
                .as(ProductOrder.class);
    }

    public List<ProductOrder> findFulfilledOrdersWithMorphia() {
        return ds.createQuery(ProductOrder.class)
                .field("fulfilled").equal(true)
                .limit(2)
                .asList();
    }

    public List<ProductOrder> findFulfilledOrdersOverSize(int size) {
        List<ProductOrder> orders = new ArrayList<>();

        DBCursor cursor = db.getCollection("product_orders")
                .find(new BasicDBObject("filled", true)
                        .append("size", new BasicDBObject("$gte", size)));
        while (cursor.hasNext()) {
            orders.add(new ProductOrder(cursor.next()));
        }

        return orders;
    }

    public Iterable<ProductOrder> findFulfilledOrdersOverSizeWithJongo(int size) {
        return jongo.getCollection("product_orders")
                .find("{fulfilled : true, size : { $gte : # }}", size)
                .as(ProductOrder.class);
    }

    public List<ProductOrder> findFulfilledOrdersOverSizeWithMorphia(int size) {
        return ds.createQuery(ProductOrder.class)
                .field("fulfilled").equal(true)
                .field("size").greaterThanOrEq(size)
                .limit(2)
                .asList();
    }

    public User findUserWithJongo(final ObjectId userId) {
        return jongo.getCollection("users").findOne("{ _id : # }", userId).as(User.class);
    }

    public User findUserWithMorphia(final ObjectId userId) {
        return ds.createQuery(User.class).field("id").equal(userId).get();
    }

    public Product findProduct(final String name) {
        return ds.createQuery(Product.class).field("name").equal(name).get();
    }

    public List<ProductOrder> findOrdersOverWithDriver(final double total) {
        List<ProductOrder> orders = new ArrayList<>();

        BasicDBObject query = new BasicDBObject("fulfilled", true)
                .append("total", new BasicDBObject("$gte", total));
        DBCursor cursor = db.getCollection(PRODUCT_ORDERS).find(query)
                .sort(new BasicDBObject("total", 1));
        while (cursor.hasNext()) {
            orders.add(new ProductOrder(cursor.next()));
        }
        return orders;
    }

    public Iterable<ProductOrder> findOrdersOverWithJongo(final double total) {
        return jongo.getCollection(PRODUCT_ORDERS).find(
                "{ fulfilled : true, total : { $gte : # } }", total)
                .sort("{total : 1}").as(
                ProductOrder.class);
    }

    public List<ProductOrder> findOrdersOverWithMorphia(final double total) {
        return ds.createQuery(ProductOrder.class)
                .field("fulfilled").equal(true)
                .filter("total >=", total)
//                .field("total").greaterThanOrEq(total)   <-- can be done either way
                .order("total")
                .asList();
    }

    public List<ProductOrder> findSmallOrders(final int count) {
        return ds.createQuery(ProductOrder.class)
                .filter("size <=", count)
                .asList();
    }

    public List<User> findByHairColor(final String color) {
        return ds.createQuery(User.class).field("hairColor").equal(color).asList();
    }

    public User findUserByEmail(final String email) {
        return ds.createQuery(User.class).field("email").equal(email).get();
    }
}
