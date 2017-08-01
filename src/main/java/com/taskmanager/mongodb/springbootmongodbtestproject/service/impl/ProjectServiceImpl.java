/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taskmanager.mongodb.springbootmongodbtestproject.service.impl;

import com.taskmanager.mongodb.springbootmongodbtestproject.document.Employee;
import com.taskmanager.mongodb.springbootmongodbtestproject.document.Project;
import com.taskmanager.mongodb.springbootmongodbtestproject.dto.ProjectDto;
import com.taskmanager.mongodb.springbootmongodbtestproject.dto.TaskDto;
import com.taskmanager.mongodb.springbootmongodbtestproject.repository.EmployeeRepository;
import com.taskmanager.mongodb.springbootmongodbtestproject.repository.ProjectRepository;
import com.taskmanager.mongodb.springbootmongodbtestproject.repository.TaskRepository;
import com.taskmanager.mongodb.springbootmongodbtestproject.service.ProjectService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Project> getAllProjectDetails() {
        return (List<Project>) this.projectRepository.findAll();
    }

    @Override
    public List<ProjectDto> getProjectDetails() {

        ProjectDto prdto = new ProjectDto();
        List<Project> list = this.projectRepository.findAll();
        List<ProjectDto> listdto = new ArrayList<>();
        if (!list.isEmpty()) {

            for (Project pro : list) {

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

        if (proj != null && proj.getManager() != null && proj.getManager().getId() != null) {

            Project project = prdto.toProject(proj);
            Project project1 = this.projectRepository.save(project);
            ProjectDto pr = prdto.toProjectDto(project1);
            return pr;
        }
        return null;
    }

    @Override
    public List<ProjectDto> projectsAssignedToManager(String id) {
        ProjectDto prdto = new ProjectDto();
        List<Project> list = new ArrayList<>();
        List<ProjectDto> listdto = new ArrayList<>();
        if (id != null && this.employeeRepository.exists(id)) {

            Employee emp = this.employeeRepository.findOne(id);
            if (emp != null) {

                //list = this.projectRepository.findProjectAssignedToManager(emp);
//
//                if(!list.isEmpty()){
//                
//                    for(Project p: list){
//                    
//                        ProjectDto d = prdto.toProjectDto(p);
//                        listdto.add(d);
//                    
//                    }
//                }
            }

        }
        return listdto;
    }

    @Override
    public void insertNewTask(TaskDto task) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
