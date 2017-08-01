/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taskmanager.mongodb.springbootmongodbtestproject.rest;

import com.taskmanager.mongodb.springbootmongodbtestproject.document.Project;
import com.taskmanager.mongodb.springbootmongodbtestproject.dto.ProjectDto;
import com.taskmanager.mongodb.springbootmongodbtestproject.service.ProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("project")
public class ProjectController {
    
    
    
    @Autowired
    private ProjectService projService;
    
    @GetMapping("/all")
    public List<ProjectDto> getProjectDetails(){
    
        return this.projService.getProjectDetails();
    }

    @PutMapping("/save")
    public void insertProjectDetails(@RequestBody ProjectDto proj){
    
        this.projService.insertProjectDetails(proj);
    }
    @PostMapping("/update")
    public ProjectDto updateProjectDetail(@RequestBody ProjectDto proj){
    
        ProjectDto newproj = this.projService.updateProjectDetails(proj);
        return newproj;
    }
    @PostMapping("/byrole")
    public List<ProjectDto> updateProjectDetail(@RequestBody String id){
    
      
        List<ProjectDto> list = this.projService.projectsAssignedToManager(id);
        return list;
    }
}
