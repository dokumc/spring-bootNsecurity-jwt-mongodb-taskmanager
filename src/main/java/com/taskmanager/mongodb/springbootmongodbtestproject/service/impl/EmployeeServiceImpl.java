/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taskmanager.mongodb.springbootmongodbtestproject.service.impl;

import com.taskmanager.mongodb.springbootmongodbtestproject.document.AppUser;
import com.taskmanager.mongodb.springbootmongodbtestproject.document.Employee;
import com.taskmanager.mongodb.springbootmongodbtestproject.document.Role;
import com.taskmanager.mongodb.springbootmongodbtestproject.repository.AppUserRepository;
import com.taskmanager.mongodb.springbootmongodbtestproject.repository.EmployeeRepository;
import com.taskmanager.mongodb.springbootmongodbtestproject.repository.RoleRepository;
import com.taskmanager.mongodb.springbootmongodbtestproject.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl  implements EmployeeService{
    
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AppUserRepository appUserRepository;
 
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    
    public List<AppUser> getAllAppUsers() {
        return this.appUserRepository.findAll();
    }

    @Override
    public List<Role> getAllRoles() {
            return this.roleRepository.findAll();  
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();   
    }

    @Override
    public void insertRole(Role role) {
        
       if(role != null){
       
           this.roleRepository.insert(role);
       }
    }

    @Override
    public void updateRole(Role role) {
        
        if(role != null){
            
            this.roleRepository.save(role);
        }  
    }

    @Override
    public Boolean insertEmployee(Employee emp) {
       
        Boolean flag = Boolean.FALSE;
        if(emp != null && 
                !this.employeeRepository.existsByEmail(emp.getEmail() )){
          
            AppUser app = new AppUser();
            app.setUsername(emp.getEmail());
            app.setPassword(passwordEncoder.encode(emp.getEmail()));
            app.setEmail(emp.getEmail());
            app.setAuthorities("ROLE_ADMIN");
            
            this.employeeRepository.insert(emp);
            this.appUserRepository.save(app);
            
            flag = Boolean.TRUE;    
            
        } 
    
        return flag;
    
    }

    @Override
    public void updateEmployee(Employee emp) {

        if(emp != null){
            this.employeeRepository.save(emp);
        } 
    
    }


   

    @Override
    public void insertAppUser(AppUser user) {
        if(user != null){
            this.appUserRepository.insert(user);
        }      
    }

    @Override
    public void updateAppUser(AppUser user) {

     if(user != null){
            this.appUserRepository.save(user);
        }  
    }

    @Override
    public Employee getEmployeeProfile(AppUser user) {

        if(user != null && user.getEmail() !=null &&
                this.appUserRepository.existsByUsername(user.getUsername())){
            
            
            Employee emp = this.employeeRepository.findByEmail(user.getEmail());
            
            return emp;
            
            
        
        }
        
        return null;
        
    }

    @Override
    public Employee getEmployeeById(String id) {

        
        Employee emp = this.employeeRepository.findOne(id);
        return emp;
    }

    @Override
    public List<Employee> findAllByRole(String label) {

         List<Employee> list = new ArrayList<>();
        if(label !=null ){
        
            Role role = this.roleRepository.findByName(label);
            if(role != null){
                list = this.employeeRepository.findAllByRole(role);
                
            }
        }
    
        return list;
    }

}
