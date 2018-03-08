/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend.database;

import com.help.qcbackend.configurations.SpringMongoConfig;
import com.help.qcbackend.repo.ClientRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 *
 * @author shath
 */
public class DatabaseHandler {
    static DatabaseHandler instance = null;
    MongoOperations db;
    ApplicationContext context;
    public DatabaseHandler() {
        context = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        db = (MongoOperations) context.getBean("mongoTemplate");
        if(instance == null)
            instance = this;
    }

    public static DatabaseHandler getInstance() {
        return instance;
    }          

    public Object getRepositoryObject(Class aClass) {
        RepositoryFactorySupport factory = new MongoRepositoryFactory(db);
        return factory.getRepository(aClass);
    }

    public MongoOperations getDb() {
        return db;
    }

    public ApplicationContext getContext() {
        return context;
    }
        
    
}
