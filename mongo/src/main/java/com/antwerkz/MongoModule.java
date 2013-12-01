package com.antwerkz;

import java.net.UnknownHostException;

import com.antwerkz.mongo.model.Address;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;

public class MongoModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    public Datastore datastore() throws UnknownHostException {
        Morphia morphia = new Morphia().mapPackageFromClass(Address.class);
        return morphia.createDatastore(new MongoClient(), "mongojpa");
    }
    @Provides
    @Singleton
    public DB db() throws UnknownHostException {
        return new MongoClient().getDB("mongojpa");
    }

    @Provides
    @Singleton
    @Inject
    public Jongo jongo(DB db) {
        return new Jongo(db);
    }
}
