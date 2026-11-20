# Employee Payroll App

A Spring Boot REST API application developed as part of the BridgeLabz Spring Boot training program. The project demonstrates the development of an Employee Payroll application using Spring Boot, REST APIs, DTO, Model, and Service Layer architecture.

---

## 1. Project Overview

The Employee Payroll App is a backend application designed to handle employee payroll information through RESTful APIs.

The application is developed incrementally using Use Cases (UCs), beginning with Spring Boot project setup and REST controller implementation, followed by DTO, Model, and Service Layer integration.

The project follows a layered architecture to separate request handling and business logic.

### Objectives

- Create a Spring Boot application using Spring Initializr.
- Configure MySQL database connectivity.
- Develop REST APIs using Spring Web.
- Demonstrate HTTP methods such as GET, POST, PUT, and DELETE.
- Introduce DTO and Model classes.
- Implement a separate Service Layer.
- Write JUnit test cases for application components.
- Test REST endpoints using Postman.

---

## 2. Technology Stack

| Technology | Purpose |
|---|---|
| Java 22 | Programming language |
| Spring Boot 4.1.2 | Backend application framework |
| Spring Web | REST API development |
| Spring Data JPA | Database integration dependency |
| MySQL | Relational database |
| MySQL Connector/J | MySQL connectivity |
| Maven | Dependency and project management |
| JUnit 5 | Unit testing |
| Spring Test / MockMvc | Controller testing |
| Postman | REST API testing |
| IntelliJ IDEA | Development environment |
| Git & GitHub | Version control |

---

## 3. Project Configuration

### Spring Initializr Details

| Configuration | Value |
|---|---|
| Project | Maven |
| Language | Java |
| Group | com.bridgelabz |
| Artifact | EmployeePayrollApp |
| Name | EmployeePayrollApp |
| Package Name | com.bridgelabz.employeepayrollapp |
| Packaging | Jar |

### Dependencies

- Spring Web
- Spring Boot DevTools
- Validation
- MySQL Driver
- Spring Data JPA
- Spring Boot Starter Test

---

## 4. Database Configuration

The project uses MySQL for database connectivity configuration.

### Database Name

```
employeepayroll_service
```

### Database Creation

```sql
CREATE DATABASE employeepayroll_service;

USE employeepayroll_service;

SHOW DATABASES;
```

### application.properties

```properties
# MySQL JDBC Driver
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Database URL
spring.datasource.url=jdbc:mysql://localhost:3306/employeepayroll_service

# Database Credentials
spring.datasource.username=root
spring.datasource.password=root

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update

# Display SQL Queries
spring.jpa.show-sql=true
```

---

## 5. Project Structure

```
EmployeePayrollApp
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── bridgelabz
│   │   │           └── employeepayrollapp
│   │   │               │
│   │   │               ├── EmployeePayrollAppApplication.java
│   │   │               │
│   │   │               ├── controller
│   │   │               │   └── EmployeePayrollController.java
│   │   │               │
│   │   │               ├── dto
│   │   │               │   └── EmployeePayrollDTO.java
│   │   │               │
│   │   │               ├── model
│   │   │               │   └── EmployeePayrollModel.java
│   │   │               │
│   │   │               └── service
│   │   │                   └── EmployeePayrollService.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│       └── java
│           └── com
│               └── bridgelabz
│                   └── employeepayrollapp
│                       ├── controller
│                       │   └── EmployeePayrollControllerTest.java
│                       │
│                       ├── dto
│                       │   └── EmployeePayrollDTOTest.java
│                       │
│                       ├── model
│                       │   └── EmployeePayrollModelTest.java
│                       │
│                       └── service
│                           └── EmployeePayrollServiceTest.java
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

## 6. Use Case Implementation

### UC1 – Create Employee Payroll Spring Project

**Objective:** Set up the Employee Payroll Spring Boot application.

**Implementation:**

- Created the project using Spring Initializr.
- Configured Maven and required dependencies.
- Established the application package structure.
- Configured MySQL database connectivity.
- Created the `employeepayroll_service` database.
- Successfully started the Spring Boot application.

### UC2 – Create REST Controller

**Objective:** Develop REST endpoints to demonstrate different HTTP methods.

Implemented `EmployeePayrollController.java`.

The controller exposes the following endpoints:

- **GET** – Check service availability.
- **GET by ID** – Receive an employee ID.
- **POST** – Receive employee data.
- **PUT** – Receive updated employee data.
- **DELETE** – Receive an employee ID for deletion.

Postman was used to verify the HTTP requests and responses.

### UC3 – Introduce DTO and Model

**Objective:** Separate incoming employee data from the application's employee model.

**Implemented:**

`EmployeePayrollDTO`

- Receives employee information from client requests.
- Contains name and salary.
- Includes constructors, getters, and setters.

`EmployeePayrollModel`

- Represents employee payroll information.
- Contains name and salary.
- Includes constructors, getters, and setters.

The Controller uses DTO objects to receive request data and Model objects to return employee information.

### UC4 – Introduce Services Layer

**Objective:** Separate business logic from REST request handling.

Implemented `EmployeePayrollService.java`.

**Responsibilities:**

- Retrieve sample employee model data.
- Convert DTO information into Model objects.
- Handle employee creation requests.
- Handle employee update requests.
- Handle employee deletion request responses.

The Controller communicates with the Service Layer through Spring Dependency Injection using `@Autowired` constructor injection.

This improves separation of concerns and makes the application easier to maintain and extend.

### UC5 – Store Employee Payroll Data in Memory Using List

This is the next planned implementation stage.

The objective is to maintain employee payroll records using an in-memory Java `List` rather than introducing database persistence for this use case.

---

## 7. REST API Endpoints

**Base URL:**

```
http://localhost:8080
```

| HTTP Method | Endpoint | Description | Expected Status |
|---|---|---|---|
| GET | `/employeepayrollservice/` | Check service availability | 200 OK |
| GET | `/employeepayrollservice/get/{id}` | Retrieve sample employee model | 200 OK |
| POST | `/employeepayrollservice/create` | Receive employee details | 201 Created |
| PUT | `/employeepayrollservice/update` | Receive updated employee details | 200 OK |
| DELETE | `/employeepayrollservice/delete/{id}` | Receive delete request | 200 OK |

### Sample POST Request

```
POST /employeepayrollservice/create
```

**Request Body:**

```json
{
    "name": "Lisa",
    "salary": 2000
}
```

**Expected Response:**

```json
{
    "name": "Lisa",
    "salary": 2000.0
}
```

### Sample PUT Request

```
PUT /employeepayrollservice/update
```

**Request Body:**

```json
{
    "name": "Lisa",
    "salary": 2500
}
```

**Expected Response:**

```json
{
    "name": "Lisa",
    "salary": 2500.0
}
```

---

## 8. JUnit Testing

JUnit 5 is used to test the individual components of the application.

### Test Classes

| Test Class | Testing Responsibility |
|---|---|
| `EmployeePayrollDTOTest` | DTO constructors, getters and setters |
| `EmployeePayrollModelTest` | Model constructors, getters and setters |
| `EmployeePayrollServiceTest` | Service Layer methods |
| `EmployeePayrollControllerTest` | REST API endpoints |

### Testing Coverage

**DTO Tests**

- Parameterized constructor.
- Default constructor and setters.

**Model Tests**

- Parameterized constructor.
- Default constructor and setters.

**Service Tests**

- Retrieve employee model.
- Add employee payroll data.
- Update employee payroll data.
- Handle delete request.

**Controller Tests**

- GET service endpoint.
- GET employee by ID.
- POST employee data.
- PUT employee data.
- DELETE employee request.

Controller tests use MockMvc to simulate HTTP requests without requiring a running server.

### Run Tests

**Using IntelliJ IDEA:**

1. Open the `src/test/java` directory.
2. Right-click the test package or individual test class.
3. Select **Run Tests**.
4. Verify the test results.

**Using Maven:**

```bash
.\mvnw.cmd test
```

---

## 9. Running the Application

### Prerequisites

- Java JDK 22
- IntelliJ IDEA
- MySQL Server
- MySQL Workbench
- Maven Wrapper

### Steps

**Step 1:** Clone the repository.

```bash
git clone https://github.com/Utakarsh-Jain/EmployeePayrollService.git
```

**Step 2:** Navigate to the project directory.

```bash
cd EmployeePayrollApp
```

**Step 3:** Configure MySQL credentials in `application.properties`.

**Step 4:** Make sure the MySQL server is running and the database exists.

**Step 5:** Build the project.

```bash
.\mvnw.cmd clean install
```

**Step 6:** Start the Spring Boot application.

```bash
.\mvnw.cmd spring-boot:run
```

The application starts on:

```
http://localhost:8080
```

**Step 7:** Use Postman to test the REST API endpoints.

---

## 10. Version Control – Git Workflow

Git is used to manage the development process through separate feature branches.

The project follows a feature-branch workflow.

### Main Branches

- `main` – Main project branch.
- `develop` – Development integration branch.
- `feature/*` – Individual feature implementation branches.

### Branch Naming Convention

```
feature/Section1-UC1-Setup
feature/Section1-UC2-RestController
feature/Section2-UC1-DTO
feature/Section2-UC2-ServiceLayer
feature/Section2-UC3-MemoryInList
```

### Common Git Commands

Create a feature branch:

```bash
git switch develop
git pull origin develop
git switch -c feature/your-feature-name
```

Stage changes:

```bash
git add .
```

Commit changes:

```bash
git commit -m "[Utakarsh Jain] : Implemented feature"
```

Push the feature branch:

```bash
git push -u origin feature/your-feature-name
```

After completing a feature, merge it into `develop` through the agreed integration workflow.

---

## 11. Current Project Scope

The project is being developed incrementally according to the Employee Payroll App use cases.

The implemented stages establish:

- Spring Boot application setup.
- MySQL connectivity configuration.
- REST Controller implementation.
- DTO and Model separation.
- Service Layer integration.
- JUnit testing.
- Postman API testing.

At the Service Layer stage, employee data is represented through Model objects, but actual record storage and persistence are not yet implemented. The in-memory `List` functionality belongs to UC5.

---

## 12. Author

**Manthan Hanchate**

BridgeLabz Spring Boot Training Program

- **Project:** Employee Payroll App
- **Repository:** EmployeePayrollService

---

## Conclusion

The Employee Payroll App project demonstrates the step-by-step development of a Spring Boot REST application using a layered architecture.

Through the implementation of REST Controllers, DTOs, Models, and Services, the project establishes a clean separation of responsibilities.

JUnit and Postman are used to verify application behavior, while Git and GitHub support structured version control and feature-wise development.
