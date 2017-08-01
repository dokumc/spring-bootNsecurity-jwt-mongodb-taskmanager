package com.taskmanager.mongodb.springbootmongodbtestproject.config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.taskmanager.mongodb.springbootmongodbtestproject.document.Project;
import com.taskmanager.mongodb.springbootmongodbtestproject.repository.AppUserRepository;
import com.taskmanager.mongodb.springbootmongodbtestproject.repository.ProjectRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories (basePackageClasses=AppUserRepository.class)
@Configuration
public class MongoDBConfig {
    
    @Autowired
    private ProjectRepository projectRepository;


    @Bean
    CommandLineRunner commandLineRunner (ProjectRepository projectRepository){
    
    
        return (String... strings) -> {
            
         //  this.projectRepository.save(new Project( "admin", LocalDateTime.now()));

        };
    }
    
}
