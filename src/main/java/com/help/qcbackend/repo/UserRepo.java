/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend.repo;

import com.help.qcbackend.models.TestUser;
import java.io.Serializable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author shath
 */
public interface UserRepo extends MongoRepository<TestUser, String>{
    public TestUser findByUserId(int id);
    public TestUser findByEmail(String email);
}
