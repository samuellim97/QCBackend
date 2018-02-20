/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend.models;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;

/**
 *
 * @author shath
 */
public class User {
    @Id  
    private int userId;    
    
    private String email;
    private String name;
    private ArrayList<QuickCard> quickCards;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }
    
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<QuickCard> getQuickCards() {
        return quickCards;
    }

    public void setQuickCards(ArrayList<QuickCard> quickCards) {
        this.quickCards = quickCards;
    }
    
    
}
