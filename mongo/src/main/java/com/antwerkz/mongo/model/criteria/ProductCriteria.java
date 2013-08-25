package com.antwerkz.mongo.model.criteria;

import com.antwerkz.critter.TypeSafeFieldEnd;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Criteria;
import com.google.code.morphia.query.CriteriaContainer;
import com.google.code.morphia.query.Query;

public class ProductCriteria {
  private Query<com.antwerkz.mongo.model.Product> query;

  public Query<com.antwerkz.mongo.model.Product> query() {
    return query;
  }

  public ProductCriteria(Datastore ds) {
    query = ds.find(com.antwerkz.mongo.model.Product.class);
  }

  public CriteriaContainer or(Criteria... criteria) {
    return query.or(criteria);
  }

  public CriteriaContainer and(Criteria... criteria) {
    return query.and(criteria);
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.mongo.model.Product, org.bson.types.ObjectId> id() {
    return new TypeSafeFieldEnd<>(query, query.criteria("id"));
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.mongo.model.Product, java.lang.String> name() {
    return new TypeSafeFieldEnd<>(query, query.criteria("name"));
  }

  public TypeSafeFieldEnd<? extends CriteriaContainer, com.antwerkz.mongo.model.Product, java.lang.Double> price() {
    return new TypeSafeFieldEnd<>(query, query.criteria("price"));
  }
}
