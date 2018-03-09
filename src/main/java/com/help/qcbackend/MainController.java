/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.CommandLineRunner;

import com.help.qcbackend.models.Client;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shath
 */
@RestController
@SpringBootApplication
public class MainController implements CommandLineRunner {
    private QCB controller;
    ;
    
    @Override
    public void run(String... strings) throws Exception {
        controller = new QCB();               
    }
    
    @RequestMapping("/")    
    String home() {
        return "QuickCard Back-end is ready.";
    }
    
    @RequestMapping("/login")    
    String home2(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session  = request.getSession();
        boolean logged_in = false;
        try{
        logged_in = (boolean) session.getAttribute("logged_in");
        }catch(Exception ex){
            
        }
        if(logged_in)
            return "logged in";        
        else
            request.getSession().setAttribute("logged_in", true);        
        return "not logged in";
    }
    
    
    
    @RequestMapping("/logout")    
    String logout(HttpServletRequest request,
            HttpServletResponse response) {
        HttpSession session  = request.getSession();
        boolean logged_in = false;
        try{
        logged_in = (boolean) session.getAttribute("logged_in");
        
        }catch(Exception ex){
            
        }
        if(logged_in){            
            session.invalidate();
            return "Logged out."; 
        }
        return "not logged in";
    }
    
    @RequestMapping(method = RequestMethod.DELETE, path = "/clients")
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    @ResponseBody
    boolean deleteAll(){
        controller.deleteAllClients();
        return true;
    }
    
    @RequestMapping(method = RequestMethod.PUT, path = "/client")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody            
    boolean createClient(@RequestParam(value="name") String name){ 
        
        Client c = controller.addNewClient(
                controller.new ModelCreator()
                        .createClient(name)        
        );
        return true;
    }
    
    @RequestMapping("/clients/{clientId}")    
    @ResponseBody
    public Client findClient(@PathVariable(value = "clientId") String clientId, HttpServletResponse response){ 
                
        Client c = controller.retrieveClient(clientId);
        if(c == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;            
        }
        
        return c;
    }
    

    @RequestMapping(path = "/clients", method = RequestMethod.GET)        
    @ResponseBody
    List<Client> listAll(){
        //Map<String, String> ret = new HashMap<>();
        //Integer i = 0;
        return controller.getClientList();        
    }
    

    public static void main(String[] args) {
        try{
            SpringApplication.run(MainController.class, args);
        }catch(Exception ex){
            System.err.println(ex);
        }
    }    
}
