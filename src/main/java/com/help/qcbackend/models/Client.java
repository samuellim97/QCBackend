/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend.models;

import com.help.qcbackend.database.DatabaseHandler;
import com.help.qcbackend.services.CounterService;
import org.springframework.data.annotation.Id;

/**
 * This class is used to test initial system.
 * TODO: Remove this class from the project.
 * @author shath
 */
public class Client { 
    private static int last_num = 0;
        
    @Id   
    private String id;
    
    private String name;
    private double balance;

    public Client() {
       this("Un-named", 0.0);
    }
    
    
    public Client(String name, double balance) {      
        CounterService cs = new CounterService();
        cs.setMongo(DatabaseHandler.getInstance().getDb());
        
        this.setId( String.valueOf(cs.getNextSequence("client")));
        
        this.name = name;
        this.balance = balance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
    
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", balance=" + balance + '}';
    }       
        
}
