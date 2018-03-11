/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend;

import com.help.qcbackend.models.Client;
import com.help.qcbackend.models.Parent;
import com.help.qcbackend.models.QuickCard;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author shath
 */
public class TestDriver {
    private static Scanner scn = new Scanner(System.in);
    private static QCB app;
    private static void displayMenu(){
        System.out.println("1- Add quickcard");
        System.out.println("2- List available quickcards");
        System.out.println("3- Add parent to database");
        System.out.println("4- List parents");
        System.out.println("5- Link card and parent");
        System.out.println("0- Quit");
    }    
    
    public static void main(String[] args) {
        app = new QCB();
        
        List<Client> clientList = app.getClientList();  
        
        boolean quit = false;
        do {
            displayMenu();
            try{
            System.out.print("Enter choice:");
            char choice = scn.nextLine().charAt(0);
            switch (choice) {
                case '0':
                    quit = true;
                    break;
                case '1':
                    addNewCard();
                    break;
                case '2':
                    printAvailableCards();
                    break;
                case '3':
                    addCustomer();                    
                    break;
                case '4':
                    listParents();
                    break;
                case '5':
                    addCardToParent();
                    break;
                default:
                    break;
            }
            }catch(StringIndexOutOfBoundsException ex){
                System.out.println("Invalid choice.");
            }
        } while (!quit);
        System.out.println(clientList);
    }

    private static void addNewCard() {
        System.out.print("Enter uid: ");
        String uid = scn.nextLine();
        app.createCard(uid);
        System.out.println("Successfully added!");
    }

    private static void printAvailableCards() {
        List<QuickCard> qc = app.getAvailableQuickCards();           
        for(QuickCard card: qc){
            System.out.println(qc);
        }
    }

    private static void addCustomer() {
        System.out.print("Enter name:");
        String name = scn.nextLine();
        System.out.print("Enter bankAccount:");
        String bankAccount = scn.nextLine();
        Parent parent =  app.addNewParent(name, bankAccount);      
        String password = app.generatePassword(parent);
        System.out.println("New parent "+ parent + " created successfully.");
        System.out.println("Password for the parent is "+ password);
    }
    
    
    
    private static void addCardToParent(){
        listParents();
        
        System.out.print("Enter parent id:");
        String id = scn.nextLine();
        Parent parent = app.findParentById(id);
        System.out.println(parent);
        if(parent != null){
            System.out.println(parent + " found");
            printAvailableCards();        
            
            System.out.print("Enter card uid:");
            String uid = scn.nextLine();
            QuickCard card = app.getCard(uid);
            if(card != null){
                app.addCardToParent(parent, card);                
                System.out.println("Card Linked: "+ card);                
            }else{
                System.out.println("Card not found");
            }
        }else{
            System.out.println("Parent with id "+id+" not found");
        }
    }
    
    private static void listParents(){
        for(Parent p: app.getParents()){
            System.out.println(p);
        }
    }
}
