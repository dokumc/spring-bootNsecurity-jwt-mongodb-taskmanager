/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taskmanager.mongodb.springbootmongodbtestproject.service;

import com.taskmanager.mongodb.springbootmongodbtestproject.document.AppUser;
import com.taskmanager.mongodb.springbootmongodbtestproject.document.Employee;
import com.taskmanager.mongodb.springbootmongodbtestproject.document.Role;
import java.util.List;


public interface EmployeeService {
    
    
    
    public List<Role> getAllRoles();
    public List<Employee> getAllEmployees();
    public List<AppUser> getAllAppUsers();
    
    
    
    public void insertAppUser(AppUser user);
    public void updateAppUser(AppUser user);
    
   
    
    public Boolean insertEmployee(Employee emp);
    public void updateEmployee(Employee emp);
    public Employee getEmployeeProfile(AppUser user);
    
    public void insertRole(Role role);
    public void updateRole(Role role);
    
}
