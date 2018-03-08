/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend;

import com.help.qcbackend.configurations.SpringMongoConfig;
import com.help.qcbackend.database.DatabaseHandler;
import com.help.qcbackend.models.Client;
import com.help.qcbackend.models.User;
import com.help.qcbackend.repo.ClientRepo;
import com.help.qcbackend.repo.QuickCardRepo;
import com.help.qcbackend.repo.UserRepo;
import com.help.qcbackend.services.CounterService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Controller;

/**
 * The primary controller.
 * @author shath
 */
public class QCB {
    DatabaseHandler db;
    
    private ClientRepo clientRepo;
    private UserRepo userRepo;
    private QuickCardRepo quickCardRepo;
    
    /**
     * QCB constructor connects to the database.
     */
    public QCB() {
        db = new DatabaseHandler();
        connectRepositories();
    }
    
    
    /**
     * Creates DAO objects
     */
    private void connectRepositories() {
        clientRepo = (ClientRepo) db.getRepositoryObject(ClientRepo.class);
        userRepo = (UserRepo) db.getRepositoryObject(UserRepo.class);
        quickCardRepo = (QuickCardRepo) db.getRepositoryObject(QuickCardRepo.class);                
    }
    
    
    void deleteAllClients() {
        clientRepo.deleteAll();
        
    }


    public class ModelCreator{
        public Client createClient(String name){
            return new Client(name, 0.0);
        }
    };
    
    public void addUser(String name, String email){
        userRepo.insert(new User(email, name));
    }
 
    
    /**
     *  Adds new client to the system
     * @param c
     * @return 
     **/
    public Client addNewClient(Client c){         
        clientRepo.insert(c);        
        return c;
    }
    
    public Client retrieveClient(String clientId){
        //return clientRepo.findAll().get(
        return clientRepo.findById(clientId);
    }
    
    
    public List<Client> getClientList(){        
        return clientRepo.findAll();
    }
    
}
