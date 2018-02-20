/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend.models;

import com.help.qcbackend.services.CounterService;
import org.springframework.data.annotation.Id;

/**
 *
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
        this.id = String.valueOf(last_num++);
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
