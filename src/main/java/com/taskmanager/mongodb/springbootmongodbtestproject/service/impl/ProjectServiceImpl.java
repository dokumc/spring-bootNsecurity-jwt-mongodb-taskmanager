/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taskmanager.mongodb.springbootmongodbtestproject.service.impl;

import com.taskmanager.mongodb.springbootmongodbtestproject.document.Project;
import com.taskmanager.mongodb.springbootmongodbtestproject.dto.ProjectDto;
import com.taskmanager.mongodb.springbootmongodbtestproject.repository.ProjectRepository;
import com.taskmanager.mongodb.springbootmongodbtestproject.service.ProjectService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;
    
   
    @Override
    public List<Project> getAllProjectDetails() {
        return (List<Project> )this.projectRepository.findAll();
    }

     @Override
    public List<ProjectDto> getProjectDetails() {
        
         ProjectDto prdto = new ProjectDto();
        List<Project> list = this.projectRepository.findAll();
        List<ProjectDto> listdto = new ArrayList<>(); 
        if(!list.isEmpty()){
        
            for(Project pro: list){
            
                ProjectDto dtpro = prdto.toProjectDto(pro);
                listdto.add(dtpro);
            
            }
        }
        return listdto;
    }

    @Override
    public void insertProjectDetails(ProjectDto proj) {
        ProjectDto prdto = new ProjectDto();
        LocalDateTime dt = LocalDateTime.now();
        
        Project project = prdto.toProject(proj);
        project.setCreated_at(dt);
        this.projectRepository.insert(project);
    
    }

    @Override
    public ProjectDto updateProjectDetails(ProjectDto proj) {
        ProjectDto prdto = new ProjectDto();
        LocalDateTime dt = LocalDateTime.now();
        
        if(proj!=null && proj.getManager()!=null && proj.getManager().getId()!=null){
            
            Project project = prdto.toProject(proj);
            Project project1 = this.projectRepository.save(project);
            ProjectDto pr = prdto.toProjectDto(project1);
            return pr;
        }
        return null;
    }
    
}
