/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taskmanager.mongodb.springbootmongodbtestproject.service;

import com.taskmanager.mongodb.springbootmongodbtestproject.document.Project;
import com.taskmanager.mongodb.springbootmongodbtestproject.dto.ProjectDto;
import java.util.List;


public interface ProjectService {
    
    
        public List<Project> getAllProjectDetails();
         public List<ProjectDto> getProjectDetails() ;
        public void insertProjectDetails(ProjectDto proj);
        public ProjectDto updateProjectDetails(ProjectDto proj);
}
