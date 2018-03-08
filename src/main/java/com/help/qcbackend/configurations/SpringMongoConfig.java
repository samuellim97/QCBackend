/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend.configurations;

import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 *
 * @author shath
 */
@Configuration
public class SpringMongoConfig {
    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception{        
        return new SimpleMongoDbFactory(new MongoClientURI("mongodb://localhost/test"));        
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception{
        return new MongoTemplate(mongoDbFactory());
    }
}
