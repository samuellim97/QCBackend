/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend;

import com.help.qcbackend.models.Client;
import java.util.List;

/**
 *
 * @author shath
 */
public class TestDriver {
    public static void main(String[] args) {
        QCB app = new QCB();
        
        List<Client> clientList = app.getClientList();        
        System.out.println(clientList);
    }
}
