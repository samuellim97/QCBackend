/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend.models;

/**
 * A User that can log in to the system.
 * todo: Give a better name to this class.
 * @author shath
 */
public class User {        
    private String loginId;
    private String passwordHash;

    User(){
    }

    User(String loginId, String passwordHash){
	setLoginId(loginId);
	setPassword(passwordHash);
    }
    
    
    public boolean validatePassword(String password){
	
	return true;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    

    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Create and store a password hash given a password.
     * @param password 
     */
    public void setPassword(String password) {
        this.passwordHash = passwordHash;
    }
    
    
}
