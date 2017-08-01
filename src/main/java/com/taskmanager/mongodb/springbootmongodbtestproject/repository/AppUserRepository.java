package com.taskmanager.mongodb.springbootmongodbtestproject.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.taskmanager.mongodb.springbootmongodbtestproject.document.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRepository  extends MongoRepository<AppUser, String>{
    
    
    public AppUser findByUsername(String username);
    public AppUser findByEmail(String email);
    public boolean existsByUsername(String username);

}
