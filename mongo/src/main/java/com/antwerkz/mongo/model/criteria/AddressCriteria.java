package com.antwerkz.mongo.model.criteria;

import com.antwerkz.mongo.model.Address;

public class AddressCriteria extends com.antwerkz.critter.criteria.BaseCriteria<Address> {
  private String prefix = "";

  public AddressCriteria(org.mongodb.morphia.Datastore ds) {
    super(ds, Address.class);
  }


  public com.antwerkz.critter.TypeSafeFieldEnd<AddressCriteria, Address, java.lang.String> city() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "city");
  }

  public AddressCriteria city(java.lang.String value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<AddressCriteria, Address, java.lang.String>(this, query, prefix + "city").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<AddressCriteria, Address, org.bson.types.ObjectId> id() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "id");
  }

  public AddressCriteria id(org.bson.types.ObjectId value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<AddressCriteria, Address, org.bson.types.ObjectId>(this, query, prefix + "id").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<AddressCriteria, Address, java.lang.String> state() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "state");
  }

  public AddressCriteria state(java.lang.String value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<AddressCriteria, Address, java.lang.String>(this, query, prefix + "state").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<AddressCriteria, Address, java.lang.String> street() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "street");
  }

  public AddressCriteria street(java.lang.String value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<AddressCriteria, Address, java.lang.String>(this, query, prefix + "street").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<AddressCriteria, Address, java.lang.String> street2() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "street2");
  }

  public AddressCriteria street2(java.lang.String value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<AddressCriteria, Address, java.lang.String>(this, query, prefix + "street2").equal(value);
    return this;
  }

  public com.antwerkz.critter.TypeSafeFieldEnd<AddressCriteria, Address, java.lang.String> zip() {
    return new com.antwerkz.critter.TypeSafeFieldEnd<>(this, query, prefix + "zip");
  }

  public AddressCriteria zip(java.lang.String value) {
    new com.antwerkz.critter.TypeSafeFieldEnd<AddressCriteria, Address, java.lang.String>(this, query, prefix + "zip").equal(value);
    return this;
  }


  public AddressUpdater getUpdater() {
    return new AddressUpdater();
  }

  public class AddressUpdater {
    org.mongodb.morphia.query.UpdateOperations<Address> updateOperations;

    public AddressUpdater() {
      updateOperations = ds.createUpdateOperations(Address.class);
    }

    public org.mongodb.morphia.query.UpdateResults<Address> update() {
      return ds.update(query(), updateOperations, false);
    }

    public org.mongodb.morphia.query.UpdateResults<Address> update(com.mongodb.WriteConcern wc) {
      return ds.update(query(), updateOperations, false, wc);
    }

    public org.mongodb.morphia.query.UpdateResults<Address> upsert() {
      return ds.update(query(), updateOperations, true);
    }

    public org.mongodb.morphia.query.UpdateResults<Address> upsert(com.mongodb.WriteConcern wc) {
      return ds.update(query(), updateOperations, true, wc);
    }

    public AddressUpdater city(java.lang.String value) {
      updateOperations.set("city", value);
      return this;
    }

    public AddressUpdater unsetCity(java.lang.String value) {
      updateOperations.unset("city");
      return this;
    }

    public AddressUpdater addCity(java.lang.String value) {
      updateOperations.add("city", value);
      return this;
    }

    public AddressUpdater addCity(java.lang.String value, boolean addDups) {
      updateOperations.add("city", value, addDups);
      return this;
    }

    public AddressUpdater addAllToCity(java.util.List<java.lang.String> values, boolean addDups) {
      updateOperations.addAll("city", values, addDups);
      return this;
    }
  
    public AddressUpdater removeFirstCity() {
      updateOperations.removeFirst("city");
      return this;
    }
  
    public AddressUpdater removeLastCity() {
      updateOperations.removeLast("city");
      return this;
    }
  
    public AddressUpdater removeFromCity(java.lang.String value) {
      updateOperations.removeAll("city", value);
      return this;
    }

    public AddressUpdater removeAllFromCity(java.util.List<java.lang.String> values) {
      updateOperations.removeAll("city", values);
      return this;
    }
 
    public AddressUpdater decCity() {
      updateOperations.dec("city");
      return this;
    }

    public AddressUpdater incCity() {
      updateOperations.inc("city");
      return this;
    }

    public AddressUpdater incCity(Number value) {
      updateOperations.inc("city", value);
      return this;
    }
    public AddressUpdater id(org.bson.types.ObjectId value) {
      updateOperations.set("id", value);
      return this;
    }

    public AddressUpdater unsetId(org.bson.types.ObjectId value) {
      updateOperations.unset("id");
      return this;
    }

    public AddressUpdater addId(org.bson.types.ObjectId value) {
      updateOperations.add("id", value);
      return this;
    }

    public AddressUpdater addId(org.bson.types.ObjectId value, boolean addDups) {
      updateOperations.add("id", value, addDups);
      return this;
    }

    public AddressUpdater addAllToId(java.util.List<org.bson.types.ObjectId> values, boolean addDups) {
      updateOperations.addAll("id", values, addDups);
      return this;
    }
  
    public AddressUpdater removeFirstId() {
      updateOperations.removeFirst("id");
      return this;
    }
  
    public AddressUpdater removeLastId() {
      updateOperations.removeLast("id");
      return this;
    }
  
    public AddressUpdater removeFromId(org.bson.types.ObjectId value) {
      updateOperations.removeAll("id", value);
      return this;
    }

    public AddressUpdater removeAllFromId(java.util.List<org.bson.types.ObjectId> values) {
      updateOperations.removeAll("id", values);
      return this;
    }
 
    public AddressUpdater decId() {
      updateOperations.dec("id");
      return this;
    }

    public AddressUpdater incId() {
      updateOperations.inc("id");
      return this;
    }

    public AddressUpdater incId(Number value) {
      updateOperations.inc("id", value);
      return this;
    }
    public AddressUpdater state(java.lang.String value) {
      updateOperations.set("state", value);
      return this;
    }

    public AddressUpdater unsetState(java.lang.String value) {
      updateOperations.unset("state");
      return this;
    }

    public AddressUpdater addState(java.lang.String value) {
      updateOperations.add("state", value);
      return this;
    }

    public AddressUpdater addState(java.lang.String value, boolean addDups) {
      updateOperations.add("state", value, addDups);
      return this;
    }

    public AddressUpdater addAllToState(java.util.List<java.lang.String> values, boolean addDups) {
      updateOperations.addAll("state", values, addDups);
      return this;
    }
  
    public AddressUpdater removeFirstState() {
      updateOperations.removeFirst("state");
      return this;
    }
  
    public AddressUpdater removeLastState() {
      updateOperations.removeLast("state");
      return this;
    }
  
    public AddressUpdater removeFromState(java.lang.String value) {
      updateOperations.removeAll("state", value);
      return this;
    }

    public AddressUpdater removeAllFromState(java.util.List<java.lang.String> values) {
      updateOperations.removeAll("state", values);
      return this;
    }
 
    public AddressUpdater decState() {
      updateOperations.dec("state");
      return this;
    }

    public AddressUpdater incState() {
      updateOperations.inc("state");
      return this;
    }

    public AddressUpdater incState(Number value) {
      updateOperations.inc("state", value);
      return this;
    }
    public AddressUpdater street(java.lang.String value) {
      updateOperations.set("street", value);
      return this;
    }

    public AddressUpdater unsetStreet(java.lang.String value) {
      updateOperations.unset("street");
      return this;
    }

    public AddressUpdater addStreet(java.lang.String value) {
      updateOperations.add("street", value);
      return this;
    }

    public AddressUpdater addStreet(java.lang.String value, boolean addDups) {
      updateOperations.add("street", value, addDups);
      return this;
    }

    public AddressUpdater addAllToStreet(java.util.List<java.lang.String> values, boolean addDups) {
      updateOperations.addAll("street", values, addDups);
      return this;
    }
  
    public AddressUpdater removeFirstStreet() {
      updateOperations.removeFirst("street");
      return this;
    }
  
    public AddressUpdater removeLastStreet() {
      updateOperations.removeLast("street");
      return this;
    }
  
    public AddressUpdater removeFromStreet(java.lang.String value) {
      updateOperations.removeAll("street", value);
      return this;
    }

    public AddressUpdater removeAllFromStreet(java.util.List<java.lang.String> values) {
      updateOperations.removeAll("street", values);
      return this;
    }
 
    public AddressUpdater decStreet() {
      updateOperations.dec("street");
      return this;
    }

    public AddressUpdater incStreet() {
      updateOperations.inc("street");
      return this;
    }

    public AddressUpdater incStreet(Number value) {
      updateOperations.inc("street", value);
      return this;
    }
    public AddressUpdater street2(java.lang.String value) {
      updateOperations.set("street2", value);
      return this;
    }

    public AddressUpdater unsetStreet2(java.lang.String value) {
      updateOperations.unset("street2");
      return this;
    }

    public AddressUpdater addStreet2(java.lang.String value) {
      updateOperations.add("street2", value);
      return this;
    }

    public AddressUpdater addStreet2(java.lang.String value, boolean addDups) {
      updateOperations.add("street2", value, addDups);
      return this;
    }

    public AddressUpdater addAllToStreet2(java.util.List<java.lang.String> values, boolean addDups) {
      updateOperations.addAll("street2", values, addDups);
      return this;
    }
  
    public AddressUpdater removeFirstStreet2() {
      updateOperations.removeFirst("street2");
      return this;
    }
  
    public AddressUpdater removeLastStreet2() {
      updateOperations.removeLast("street2");
      return this;
    }
  
    public AddressUpdater removeFromStreet2(java.lang.String value) {
      updateOperations.removeAll("street2", value);
      return this;
    }

    public AddressUpdater removeAllFromStreet2(java.util.List<java.lang.String> values) {
      updateOperations.removeAll("street2", values);
      return this;
    }
 
    public AddressUpdater decStreet2() {
      updateOperations.dec("street2");
      return this;
    }

    public AddressUpdater incStreet2() {
      updateOperations.inc("street2");
      return this;
    }

    public AddressUpdater incStreet2(Number value) {
      updateOperations.inc("street2", value);
      return this;
    }
    public AddressUpdater zip(java.lang.String value) {
      updateOperations.set("zip", value);
      return this;
    }

    public AddressUpdater unsetZip(java.lang.String value) {
      updateOperations.unset("zip");
      return this;
    }

    public AddressUpdater addZip(java.lang.String value) {
      updateOperations.add("zip", value);
      return this;
    }

    public AddressUpdater addZip(java.lang.String value, boolean addDups) {
      updateOperations.add("zip", value, addDups);
      return this;
    }

    public AddressUpdater addAllToZip(java.util.List<java.lang.String> values, boolean addDups) {
      updateOperations.addAll("zip", values, addDups);
      return this;
    }
  
    public AddressUpdater removeFirstZip() {
      updateOperations.removeFirst("zip");
      return this;
    }
  
    public AddressUpdater removeLastZip() {
      updateOperations.removeLast("zip");
      return this;
    }
  
    public AddressUpdater removeFromZip(java.lang.String value) {
      updateOperations.removeAll("zip", value);
      return this;
    }

    public AddressUpdater removeAllFromZip(java.util.List<java.lang.String> values) {
      updateOperations.removeAll("zip", values);
      return this;
    }
 
    public AddressUpdater decZip() {
      updateOperations.dec("zip");
      return this;
    }

    public AddressUpdater incZip() {
      updateOperations.inc("zip");
      return this;
    }

    public AddressUpdater incZip(Number value) {
      updateOperations.inc("zip", value);
      return this;
    }
  }
}
