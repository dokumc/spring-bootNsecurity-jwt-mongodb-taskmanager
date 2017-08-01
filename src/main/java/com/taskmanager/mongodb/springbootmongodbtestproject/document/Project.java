/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taskmanager.mongodb.springbootmongodbtestproject.document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Project {
    
    
    @Id
    private String id;
    private String title;
    private LocalDate start_date;
    private LocalDate end_date;
    private long duration;
    
    private Employee manager;
    private LocalDateTime created_at;

    
    
    public Project(){};
    public Project(String id, String title, LocalDateTime created_at) {
        this.id = id;
        this.title = title;
        this.created_at = created_at;
    }

     public Project(String title, LocalDateTime created_at) {
       
        this.title = title;
        this.created_at = created_at;
    }

    public Project(String id, String title, LocalDate start_date, LocalDate end_date, long duration, Employee manager, LocalDateTime created_at) {
        this.id = id;
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
        this.duration = duration;
        this.manager = manager;
        this.created_at = created_at;
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
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

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
    
    
    
}
