/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend.models;

import org.springframework.data.annotation.Id;

/**
 *
 * @author shath
 */
public class QuickCard {
    @Id
    private int id;
    
    private User owner;
    private String uid;

    public QuickCard(String uid) {
        this.uid = uid;
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    
    
}
