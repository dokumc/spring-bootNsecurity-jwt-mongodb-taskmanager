# Task Manager  README

## About
Demo using tools:

```
	1. Spring Boot
	2. Spring Security
	3. JWT
	4. MongoDB (v3.4.6)
	5. Maven  
	6. Java (1.8)
```

Requirements / Rolls:
 
Project Assistance can create. Project data: Title, start / end date of project, Duration,  Project Manager
 
Project Manager can assign / unassign Employees to Projects. Assignment data: Start / end of engagement, max. amount of work, Employee
 
Employee can record his time sheets for projects. Time sheet data: Project, start / end time, hours, description
 

##  Usage

Start the application with the Spring Boot maven plugin (`mvn spring-boot:run`). The application is
running at [http://localhost:8095](http://localhost:8095).

STEP 1: Authentication from HTTP client to test web app (I used postman):

![Authentication screenshot from POSTMAN ](etc/s1.png?raw=true "Screenshot JWT Spring Security Demo")

STEP 2: Use the generated authentication token in Headers as below:

![TOKEN screenshot from POSTMAN ](etc/s2.png?raw=true "Authentication Token with key=X-Auth-Token, and value=the token generated")


### MongoDB connection is specified in file
```
application.properties

```

### Generating password hash for new users

I'm using [bcrypt](https://en.wikipedia.org/wiki/Bcrypt) to encode passwords. Your can generate your hashes with this simple tool: [Bcrypt Generator](https://www.bcrypt-generator.com)

## External Resources & Tutorials

### Spring-Security, JWT

```
1. Stephan Zerhusen 
https://github.com/szerhusenBC/jwt-spring-security-demo

```