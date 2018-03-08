/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.help.qcbackend.models.Client;
import com.help.qcbackend.models.SequenceCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 *
 * Reference: https://stackoverflow.com/questions/36448921/how-can-we-create-auto-generated-field-for-mongodb-using-spring-boot
 * @author shath
 */
@Service
public class CounterService {
  @Autowired private MongoOperations mongo;

    public void setMongo(MongoOperations mongo) {
        this.mongo = mongo;
    }   
   
  public int getNextSequence(String collectionName) { 
      query(where("id").is("client"));
      SequenceCounter counter = mongo.findAndModify(
      query(where("_id").is(collectionName)), 
      new Update().inc("seq", 1),
      options().returnNew(true).upsert(true),
      SequenceCounter.class);       
    return counter.getSeq();
  }
}