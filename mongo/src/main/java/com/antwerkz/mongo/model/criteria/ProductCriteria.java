package com.antwerkz.mongo.model.criteria;

import com.antwerkz.mongo.model.Product;

public class ProductCriteria extends com.antwerkz.critter.criteria.BaseCriteria<Product> {
  private String prefix = "";

  public ProductCriteria(org.mongodb.morphia.Datastore ds) {
    super(ds, Product.class);
  }


  public com.antwerkz.critter.TypeSafeFieldEnd<ProductCriteria, Product, org.bson.types.ObjectId> id() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "id");
  }

  public ProductCriteria id(org.bson.types.ObjectId value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<ProductCriteria, Product, org.bson.types.ObjectId>(this, query, prefix + "id").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<ProductCriteria, Product, java.lang.String> name() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "name");
  }

  public ProductCriteria name(java.lang.String value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<ProductCriteria, Product, java.lang.String>(this, query, prefix + "name").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<ProductCriteria, Product, java.lang.Double> price() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "price");
  }

  public ProductCriteria price(java.lang.Double value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<ProductCriteria, Product, java.lang.Double>(this, query, prefix + "price").equal(value);
    return this;
  }


  public ProductUpdater getUpdater() {
    return new ProductUpdater();
  }

  public class ProductUpdater {
    org.mongodb.morphia.query.UpdateOperations<Product> updateOperations;

    public ProductUpdater() {
      updateOperations = ds.createUpdateOperations(Product.class);
    }

    public org.mongodb.morphia.query.UpdateResults<Product> update() {
      return ds.update(query(), updateOperations, false);
    }

    public org.mongodb.morphia.query.UpdateResults<Product> update(com.mongodb.WriteConcern wc) {
      return ds.update(query(), updateOperations, false, wc);
    }

    public org.mongodb.morphia.query.UpdateResults<Product> upsert() {
      return ds.update(query(), updateOperations, true);
    }

    public org.mongodb.morphia.query.UpdateResults<Product> upsert(com.mongodb.WriteConcern wc) {
      return ds.update(query(), updateOperations, true, wc);
    }

    public ProductUpdater id(org.bson.types.ObjectId value) {
      updateOperations.set("id", value);
      return this;
    }

    public ProductUpdater unsetId(org.bson.types.ObjectId value) {
      updateOperations.unset("id");
      return this;
    }

    public ProductUpdater addId(org.bson.types.ObjectId value) {
      updateOperations.add("id", value);
      return this;
    }

    public ProductUpdater addId(org.bson.types.ObjectId value, boolean addDups) {
      updateOperations.add("id", value, addDups);
      return this;
    }

    public ProductUpdater addAllToId(java.util.List<org.bson.types.ObjectId> values, boolean addDups) {
      updateOperations.addAll("id", values, addDups);
      return this;
    }
  
    public ProductUpdater removeFirstId() {
      updateOperations.removeFirst("id");
      return this;
    }
  
    public ProductUpdater removeLastId() {
      updateOperations.removeLast("id");
      return this;
    }
  
    public ProductUpdater removeFromId(org.bson.types.ObjectId value) {
      updateOperations.removeAll("id", value);
      return this;
    }

    public ProductUpdater removeAllFromId(java.util.List<org.bson.types.ObjectId> values) {
      updateOperations.removeAll("id", values);
      return this;
    }
 
    public ProductUpdater decId() {
      updateOperations.dec("id");
      return this;
    }

    public ProductUpdater incId() {
      updateOperations.inc("id");
      return this;
    }

    public ProductUpdater incId(Number value) {
      updateOperations.inc("id", value);
      return this;
    }
    public ProductUpdater name(java.lang.String value) {
      updateOperations.set("name", value);
      return this;
    }

    public ProductUpdater unsetName(java.lang.String value) {
      updateOperations.unset("name");
      return this;
    }

    public ProductUpdater addName(java.lang.String value) {
      updateOperations.add("name", value);
      return this;
    }

    public ProductUpdater addName(java.lang.String value, boolean addDups) {
      updateOperations.add("name", value, addDups);
      return this;
    }

    public ProductUpdater addAllToName(java.util.List<java.lang.String> values, boolean addDups) {
      updateOperations.addAll("name", values, addDups);
      return this;
    }
  
    public ProductUpdater removeFirstName() {
      updateOperations.removeFirst("name");
      return this;
    }
  
    public ProductUpdater removeLastName() {
      updateOperations.removeLast("name");
      return this;
    }
  
    public ProductUpdater removeFromName(java.lang.String value) {
      updateOperations.removeAll("name", value);
      return this;
    }

    public ProductUpdater removeAllFromName(java.util.List<java.lang.String> values) {
      updateOperations.removeAll("name", values);
      return this;
    }
 
    public ProductUpdater decName() {
      updateOperations.dec("name");
      return this;
    }

    public ProductUpdater incName() {
      updateOperations.inc("name");
      return this;
    }

    public ProductUpdater incName(Number value) {
      updateOperations.inc("name", value);
      return this;
    }
    public ProductUpdater price(java.lang.Double value) {
      updateOperations.set("price", value);
      return this;
    }

    public ProductUpdater unsetPrice(java.lang.Double value) {
      updateOperations.unset("price");
      return this;
    }

    public ProductUpdater addPrice(java.lang.Double value) {
      updateOperations.add("price", value);
      return this;
    }

    public ProductUpdater addPrice(java.lang.Double value, boolean addDups) {
      updateOperations.add("price", value, addDups);
      return this;
    }

    public ProductUpdater addAllToPrice(java.util.List<java.lang.Double> values, boolean addDups) {
      updateOperations.addAll("price", values, addDups);
      return this;
    }
  
    public ProductUpdater removeFirstPrice() {
      updateOperations.removeFirst("price");
      return this;
    }
  
    public ProductUpdater removeLastPrice() {
      updateOperations.removeLast("price");
      return this;
    }
  
    public ProductUpdater removeFromPrice(java.lang.Double value) {
      updateOperations.removeAll("price", value);
      return this;
    }

    public ProductUpdater removeAllFromPrice(java.util.List<java.lang.Double> values) {
      updateOperations.removeAll("price", values);
      return this;
    }
 
    public ProductUpdater decPrice() {
      updateOperations.dec("price");
      return this;
    }

    public ProductUpdater incPrice() {
      updateOperations.inc("price");
      return this;
    }

    public ProductUpdater incPrice(Number value) {
      updateOperations.inc("price", value);
      return this;
    }
  }
}
