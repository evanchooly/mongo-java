package com.antwerkz.jfokus.mongo.model;

import com.google.code.morphia.annotations.Id;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

public class JfokusEntity {
    @Id
    private ObjectId id;

    public final ObjectId getId() {
        return id;
    }

    public final void setId(final ObjectId id) {
        this.id = id;
    }

    public JfokusEntity() {
    }

    public JfokusEntity(final DBObject dbObject) {
        id = get(dbObject, "_id");
    }

    @SuppressWarnings("unchecked")
    protected <T> T get(final DBObject dbObject, final String key) {
        return (T) dbObject.get(key);
    }
}
