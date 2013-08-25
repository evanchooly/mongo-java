package com.antwerkz.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.antwerkz.jpa.jpa.dao.JpaDao;
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
    protected JpaDao dao;

    public BaseTest() {
        Injector injector = Guice.createInjector(new JpaPersistModule("jpa"));
        persistService = injector.getInstance(PersistService.class);
        persistService.start();
        injector.injectMembers(this);
        dao.clearAll();
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
