/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend;

import com.help.qcbackend.database.DatabaseHandler;
import com.help.qcbackend.models.Client;
import com.help.qcbackend.models.Parent;
import com.help.qcbackend.models.TestUser;
import com.help.qcbackend.models.QuickCard;
import com.help.qcbackend.repo.ClientRepo;
import com.help.qcbackend.repo.ParentRepo;
import com.help.qcbackend.repo.QuickCardRepo;
import com.help.qcbackend.repo.UserRepo;
import java.util.List;

/**
 * The primary controller.
 * @author shath
 */
public class QCB {
    DatabaseHandler db;
    
    private ClientRepo clientRepo;
    private UserRepo userRepo;
    private ParentRepo parentRepo;
    private QuickCardRepo quickCardRepo;
    
    public List<QuickCard> getAvailableQuickCards(){        
        return quickCardRepo.findAll();
    }
    
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
        parentRepo = (ParentRepo) db.getRepositoryObject(ParentRepo.class);
    }
    
    
    /**
     * Deletes all client objects
     */
    void deleteAllClients() {
        clientRepo.deleteAll();
        
    }

    void createCard(String uid) {
       quickCardRepo.save(new QuickCard(uid));
    }

    /**
     * Adds a new parent and returns the parent
     * @param name
     * @param bankAccount
     * @return 
     */
    public Parent addNewParent(String name, String bankAccount) {
        
        return parentRepo.save( new Parent(name, bankAccount) );
    }

    String generatePassword(Parent parent) {
        String password = "123";
        parent.setPassword(password);
        return password;
    }

    Iterable<Parent> getParents() {
        return parentRepo.findAll();
    }

    Parent findParentById(String id) {        
        return parentRepo.findById(id);
    }

    QuickCard getCard(String uid) {
        return quickCardRepo.findByUid(uid);
    }

    void addCardToParent(Parent parent, QuickCard card) {
        card.setOwner(parent);
        quickCardRepo.save(card);
    }

 
    public class ModelCreator{
        public Client createClient(String name){
            return new Client(name, 0.0);
        }
    };
    
    public void addUser(String name, String email){
        userRepo.insert(new TestUser(email, name));
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
        return clientRepo.findById(clientId);
    }
    
    
    public List<Client> getClientList(){        
        return clientRepo.findAll();
    }
    
}
