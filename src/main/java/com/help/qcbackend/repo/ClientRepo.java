/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.help.qcbackend.models.Client;
/**
 *
 * @author shath
 */
public interface ClientRepo  extends MongoRepository<Client, String>{
    
    public Client findByName(String name);    
    public Client findById(String id);
    //public List<Client> searchName(String name);
    
}
