/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taskmanager.mongodb.springbootmongodbtestproject.dto;

import com.taskmanager.mongodb.springbootmongodbtestproject.document.Employee;
import com.taskmanager.mongodb.springbootmongodbtestproject.document.Project;
import com.taskmanager.mongodb.springbootmongodbtestproject.document.Task;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class TaskDto {
    
    private String id;
    
    private String  start_date;
    private String  end_date;
    
    private String  start_time;
    private String  end_time;
    
    
    
    private String amount_of_work;
    
   
  
    

    public TaskDto() {
    }

    
    
    public Task toTask(TaskDto t){
    
    
        Task task = new Task();
        int months =0;
        int days = 0;
        long hours = 0; 
        if(t.getId() != null){
            
            task.setId(t.getId());
            
        }
        if(t.getStart_date()!=null && t.getEnd_date()!=null)
        {
        
            LocalDate date1 = LocalDate.parse(t.getStart_date());
            LocalDate date2 = LocalDate.parse(t.getEnd_date());

            Period p = Period.between(date1, date2);
            
            months = p.getMonths();
            days = p.getDays();
            
            task.setStart_date(date1);
            task.setEnd_date(date2);
            

        }
        if(t.getStart_time() != null && t.getEnd_time()!=null){
        
            LocalTime t1 = LocalTime.parse(t.getStart_time() );
            LocalTime t2 = LocalTime.parse( t.getEnd_time());
  
            hours = ChronoUnit.HOURS.between(t1, t2);
            
            task.setStart_time(t1);
            task.setEnd_time(t2);
            
        }
        if(months > 0){
            amount_of_work = months+" months";
        }
        if(days > 0){
            amount_of_work =amount_of_work + days+" days"; 
        }
        if(hours > 0){
            
             amount_of_work =amount_of_work + hours+" hours";
        }
        task.setAmount_of_work(amount_of_work);
        
     
        
        return task;
    
    
    }
     public TaskDto toTaskDto(Task t){
    
    
        TaskDto task = new TaskDto();
        int months =0;
        int days = 0;
        long hours = 0; 
        if(t.getId() != null){
            
            task.setId(t.getId());
            
        }
        if(t.getStart_date()!=null && t.getEnd_date()!=null)
        {
        
            
            Period p = Period.between(t.getStart_date(), t.getEnd_date());
            
            months = p.getMonths();
            days = p.getDays();
            
            task.setStart_date(t.getStart_date().toString());
            task.setEnd_date(t.getEnd_date().toString());

        }
        if(t.getStart_time() != null && t.getEnd_time()!=null){
        
            hours = ChronoUnit.HOURS.between(t.getStart_time(),  t.getEnd_time());
            
            task.setStart_time(t.getStart_time().toString());
            task.setEnd_time( t.getEnd_time().toString());
            
        }
        if(months > 0){
            amount_of_work = months+" months";
        }
        if(days > 0){
            amount_of_work =amount_of_work + days+" days"; 
        }
        if(hours > 0){
            
             amount_of_work =amount_of_work + hours+" hours";
        }
        task.setAmount_of_work(amount_of_work);
        
    
        
        
        return task;
    
    
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount_of_work() {
        return amount_of_work;
    }

    public void setAmount_of_work(String amount_of_work) {
        this.amount_of_work = amount_of_work;
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

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

 
    
    
    
}
