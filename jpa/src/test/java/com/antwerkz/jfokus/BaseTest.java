package com.antwerkz.jfokus;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.antwerkz.jfokus.jpa.dao.JfokusDao;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class BaseTest {
    private EntityManagerFactory emf;

    protected PersistService persistService;

    @Inject
    private EntityManager em;

    @Inject
    protected JfokusDao dao;

    public BaseTest() {
        Injector injector = Guice.createInjector(new JpaPersistModule("jfokus"));
        persistService = injector.getInstance(PersistService.class);
        persistService.start();
        injector.injectMembers(this);
        dao.clearAll();
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
