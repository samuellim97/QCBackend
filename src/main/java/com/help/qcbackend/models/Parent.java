/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend.models;

import com.help.qcbackend.database.DatabaseHandler;
import com.help.qcbackend.services.CounterService;
import java.util.List;
import org.springframework.data.annotation.Id;

/**
 *
 * @author shath
 */
public class Parent extends User{
    @Id
    private String id;
    
    private String name;
    private String bankAccount;
    private List<QuickCard> ownedCards;
    
    public Parent(){	                
        CounterService cs = new CounterService();
        cs.setMongo(DatabaseHandler.getInstance().getDb());        
        this.setId( String.valueOf(cs.getNextSequence("parent")));
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
    
    public Parent(String name, String accountNumber){    
        this();
	setName(name);
	setBankAccount(accountNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<QuickCard> getOwnedCards() {
        return ownedCards;
    }
   
    public boolean addCard(QuickCard card){
        return ownedCards.add(card);
    }
    
    public String getEmail(){
        return this.getLoginId();
    }
    
    
    public void setEmail(String email){
        this.setLoginId(email);
    }

    @Override
    public String toString() {
        return "Parent with name "+getName()+" and id: "+ getId();
    }
    
    
}
