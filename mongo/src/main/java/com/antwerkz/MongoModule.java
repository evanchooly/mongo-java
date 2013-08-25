package com.antwerkz;

import java.net.UnknownHostException;

import com.antwerkz.mongo.model.Address;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mongodb.DB;
import com.mongodb.Mongo;
import org.jongo.Jongo;

public class MongoModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    public Datastore datastore() throws UnknownHostException {
        Morphia morphia = new Morphia().mapPackageFromClass(Address.class);
        return morphia.createDatastore(new Mongo(), "jpa");
    }
    @Provides
    @Singleton
    public DB db() throws UnknownHostException {
        return new Mongo().getDB("jpa");
    }

    @Provides
    @Singleton
    @Inject
    public Jongo jongo(DB db) {
        return new Jongo(db);
    }
}
