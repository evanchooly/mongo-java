package com.antwerkz.jfokus.mongo.model.criteria;

import com.antwerkz.critter.TypeSafeFieldEnd;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Criteria;
import com.google.code.morphia.query.CriteriaContainer;
import com.google.code.morphia.query.Query;
import org.bson.types.ObjectId;

public class UserCriteria {
  private Query<com.antwerkz.jfokus.mongo.model.User> query;

  public Query<com.antwerkz.jfokus.mongo.model.User> query() {
    return query;
  }

  public UserCriteria(Datastore ds) {
    query = ds.find(com.antwerkz.jfokus.mongo.model.User.class);
  }

  public CriteriaContainer or(Criteria... criteria) {
    return query.or(criteria);
  }

  public CriteriaContainer and(Criteria... criteria) {
    return query.and(criteria);
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.jfokus.mongo.model.User, java.util.List<com.antwerkz.jfokus.mongo.model.Address>> addresses() {
    return new TypeSafeFieldEnd<>(query, query.criteria("addresses"));
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.jfokus.mongo.model.User, java.lang.String> email() {
    return new TypeSafeFieldEnd<>(query, query.criteria("email"));
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.jfokus.mongo.model.User, java.lang.String> firstName() {
    return new TypeSafeFieldEnd<>(query, query.criteria("firstName"));
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.jfokus.mongo.model.User, org.bson.types.ObjectId> id() {
    return new TypeSafeFieldEnd<>(query, query.criteria("id"));
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.jfokus.mongo.model.User, java.lang.String> lastName() {
    return new TypeSafeFieldEnd<>(query, query.criteria("lastName"));
  }
}
