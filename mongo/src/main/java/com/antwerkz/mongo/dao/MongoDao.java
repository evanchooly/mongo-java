package com.antwerkz.mongo.dao;

import com.antwerkz.mongo.model.MongoEntity;
import com.antwerkz.mongo.model.Product;
import com.antwerkz.mongo.model.ProductOrder;
import com.antwerkz.mongo.model.User;
import com.antwerkz.mongo.model.criteria.ProductOrderCriteria;
import com.antwerkz.mongo.model.criteria.UserCriteria;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.annotations.Entity;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.jongo.Jongo;

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
    if (entity instanceof Product) {
      DBObject dbObject = createDBObject((Product) entity);
      DBCollection collection = db.getCollection(extractCollection(entity.getClass()));
      collection.update(new BasicDBObject("_id", entity.getId()), dbObject, true, false);
    } else {
      ds.save(entity);
    }
  }

  private DBObject createDBObject(final Product product) {
    BasicDBObject basicDBObject = new BasicDBObject(product.toMap());
    if (basicDBObject.get("_id") == null) {
      basicDBObject.put("_id", new ObjectId());
    }
    return basicDBObject;
  }

  private String extractCollection(final Class<?> aClass) {
    Entity annotation = aClass.getAnnotation(Entity.class);
    return annotation.value();
  }

  public void clearAll() {
    System.out.println("Clearing all data");
    db.dropDatabase();
  }

  public Product findProduct(final String name) {
    return ds.createQuery(Product.class).field("name").equal(name).get();
  }

  public List<ProductOrder> findOrdersOver(final double total) {
    BasicDBObject query = new BasicDBObject("total", 
                new BasicDBObject("$gte", total));
    List<ProductOrder> orders = new ArrayList<>();
    try (DBCursor cursor = db.getCollection(PRODUCT_ORDERS).find(query)) {
      while (cursor.hasNext()) {
        orders.add(new ProductOrder(cursor.next()));
      }
    }
    return orders;
  }

  public List<ProductOrder> findOrdersOverWithMorphia(final double total) {
    return ds.createQuery(ProductOrder.class)
        .filter("total >=", total)
        .order("total")
        .asList();
  }

  public Iterable<ProductOrder> findOrdersOverWithJongo(final double total) {
    return jongo.getCollection(PRODUCT_ORDERS).find(
               "{ total : { $gte : # } }"
                               , total).sort("{total : 1}").as(
        ProductOrder.class);
  }

  public List<ProductOrder> findOrdersOverWithCritter(final double total) {
    ProductOrderCriteria criteria = new ProductOrderCriteria(ds);
    criteria.total().greaterThanOrEq(total);
    return criteria.query().asList();
  }

  public List<ProductOrder> findSmallOrders(final int count) {
    return ds.createQuery(ProductOrder.class)
        .filter("size <=", count)
        .asList();
  }

  public List<User> findByHairColor(final String color) {
    return ds.createQuery(User.class).field("hairColor").equal(color).asList();
  }

  public List<User> findByHairColorWithCritter(final String color) {
    UserCriteria criteria = new UserCriteria(ds);
//        criteria.hairColor().equal(color);
    return criteria.query().asList();
  }

  public User findUserByEmail(final String email) {
    return ds.createQuery(User.class).field("email").equal(email).get();
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

  public User findUserWithMorphia(final ObjectId userId) {
    return ds.createQuery(User.class).field("id").equal(userId).get();
  }

  public User findUserWithJongo(final ObjectId userId) {
    return jongo.getCollection("users").findOne("{ _id : # }", userId).as(User.class);
  }
}
