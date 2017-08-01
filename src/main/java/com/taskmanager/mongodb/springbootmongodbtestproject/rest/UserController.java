package com.taskmanager.mongodb.springbootmongodbtestproject.rest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.taskmanager.mongodb.springbootmongodbtestproject.document.AppUser;
import com.taskmanager.mongodb.springbootmongodbtestproject.document.Employee;
import com.taskmanager.mongodb.springbootmongodbtestproject.document.Role;
import com.taskmanager.mongodb.springbootmongodbtestproject.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("rest")
public class UserController {
 
    @Autowired
    private EmployeeService employeeService;
 
   
    /******************************CRUD USER DOCUMENT**************************/

      @GetMapping("/user/all")
    public List<AppUser> getAllAppUsers(){
    
        return this.employeeService.getAllAppUsers();
    }
     @PutMapping("/user/save")
    public void insertAppUser(@RequestBody AppUser user){
    
    
        this.employeeService.insertAppUser(user);
    }
    @PostMapping("/user/update")
    public void updateAppUser(@RequestBody AppUser user){
    
    
        this.employeeService.updateAppUser(user);
    }
   
    /******************************CRUD ROLE DOCUMENT**************************/

    @GetMapping("/role/all")
    public List<Role> getAllRoles(){
    
        return this.employeeService.getAllRoles();
    }
    
    @PutMapping("/role/save")
    public void insertRole(@RequestBody Role role){
    
    
        this.employeeService.insertRole(role);
    }
    @PostMapping("/role/update")
    public void updateRole(@RequestBody Role role){
    
    
        this.employeeService.updateRole(role);
    }
    
    /******************************CRUD ROLE EMPLOYEE**************************/

    @GetMapping("/employee/all")
    public List<Employee> getAllEmployees(){
    
        return this.employeeService.getAllEmployees();
    }
    
     @PutMapping("/employee/save")
    public Boolean insertEmployee(@RequestBody Employee emp){
    
       Boolean flag = this.employeeService.insertEmployee(emp);
    
       return flag;
    }
    @PostMapping("/employee/update")
    public void updateEmployee(@RequestBody Employee emp){
    
    
        this.employeeService.updateEmployee(emp);
    }
    @PostMapping("/employee/getProfile")
    public Employee getEmployeeProfile(@RequestBody AppUser user){
    
    
        Employee emp = this.employeeService.getEmployeeProfile(user);
        return emp;
        
    }
    
}
