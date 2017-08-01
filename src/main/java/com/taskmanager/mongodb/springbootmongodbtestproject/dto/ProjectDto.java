/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taskmanager.mongodb.springbootmongodbtestproject.dto;

import com.taskmanager.mongodb.springbootmongodbtestproject.document.Employee;
import com.taskmanager.mongodb.springbootmongodbtestproject.document.Project;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class ProjectDto {
    
    
    private String id;
    private String title;
    private String start_date;
    private String end_date;
    private String created_at;
    private long duration;
    
    private Employee manager;

    public ProjectDto(){}
    
    
    public Project toProject (ProjectDto pro)
    {
        Project proj = new Project();
        
        if(pro.getId() != null){
            proj.setId(pro.getId() );
        }
        if(pro.getTitle() != null){
        
            proj.setTitle(pro.getTitle());
        }
        if(pro.getStart_date() != null && pro.getEnd_date() != null ){
            
            LocalDate date1 = LocalDate.parse(pro.getStart_date());
            LocalDate date2 = LocalDate.parse(pro.getEnd_date());

            proj.setStart_date(date1);
            proj.setEnd_date(date2);
            
           // Period p = Period.between(date1, date2);
            
            long dur = ChronoUnit.DAYS.between(date1, date2);
            proj.setDuration(dur);
             
        }
        
        if(pro.getManager() != null){
        
           proj.setManager(pro.getManager());
        }
        
        return proj;
    
    
    }
  public ProjectDto toProjectDto (Project pro)
    {
        ProjectDto proj = new ProjectDto();
        
        if(pro.getId() != null){
            proj.setId(pro.getId() );
        }
        if(pro.getTitle() != null){
        
            proj.setTitle(pro.getTitle());
        }
        if(pro.getStart_date() != null ){
            
            proj.setStart_date(pro.getStart_date().toString());
          
             
        }
         if(pro.getEnd_date() != null ){
            
            proj.setEnd_date(pro.getEnd_date().toString());
            
             
        }
        if(pro.getCreated_at() != null){
        
            proj.setCreated_at(pro.getCreated_at().toString());
        }
        if(pro.getManager() != null){
        
           proj.setManager(pro.getManager());
        }
        proj.setDuration(pro.getDuration());
        
        return proj;
    
    
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
}
