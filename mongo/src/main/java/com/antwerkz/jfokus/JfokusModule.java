package com.antwerkz.jfokus;

import java.net.UnknownHostException;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mongodb.DB;
import com.mongodb.Mongo;

public class JfokusModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    public DB db() throws UnknownHostException {
        return new Mongo().getDB("jfokus");
    }
}
