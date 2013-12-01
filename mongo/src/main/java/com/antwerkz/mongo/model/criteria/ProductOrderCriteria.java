package com.antwerkz.mongo.model.criteria;

import com.antwerkz.mongo.model.ProductOrder;

public class ProductOrderCriteria extends com.antwerkz.critter.criteria.BaseCriteria<ProductOrder> {
  private String prefix = "";

  public ProductOrderCriteria(org.mongodb.morphia.Datastore ds) {
    super(ds, ProductOrder.class);
  }


  public com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, java.lang.Boolean> fulfilled() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "fulfilled");
  }

  public ProductOrderCriteria fulfilled(java.lang.Boolean value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, java.lang.Boolean>(this, query, prefix + "fulfilled").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, org.bson.types.ObjectId> id() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "id");
  }

  public ProductOrderCriteria id(org.bson.types.ObjectId value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, org.bson.types.ObjectId>(this, query, prefix + "id").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, java.util.Date> orderDate() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "orderDate");
  }

  public ProductOrderCriteria orderDate(java.util.Date value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, java.util.Date>(this, query, prefix + "orderDate").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, java.util.List<com.antwerkz.mongo.model.Product>> products() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "products");
  }

  public ProductOrderCriteria products(java.util.List<com.antwerkz.mongo.model.Product> value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, java.util.List<com.antwerkz.mongo.model.Product>>(this, query, prefix + "products").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, java.lang.Integer> size() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "size");
  }

  public ProductOrderCriteria size(java.lang.Integer value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, java.lang.Integer>(this, query, prefix + "size").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, java.lang.Double> total() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "total");
  }

  public ProductOrderCriteria total(java.lang.Double value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, java.lang.Double>(this, query, prefix + "total").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, org.bson.types.ObjectId> userId() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "userId");
  }

  public ProductOrderCriteria userId(org.bson.types.ObjectId value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<ProductOrderCriteria, ProductOrder, org.bson.types.ObjectId>(this, query, prefix + "userId").equal(value);
    return this;
  }


  public ProductOrderUpdater getUpdater() {
    return new ProductOrderUpdater();
  }

  public class ProductOrderUpdater {
    org.mongodb.morphia.query.UpdateOperations<ProductOrder> updateOperations;

    public ProductOrderUpdater() {
      updateOperations = ds.createUpdateOperations(ProductOrder.class);
    }

    public org.mongodb.morphia.query.UpdateResults<ProductOrder> update() {
      return ds.update(query(), updateOperations, false);
    }

    public org.mongodb.morphia.query.UpdateResults<ProductOrder> update(com.mongodb.WriteConcern wc) {
      return ds.update(query(), updateOperations, false, wc);
    }

    public org.mongodb.morphia.query.UpdateResults<ProductOrder> upsert() {
      return ds.update(query(), updateOperations, true);
    }

    public org.mongodb.morphia.query.UpdateResults<ProductOrder> upsert(com.mongodb.WriteConcern wc) {
      return ds.update(query(), updateOperations, true, wc);
    }

    public ProductOrderUpdater fulfilled(java.lang.Boolean value) {
      updateOperations.set("fulfilled", value);
      return this;
    }

    public ProductOrderUpdater unsetFulfilled(java.lang.Boolean value) {
      updateOperations.unset("fulfilled");
      return this;
    }

    public ProductOrderUpdater addFulfilled(java.lang.Boolean value) {
      updateOperations.add("fulfilled", value);
      return this;
    }

    public ProductOrderUpdater addFulfilled(java.lang.Boolean value, boolean addDups) {
      updateOperations.add("fulfilled", value, addDups);
      return this;
    }

    public ProductOrderUpdater addAllToFulfilled(java.util.List<java.lang.Boolean> values, boolean addDups) {
      updateOperations.addAll("fulfilled", values, addDups);
      return this;
    }
  
    public ProductOrderUpdater removeFirstFulfilled() {
      updateOperations.removeFirst("fulfilled");
      return this;
    }
  
    public ProductOrderUpdater removeLastFulfilled() {
      updateOperations.removeLast("fulfilled");
      return this;
    }
  
    public ProductOrderUpdater removeFromFulfilled(java.lang.Boolean value) {
      updateOperations.removeAll("fulfilled", value);
      return this;
    }

    public ProductOrderUpdater removeAllFromFulfilled(java.util.List<java.lang.Boolean> values) {
      updateOperations.removeAll("fulfilled", values);
      return this;
    }
 
    public ProductOrderUpdater decFulfilled() {
      updateOperations.dec("fulfilled");
      return this;
    }

    public ProductOrderUpdater incFulfilled() {
      updateOperations.inc("fulfilled");
      return this;
    }

    public ProductOrderUpdater incFulfilled(Number value) {
      updateOperations.inc("fulfilled", value);
      return this;
    }
    public ProductOrderUpdater id(org.bson.types.ObjectId value) {
      updateOperations.set("id", value);
      return this;
    }

    public ProductOrderUpdater unsetId(org.bson.types.ObjectId value) {
      updateOperations.unset("id");
      return this;
    }

    public ProductOrderUpdater addId(org.bson.types.ObjectId value) {
      updateOperations.add("id", value);
      return this;
    }

    public ProductOrderUpdater addId(org.bson.types.ObjectId value, boolean addDups) {
      updateOperations.add("id", value, addDups);
      return this;
    }

    public ProductOrderUpdater addAllToId(java.util.List<org.bson.types.ObjectId> values, boolean addDups) {
      updateOperations.addAll("id", values, addDups);
      return this;
    }
  
    public ProductOrderUpdater removeFirstId() {
      updateOperations.removeFirst("id");
      return this;
    }
  
    public ProductOrderUpdater removeLastId() {
      updateOperations.removeLast("id");
      return this;
    }
  
    public ProductOrderUpdater removeFromId(org.bson.types.ObjectId value) {
      updateOperations.removeAll("id", value);
      return this;
    }

    public ProductOrderUpdater removeAllFromId(java.util.List<org.bson.types.ObjectId> values) {
      updateOperations.removeAll("id", values);
      return this;
    }
 
    public ProductOrderUpdater decId() {
      updateOperations.dec("id");
      return this;
    }

    public ProductOrderUpdater incId() {
      updateOperations.inc("id");
      return this;
    }

    public ProductOrderUpdater incId(Number value) {
      updateOperations.inc("id", value);
      return this;
    }
    public ProductOrderUpdater orderDate(java.util.Date value) {
      updateOperations.set("orderDate", value);
      return this;
    }

    public ProductOrderUpdater unsetOrderDate(java.util.Date value) {
      updateOperations.unset("orderDate");
      return this;
    }

    public ProductOrderUpdater addOrderDate(java.util.Date value) {
      updateOperations.add("orderDate", value);
      return this;
    }

    public ProductOrderUpdater addOrderDate(java.util.Date value, boolean addDups) {
      updateOperations.add("orderDate", value, addDups);
      return this;
    }

    public ProductOrderUpdater addAllToOrderDate(java.util.List<java.util.Date> values, boolean addDups) {
      updateOperations.addAll("orderDate", values, addDups);
      return this;
    }
  
    public ProductOrderUpdater removeFirstOrderDate() {
      updateOperations.removeFirst("orderDate");
      return this;
    }
  
    public ProductOrderUpdater removeLastOrderDate() {
      updateOperations.removeLast("orderDate");
      return this;
    }
  
    public ProductOrderUpdater removeFromOrderDate(java.util.Date value) {
      updateOperations.removeAll("orderDate", value);
      return this;
    }

    public ProductOrderUpdater removeAllFromOrderDate(java.util.List<java.util.Date> values) {
      updateOperations.removeAll("orderDate", values);
      return this;
    }
 
    public ProductOrderUpdater decOrderDate() {
      updateOperations.dec("orderDate");
      return this;
    }

    public ProductOrderUpdater incOrderDate() {
      updateOperations.inc("orderDate");
      return this;
    }

    public ProductOrderUpdater incOrderDate(Number value) {
      updateOperations.inc("orderDate", value);
      return this;
    }
    public ProductOrderUpdater products(java.util.List<com.antwerkz.mongo.model.Product> value) {
      updateOperations.set("products", value);
      return this;
    }

    public ProductOrderUpdater unsetProducts(java.util.List<com.antwerkz.mongo.model.Product> value) {
      updateOperations.unset("products");
      return this;
    }

    public ProductOrderUpdater addProducts(java.util.List<com.antwerkz.mongo.model.Product> value) {
      updateOperations.add("products", value);
      return this;
    }

    public ProductOrderUpdater addProducts(java.util.List<com.antwerkz.mongo.model.Product> value, boolean addDups) {
      updateOperations.add("products", value, addDups);
      return this;
    }

    public ProductOrderUpdater addAllToProducts(java.util.List<java.util.List<com.antwerkz.mongo.model.Product>> values, boolean addDups) {
      updateOperations.addAll("products", values, addDups);
      return this;
    }
  
    public ProductOrderUpdater removeFirstProducts() {
      updateOperations.removeFirst("products");
      return this;
    }
  
    public ProductOrderUpdater removeLastProducts() {
      updateOperations.removeLast("products");
      return this;
    }
  
    public ProductOrderUpdater removeFromProducts(java.util.List<com.antwerkz.mongo.model.Product> value) {
      updateOperations.removeAll("products", value);
      return this;
    }

    public ProductOrderUpdater removeAllFromProducts(java.util.List<java.util.List<com.antwerkz.mongo.model.Product>> values) {
      updateOperations.removeAll("products", values);
      return this;
    }
 
    public ProductOrderUpdater decProducts() {
      updateOperations.dec("products");
      return this;
    }

    public ProductOrderUpdater incProducts() {
      updateOperations.inc("products");
      return this;
    }

    public ProductOrderUpdater incProducts(Number value) {
      updateOperations.inc("products", value);
      return this;
    }
    public ProductOrderUpdater size(java.lang.Integer value) {
      updateOperations.set("size", value);
      return this;
    }

    public ProductOrderUpdater unsetSize(java.lang.Integer value) {
      updateOperations.unset("size");
      return this;
    }

    public ProductOrderUpdater addSize(java.lang.Integer value) {
      updateOperations.add("size", value);
      return this;
    }

    public ProductOrderUpdater addSize(java.lang.Integer value, boolean addDups) {
      updateOperations.add("size", value, addDups);
      return this;
    }

    public ProductOrderUpdater addAllToSize(java.util.List<java.lang.Integer> values, boolean addDups) {
      updateOperations.addAll("size", values, addDups);
      return this;
    }
  
    public ProductOrderUpdater removeFirstSize() {
      updateOperations.removeFirst("size");
      return this;
    }
  
    public ProductOrderUpdater removeLastSize() {
      updateOperations.removeLast("size");
      return this;
    }
  
    public ProductOrderUpdater removeFromSize(java.lang.Integer value) {
      updateOperations.removeAll("size", value);
      return this;
    }

    public ProductOrderUpdater removeAllFromSize(java.util.List<java.lang.Integer> values) {
      updateOperations.removeAll("size", values);
      return this;
    }
 
    public ProductOrderUpdater decSize() {
      updateOperations.dec("size");
      return this;
    }

    public ProductOrderUpdater incSize() {
      updateOperations.inc("size");
      return this;
    }

    public ProductOrderUpdater incSize(Number value) {
      updateOperations.inc("size", value);
      return this;
    }
    public ProductOrderUpdater total(java.lang.Double value) {
      updateOperations.set("total", value);
      return this;
    }

    public ProductOrderUpdater unsetTotal(java.lang.Double value) {
      updateOperations.unset("total");
      return this;
    }

    public ProductOrderUpdater addTotal(java.lang.Double value) {
      updateOperations.add("total", value);
      return this;
    }

    public ProductOrderUpdater addTotal(java.lang.Double value, boolean addDups) {
      updateOperations.add("total", value, addDups);
      return this;
    }

    public ProductOrderUpdater addAllToTotal(java.util.List<java.lang.Double> values, boolean addDups) {
      updateOperations.addAll("total", values, addDups);
      return this;
    }
  
    public ProductOrderUpdater removeFirstTotal() {
      updateOperations.removeFirst("total");
      return this;
    }
  
    public ProductOrderUpdater removeLastTotal() {
      updateOperations.removeLast("total");
      return this;
    }
  
    public ProductOrderUpdater removeFromTotal(java.lang.Double value) {
      updateOperations.removeAll("total", value);
      return this;
    }

    public ProductOrderUpdater removeAllFromTotal(java.util.List<java.lang.Double> values) {
      updateOperations.removeAll("total", values);
      return this;
    }
 
    public ProductOrderUpdater decTotal() {
      updateOperations.dec("total");
      return this;
    }

    public ProductOrderUpdater incTotal() {
      updateOperations.inc("total");
      return this;
    }

    public ProductOrderUpdater incTotal(Number value) {
      updateOperations.inc("total", value);
      return this;
    }
    public ProductOrderUpdater userId(org.bson.types.ObjectId value) {
      updateOperations.set("userId", value);
      return this;
    }

    public ProductOrderUpdater unsetUserId(org.bson.types.ObjectId value) {
      updateOperations.unset("userId");
      return this;
    }

    public ProductOrderUpdater addUserId(org.bson.types.ObjectId value) {
      updateOperations.add("userId", value);
      return this;
    }

    public ProductOrderUpdater addUserId(org.bson.types.ObjectId value, boolean addDups) {
      updateOperations.add("userId", value, addDups);
      return this;
    }

    public ProductOrderUpdater addAllToUserId(java.util.List<org.bson.types.ObjectId> values, boolean addDups) {
      updateOperations.addAll("userId", values, addDups);
      return this;
    }
  
    public ProductOrderUpdater removeFirstUserId() {
      updateOperations.removeFirst("userId");
      return this;
    }
  
    public ProductOrderUpdater removeLastUserId() {
      updateOperations.removeLast("userId");
      return this;
    }
  
    public ProductOrderUpdater removeFromUserId(org.bson.types.ObjectId value) {
      updateOperations.removeAll("userId", value);
      return this;
    }

    public ProductOrderUpdater removeAllFromUserId(java.util.List<org.bson.types.ObjectId> values) {
      updateOperations.removeAll("userId", values);
      return this;
    }
 
    public ProductOrderUpdater decUserId() {
      updateOperations.dec("userId");
      return this;
    }

    public ProductOrderUpdater incUserId() {
      updateOperations.inc("userId");
      return this;
    }

    public ProductOrderUpdater incUserId(Number value) {
      updateOperations.inc("userId", value);
      return this;
    }
  }
}
