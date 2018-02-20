/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.CommandLineRunner;

import com.help.qcbackend.models.Client;
import com.help.qcbackend.models.QuickCard;
import com.help.qcbackend.repo.ClientRepo;
import com.help.qcbackend.repo.QuickCardRepo;
import com.help.qcbackend.repo.UserRepo;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

class Person{
    static int count=0;
    private int id=0;
    private String name="Unknown";

    public Person() {
        count++;
    }            
    
    public Person(int id, String name){
        this();
        setName(name);
        setId(id);
    }

    public void setId(int id) {
        this.id = id;        
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

 }

/**
 *
 * @author shath
 */
@Controller
@SpringBootApplication
public class MainController implements CommandLineRunner {
    private QCB controller;
    
    @Autowired
    private ClientRepo repo;
    
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private QuickCardRepo quickCardRepo;
    
    @Override
    public void run(String... strings) throws Exception {
        controller = new QCB(repo, userRepo, quickCardRepo);               
    }
    
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "QuickCard Back-end is ready.";
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
   // @ExceptionHandler(DataIntegrityViolationException.class)
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
