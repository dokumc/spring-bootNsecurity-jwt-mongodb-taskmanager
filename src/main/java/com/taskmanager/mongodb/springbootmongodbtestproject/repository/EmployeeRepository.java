/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taskmanager.mongodb.springbootmongodbtestproject.repository;

import com.taskmanager.mongodb.springbootmongodbtestproject.document.Employee;
import com.taskmanager.mongodb.springbootmongodbtestproject.document.Role;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
 
    public Employee findByEmail(String email);
    public List<Employee> findAllByRole(Role role);
    public boolean existsByEmail(String email);
}
