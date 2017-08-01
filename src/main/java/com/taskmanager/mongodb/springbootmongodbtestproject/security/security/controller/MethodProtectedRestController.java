package com.taskmanager.mongodb.springbootmongodbtestproject.security.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
 class MethodProtectedRestController {

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public boolean getProtectedGreeting() {
    	 return true;
    }
    
}
@RestController
@RequestMapping("manager")
 class ManagerProtectedRestController {

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public boolean getProtectedGreeting() {
    	 return true;
    }
    
}
@RestController
@RequestMapping("employee")
 class EmployeeProtectedRestController {

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public boolean getProtectedGreeting() {
    	 return true;
    }
    
}
