package com.antwerkz.mongo.model;

import org.mongodb.morphia.annotations.Id;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

public class MongoEntity {
    @Id @org.jongo.marshall.jackson.oid.Id
    private ObjectId id;

    public final ObjectId getId() {
        return id;
    }

    public final void setId(final ObjectId id) {
        this.id = id;
    }

    public MongoEntity() {
    }

    public MongoEntity(final DBObject dbObject) {
        id = get(dbObject, "_id");
    }

    @SuppressWarnings("unchecked")
    protected <T> T get(final DBObject dbObject, final String key) {
        return (T) dbObject.get(key);
    }
}
