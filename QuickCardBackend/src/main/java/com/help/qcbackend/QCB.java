/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend;

import com.help.qcbackend.models.Client;
import com.help.qcbackend.models.User;
import com.help.qcbackend.repo.ClientRepo;
import com.help.qcbackend.repo.QuickCardRepo;
import com.help.qcbackend.repo.UserRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

/**
 * The primary controller.
 * @author shath
 */
public class QCB {
   // ArrayList<Client> clientList;
        
    private ClientRepo clientRepo;
    private UserRepo userRepo;
    private QuickCardRepo quickCardRepo;
    
    public QCB(ClientRepo clientRepo, UserRepo ur, QuickCardRepo qr) {
        if(clientRepo == null)
            throw new IllegalArgumentException("Client repo cannot be null");
        this.clientRepo = clientRepo;
        userRepo = ur;
        quickCardRepo = qr;
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
