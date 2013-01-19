package com.antwerkz.jfokus;

import javax.inject.Inject;

import com.antwerkz.jfokus.jpa.dao.JfokusDao;
import com.mongodb.DB;
import org.testng.annotations.Guice;

@Guice(modules = {JfokusModule.class})
public class BaseTest {

    @Inject
    private DB db;

    @Inject
    protected JfokusDao dao;

    public BaseTest() {
        dao.clearAll();
    }
}