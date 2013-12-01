package com.antwerkz.mongo.model.criteria;

import com.antwerkz.mongo.model.User;

public class UserCriteria extends com.antwerkz.critter.criteria.BaseCriteria<User> {
  private String prefix = "";

  public UserCriteria(org.mongodb.morphia.Datastore ds) {
    super(ds, User.class);
  }


  public com.antwerkz.critter.TypeSafeFieldEnd<UserCriteria, User, java.util.List<com.antwerkz.mongo.model.Address>> addresses() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "addresses");
  }

  public UserCriteria addresses(java.util.List<com.antwerkz.mongo.model.Address> value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<UserCriteria, User, java.util.List<com.antwerkz.mongo.model.Address>>(this, query, prefix + "addresses").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<UserCriteria, User, java.lang.String> email() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "email");
  }

  public UserCriteria email(java.lang.String value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<UserCriteria, User, java.lang.String>(this, query, prefix + "email").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<UserCriteria, User, java.lang.String> firstName() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "firstName");
  }

  public UserCriteria firstName(java.lang.String value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<UserCriteria, User, java.lang.String>(this, query, prefix + "firstName").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<UserCriteria, User, org.bson.types.ObjectId> id() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "id");
  }

  public UserCriteria id(org.bson.types.ObjectId value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<UserCriteria, User, org.bson.types.ObjectId>(this, query, prefix + "id").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<UserCriteria, User, java.lang.String> lastName() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "lastName");
  }

  public UserCriteria lastName(java.lang.String value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<UserCriteria, User, java.lang.String>(this, query, prefix + "lastName").equal(value);
    return this;
  }


  public UserUpdater getUpdater() {
    return new UserUpdater();
  }

  public class UserUpdater {
    org.mongodb.morphia.query.UpdateOperations<User> updateOperations;

    public UserUpdater() {
      updateOperations = ds.createUpdateOperations(User.class);
    }

    public org.mongodb.morphia.query.UpdateResults<User> update() {
      return ds.update(query(), updateOperations, false);
    }

    public org.mongodb.morphia.query.UpdateResults<User> update(com.mongodb.WriteConcern wc) {
      return ds.update(query(), updateOperations, false, wc);
    }

    public org.mongodb.morphia.query.UpdateResults<User> upsert() {
      return ds.update(query(), updateOperations, true);
    }

    public org.mongodb.morphia.query.UpdateResults<User> upsert(com.mongodb.WriteConcern wc) {
      return ds.update(query(), updateOperations, true, wc);
    }

    public UserUpdater addresses(java.util.List<com.antwerkz.mongo.model.Address> value) {
      updateOperations.set("addresses", value);
      return this;
    }

    public UserUpdater unsetAddresses(java.util.List<com.antwerkz.mongo.model.Address> value) {
      updateOperations.unset("addresses");
      return this;
    }

    public UserUpdater addAddresses(java.util.List<com.antwerkz.mongo.model.Address> value) {
      updateOperations.add("addresses", value);
      return this;
    }

    public UserUpdater addAddresses(java.util.List<com.antwerkz.mongo.model.Address> value, boolean addDups) {
      updateOperations.add("addresses", value, addDups);
      return this;
    }

    public UserUpdater addAllToAddresses(java.util.List<java.util.List<com.antwerkz.mongo.model.Address>> values, boolean addDups) {
      updateOperations.addAll("addresses", values, addDups);
      return this;
    }
  
    public UserUpdater removeFirstAddresses() {
      updateOperations.removeFirst("addresses");
      return this;
    }
  
    public UserUpdater removeLastAddresses() {
      updateOperations.removeLast("addresses");
      return this;
    }
  
    public UserUpdater removeFromAddresses(java.util.List<com.antwerkz.mongo.model.Address> value) {
      updateOperations.removeAll("addresses", value);
      return this;
    }

    public UserUpdater removeAllFromAddresses(java.util.List<java.util.List<com.antwerkz.mongo.model.Address>> values) {
      updateOperations.removeAll("addresses", values);
      return this;
    }
 
    public UserUpdater decAddresses() {
      updateOperations.dec("addresses");
      return this;
    }

    public UserUpdater incAddresses() {
      updateOperations.inc("addresses");
      return this;
    }

    public UserUpdater incAddresses(Number value) {
      updateOperations.inc("addresses", value);
      return this;
    }
    public UserUpdater email(java.lang.String value) {
      updateOperations.set("email", value);
      return this;
    }

    public UserUpdater unsetEmail(java.lang.String value) {
      updateOperations.unset("email");
      return this;
    }

    public UserUpdater addEmail(java.lang.String value) {
      updateOperations.add("email", value);
      return this;
    }

    public UserUpdater addEmail(java.lang.String value, boolean addDups) {
      updateOperations.add("email", value, addDups);
      return this;
    }

    public UserUpdater addAllToEmail(java.util.List<java.lang.String> values, boolean addDups) {
      updateOperations.addAll("email", values, addDups);
      return this;
    }
  
    public UserUpdater removeFirstEmail() {
      updateOperations.removeFirst("email");
      return this;
    }
  
    public UserUpdater removeLastEmail() {
      updateOperations.removeLast("email");
      return this;
    }
  
    public UserUpdater removeFromEmail(java.lang.String value) {
      updateOperations.removeAll("email", value);
      return this;
    }

    public UserUpdater removeAllFromEmail(java.util.List<java.lang.String> values) {
      updateOperations.removeAll("email", values);
      return this;
    }
 
    public UserUpdater decEmail() {
      updateOperations.dec("email");
      return this;
    }

    public UserUpdater incEmail() {
      updateOperations.inc("email");
      return this;
    }

    public UserUpdater incEmail(Number value) {
      updateOperations.inc("email", value);
      return this;
    }
    public UserUpdater firstName(java.lang.String value) {
      updateOperations.set("firstName", value);
      return this;
    }

    public UserUpdater unsetFirstName(java.lang.String value) {
      updateOperations.unset("firstName");
      return this;
    }

    public UserUpdater addFirstName(java.lang.String value) {
      updateOperations.add("firstName", value);
      return this;
    }

    public UserUpdater addFirstName(java.lang.String value, boolean addDups) {
      updateOperations.add("firstName", value, addDups);
      return this;
    }

    public UserUpdater addAllToFirstName(java.util.List<java.lang.String> values, boolean addDups) {
      updateOperations.addAll("firstName", values, addDups);
      return this;
    }
  
    public UserUpdater removeFirstFirstName() {
      updateOperations.removeFirst("firstName");
      return this;
    }
  
    public UserUpdater removeLastFirstName() {
      updateOperations.removeLast("firstName");
      return this;
    }
  
    public UserUpdater removeFromFirstName(java.lang.String value) {
      updateOperations.removeAll("firstName", value);
      return this;
    }

    public UserUpdater removeAllFromFirstName(java.util.List<java.lang.String> values) {
      updateOperations.removeAll("firstName", values);
      return this;
    }
 
    public UserUpdater decFirstName() {
      updateOperations.dec("firstName");
      return this;
    }

    public UserUpdater incFirstName() {
      updateOperations.inc("firstName");
      return this;
    }

    public UserUpdater incFirstName(Number value) {
      updateOperations.inc("firstName", value);
      return this;
    }
    public UserUpdater id(org.bson.types.ObjectId value) {
      updateOperations.set("id", value);
      return this;
    }

    public UserUpdater unsetId(org.bson.types.ObjectId value) {
      updateOperations.unset("id");
      return this;
    }

    public UserUpdater addId(org.bson.types.ObjectId value) {
      updateOperations.add("id", value);
      return this;
    }

    public UserUpdater addId(org.bson.types.ObjectId value, boolean addDups) {
      updateOperations.add("id", value, addDups);
      return this;
    }

    public UserUpdater addAllToId(java.util.List<org.bson.types.ObjectId> values, boolean addDups) {
      updateOperations.addAll("id", values, addDups);
      return this;
    }
  
    public UserUpdater removeFirstId() {
      updateOperations.removeFirst("id");
      return this;
    }
  
    public UserUpdater removeLastId() {
      updateOperations.removeLast("id");
      return this;
    }
  
    public UserUpdater removeFromId(org.bson.types.ObjectId value) {
      updateOperations.removeAll("id", value);
      return this;
    }

    public UserUpdater removeAllFromId(java.util.List<org.bson.types.ObjectId> values) {
      updateOperations.removeAll("id", values);
      return this;
    }
 
    public UserUpdater decId() {
      updateOperations.dec("id");
      return this;
    }

    public UserUpdater incId() {
      updateOperations.inc("id");
      return this;
    }

    public UserUpdater incId(Number value) {
      updateOperations.inc("id", value);
      return this;
    }
    public UserUpdater lastName(java.lang.String value) {
      updateOperations.set("lastName", value);
      return this;
    }

    public UserUpdater unsetLastName(java.lang.String value) {
      updateOperations.unset("lastName");
      return this;
    }

    public UserUpdater addLastName(java.lang.String value) {
      updateOperations.add("lastName", value);
      return this;
    }

    public UserUpdater addLastName(java.lang.String value, boolean addDups) {
      updateOperations.add("lastName", value, addDups);
      return this;
    }

    public UserUpdater addAllToLastName(java.util.List<java.lang.String> values, boolean addDups) {
      updateOperations.addAll("lastName", values, addDups);
      return this;
    }
  
    public UserUpdater removeFirstLastName() {
      updateOperations.removeFirst("lastName");
      return this;
    }
  
    public UserUpdater removeLastLastName() {
      updateOperations.removeLast("lastName");
      return this;
    }
  
    public UserUpdater removeFromLastName(java.lang.String value) {
      updateOperations.removeAll("lastName", value);
      return this;
    }

    public UserUpdater removeAllFromLastName(java.util.List<java.lang.String> values) {
      updateOperations.removeAll("lastName", values);
      return this;
    }
 
    public UserUpdater decLastName() {
      updateOperations.dec("lastName");
      return this;
    }

    public UserUpdater incLastName() {
      updateOperations.inc("lastName");
      return this;
    }

    public UserUpdater incLastName(Number value) {
      updateOperations.inc("lastName", value);
      return this;
    }
  }
}
