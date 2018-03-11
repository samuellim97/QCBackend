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
 * A Smart card with unique id.
 * @author shath
 */
public class QuickCard {
    @Id
    private String id;
    
    private Parent owner;
    private String uid;
    
    
    /**
     *No args constructor
     */
    public QuickCard() {        
        CounterService cs = new CounterService();
        cs.setMongo(DatabaseHandler.getInstance().getDb());        
        this.setId( String.valueOf(cs.getNextSequence("QuickCard")));
    }
    
    /**
     * Create card without owner
     * @param uid 
     */
    public QuickCard(String uid) {        
        this.uid = uid;
    }

    /**
     * Create card with owner.
     * @param owner
     * @param uid 
     */
    public QuickCard(Parent owner, String uid) {
        this.owner = owner;
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
   

    public Parent getOwner() {
        return owner;
    }

    public void setOwner(Parent owner) {
        this.owner = owner;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "QuickCard{ owner=" + owner + ", uid=" + uid + '}';
    }
    
    
    
}
