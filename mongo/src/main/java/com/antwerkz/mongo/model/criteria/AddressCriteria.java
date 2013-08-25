package com.antwerkz.mongo.model.criteria;

import com.antwerkz.critter.TypeSafeFieldEnd;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Criteria;
import com.google.code.morphia.query.CriteriaContainer;
import com.google.code.morphia.query.Query;

public class AddressCriteria {
  private Query<com.antwerkz.mongo.model.Address> query;

  public Query<com.antwerkz.mongo.model.Address> query() {
    return query;
  }

  public AddressCriteria(Datastore ds) {
    query = ds.find(com.antwerkz.mongo.model.Address.class);
  }

  public CriteriaContainer or(Criteria... criteria) {
    return query.or(criteria);
  }

  public CriteriaContainer and(Criteria... criteria) {
    return query.and(criteria);
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.mongo.model.Address, java.lang.String> city() {
    return new TypeSafeFieldEnd<>(query, query.criteria("city"));
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.mongo.model.Address, org.bson.types.ObjectId> id() {
    return new TypeSafeFieldEnd<>(query, query.criteria("id"));
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.mongo.model.Address, java.lang.String> state() {
    return new TypeSafeFieldEnd<>(query, query.criteria("state"));
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.mongo.model.Address, java.lang.String> street() {
    return new TypeSafeFieldEnd<>(query, query.criteria("street"));
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.mongo.model.Address, java.lang.String> street2() {
    return new TypeSafeFieldEnd<>(query, query.criteria("street2"));
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.mongo.model.Address, java.lang.String> zip() {
    return new TypeSafeFieldEnd<>(query, query.criteria("zip"));
  }
}
