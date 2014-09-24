package com.antwerkz.mongo.dao;

import com.antwerkz.mongo.model.MongoEntity;
import com.antwerkz.mongo.model.Product;
import com.antwerkz.mongo.model.ProductOrder;
import com.antwerkz.mongo.model.User;
import com.mongodb.*;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

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
                .find(new BasicDBObject("fulfilled", true))
                .limit(2);
        while (cursor.hasNext()) {
            orders.add(new ProductOrder(cursor.next()));
        }

        return orders;
    }

    public List<ProductOrder> findFulfilledOrdersWithMorphia() {
        return ds.createQuery(ProductOrder.class)
                .field("fulfilled").equal(true)
                .limit(2)
                .asList();
    }

    public Iterable<ProductOrder> findFulfilledOrdersWithJongo() {
        return jongo.getCollection("product_orders")
                .find("{fulfilled : true}")
                .limit(2)
                .as(ProductOrder.class);
    }

    public List<ProductOrder> findUnfulfilledOrdersSmallerThan(int size) {
        List<ProductOrder> orders = new ArrayList<>();

        BasicDBList list = new BasicDBList();
        list.add(new BasicDBObject("fulfilled", false));
        list.add(new BasicDBObject("size", new BasicDBObject("$lte", size)));
        DBObject or = new BasicDBObject("$or", list);
        DBCursor cursor = db.getCollection("product_orders")
                .find(or);
        while (cursor.hasNext()) {
            orders.add(new ProductOrder(cursor.next()));
        }

        return orders;
    }

    public Iterable<ProductOrder> findUnfulfilledOrdersSmallerThanWithJongo(int size) {
        return jongo.getCollection("product_orders")
                .find("{ $or : [ { size : { $lte : # } }, { fulfilled : false } ] }", size)
                .as(ProductOrder.class);
    }

    public List<ProductOrder> findUnfulfilledOrdersSmallerThanWithMorphia(int size) {
        Query<ProductOrder> query = ds.createQuery(ProductOrder.class);
        query.or(
                query.criteria("fulfilled").equal(false),
                query.criteria("size").lessThanOrEq(3)
        );
        return query.asList();
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
