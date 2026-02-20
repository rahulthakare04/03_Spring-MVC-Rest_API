# 🌐 Spring Boot Web MVC & REST API

[![Visitor Badge](https://visitor-badge.laobi.icu/badge?page_id=rahulthakare04.03_Spring-MVC-Rest_API)](https://visitor-badge.laobi.icu/badge?page_id=rahulthakare04.03_Spring-MVC-Rest_API)
[![GitHub issues](https://img.shields.io/github/issues/rahulthakare04/03_Spring-MVC-Rest_API?style=flat-square)](https://github.com/rahulthakare04/03_Spring-MVC-Rest_API/issues)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring MVC](https://img.shields.io/badge/Spring%20MVC-6DB33F?style=flat-square&logo=spring&logoColor=white)](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
[![JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=flat-square&logo=spring&logoColor=white)](https://spring.io/projects/spring-data-jpa)
[![H2 Database](https://img.shields.io/badge/H2%20Database-0000BB?style=flat-square&logo=h2&logoColor=white)](https://www.h2database.com/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![Java](https://img.shields.io/badge/Java%2021-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-Proprietary-red?style=flat-square)](#-license)

*"REST APIs are the universal language of modern web applications - master them, and you master the web."*

---

## 📖 Overview

A comprehensive **Spring Boot Web MVC & RESTful API** project that demonstrates professional API development practices. This project covers everything from basic MVC architecture to advanced topics like custom validation annotations, global exception handling, and structured API responses. Built with industry-standard patterns and backed by an in-memory H2 database for seamless CRUD operations across **Employee** and **Department** resources.

### 🎯 What You'll Learn

* 🏗️ **MVC Architecture** - Understanding Model-View-Controller design pattern
* 🎮 **RESTful Controllers** - Building robust API endpoints with proper HTTP methods
* 💾 **JPA & Hibernate** - Database persistence with Spring Data JPA
* 🔧 **Service Layer** - Implementing clean business logic separation
* ✅ **Input Validation** - Using built-in and custom validation annotations
* 🚨 **Exception Handling** - Global error handling with @ControllerAdvice
* 📦 **DTO Pattern** - Structuring clean data transfer between layers
* 🗄️ **H2 Database** - In-memory database for rapid development

---

## ✨ Features

* 🌐 **Complete REST API** - Full CRUD operations with GET, POST, PUT, PATCH, and DELETE
* 🎯 **Path Variables & Request Params** - Multiple ways to accept client input
* 📝 **DTO Pattern** - Clean data transfer between layers (`EmployeeDTO`, `DepartmentDTO`)
* 🔐 **Custom Validators** - `@PasswordValidation`, `@PrimeNumberValidation`, `@EmployeeRoleValidation`
* 🛡️ **Global Exception Handling** - `ResourceNotFoundException`, `DepartmentNotFoundException`
* 📊 **Structured API Responses** - Consistent HTTP status codes (`200`, `201`, `404`)
* 💽 **H2 Console Integration** - Easy database inspection and testing
* 🧪 **Production-Ready** - Following Spring Boot best practices
* 📚 **Layered Architecture** - Controller → Service → Repository
* ⚡ **Fast Development** - In-memory database with zero configuration

---

## 🛠️ Technologies

| Technology | Version | Purpose |
| --- | --- | --- |
| ☕ **Java** | 21 | Core Programming Language |
| 🍃 **Spring Boot** | 3.x | Application Framework |
| 🌐 **Spring Web MVC** | Latest | RESTful API Development |
| 💾 **Spring Data JPA** | Latest | Database Abstraction Layer |
| 🗄️ **Hibernate** | Latest | ORM Implementation |
| 🔵 **H2 Database** | Latest | In-Memory Database |
| 📦 **Maven** | 3.8+ | Build & Dependency Management |
| ✅ **Jakarta Validation** | Latest | Input Validation |
| 🛠️ **Lombok** | Latest | Boilerplate Code Reduction |
| 💻 **IntelliJ IDEA** | Latest | Development IDE |

---

## 🏗️ Project Architecture

```
┌─────────────────────────────────────────────────────┐
│                  Client Layer                        │
│            (Postman / Browser / App)                 │
└─────────────────────┬───────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────┐
│              Controller Layer                        │
│        (@RestController, @RequestMapping)            │
│     • EmployeeController   →  /employees             │
│     • DepartmentController →  /department            │
└─────────────────────┬───────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────┐
│               Service Layer                          │
│              (@Service, @Transactional)              │
│     • Business Logic                                 │
│     • Transaction Management                         │
│     • Data Processing                                │
└─────────────────────┬───────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────┐
│            Repository Layer                          │
│          (@Repository, JpaRepository)                │
│     • Database Operations                            │
│     • Query Methods                                  │
│     • CRUD Operations                                │
└─────────────────────┬───────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────┐
│              H2 Database                             │
│          (In-Memory Storage)                         │
└─────────────────────────────────────────────────────┘
```

---

## 📸 Project Screenshots

| # | Screenshot | Description |
| --- | --- | --- |
| 1 | <img width="1382" height="768" alt="01" src="https://github.com/user-attachments/assets/bf4d3785-5d6d-475d-ab65-15b0f573ae20" /> | **GET /employees/{employeeId} - Path Variable** |
| 2 | <img width="1382" height="450" alt="02" src="https://github.com/user-attachments/assets/304324f7-5c06-4828-8015-3fa0ac53edfd" /> | **GET /employees?inputAge=&name= - Query Params** |
| 3 | <img width="1392" height="717" alt="03" src="https://github.com/user-attachments/assets/530c368a-5728-4aa9-a03a-57b8ac79fbce" /> | **GET - Structured API Response** |
| 4 | <img width="1380" height="428" alt="04" src="https://github.com/user-attachments/assets/c2a7d666-1ab4-4341-9ca1-12adbd6a0e99" /> | **POST /employees - Create Employee** |
| 5 | <img width="1382" height="832" alt="05" src="https://github.com/user-attachments/assets/1d40e3b2-af12-4c07-ae3a-6ab37d25b785" /> | **POST - Structured API Response** |
| 6 | <img width="1391" height="821" alt="06" src="https://github.com/user-attachments/assets/505ea22c-7914-4524-ae16-e2ed9c857aea" /> | **PATCH /employees/{employeeId} - Partial Update** |
| 7 | <img width="1382" height="821" alt="07" src="https://github.com/user-attachments/assets/1d55c596-ae75-4bf6-bddf-20a9c7224d4c" /> | **PUT /employees/{employeeId} - Full Update** |
| 8 | <img width="1382" height="667" alt="08" src="https://github.com/user-attachments/assets/636e2b74-deb8-4998-b696-ed304a745917" /> | **DELETE /employees/{employeeId} - Deletion** |
| 9 | <img width="1387" height="800" alt="09" src="https://github.com/user-attachments/assets/c457e093-9b3a-4f70-a9da-5fba3ea2b63f" /> | **@PasswordValidation - Custom Validator** |
| 10 | <img width="1387" height="781" alt="10" src="https://github.com/user-attachments/assets/1c0ca2de-ed9b-4164-b612-56964de3a6b9" /> | **@PrimeNumberValidation - Custom Validator** |
| 11 | <img width="637" height="382" alt="11" src="https://github.com/user-attachments/assets/81d800f2-6557-4f5e-b65f-590dbfb8a1d7" /> | **Department API - Formatted Response** |
| 12 | <img width="633" height="285" alt="12" src="https://github.com/user-attachments/assets/7e22ffc2-1671-40e4-9730-595ad4061ca3" /> | **H2 Console - Database View** |

---

## 📥 Installation

### Prerequisites

* Java JDK 21 or higher
* Maven 3.8+
* IntelliJ IDEA (or any Java IDE)
* Postman (for API testing)

### Clone the Repository

```bash
git clone https://github.com/rahulthakare04/03_Spring-MVC-Rest_API.git
cd 03_Spring-MVC-Rest_API
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

### Access H2 Database Console

Navigate to: `http://localhost:8080/h2-console`

| Field | Value |
| --- | --- |
| JDBC URL | `jdbc:h2:mem:testdb` |
| Username | `sa` |
| Password | *(leave blank)* |

---

## 🎯 API Endpoints

### 👨‍💼 Employee APIs — Base URL: `/employees`

#### 🟢 GET Employee by ID (Path Variable)

```
GET http://localhost:8080/employees/1
```

---

#### 🟢 GET All Employees (Optional Query Params)

```
GET http://localhost:8080/employees
GET http://localhost:8080/employees?inputAge=25&name=Rahul
```

---

#### 🔵 POST Create New Employee

```
POST http://localhost:8080/employees
Content-Type: application/json
```

```json
{
  "name": "Rahul",
  "email": "rahul@example.com",
  "age": 25,
  "dateOfJouning": "2024-01-15",
  "isActive": true,
  "salary": 50000,
  "role": "USER"
}
```

> ✅ **Validation Rules:**
> - `name` → 3 to 10 characters, must not be blank
> - `email` → valid email format
> - `age` → between 18 and 80
> - `dateOfJouning` → past or present date
> - `salary` → positive number, not null
> - `role` → only `ADMIN` or `USER` (`@EmployeeRoleValidation`)

---

#### 🟡 PUT Update Employee (Full Update)

```
PUT http://localhost:8080/employees/1
Content-Type: application/json
```

```json
{
  "name": "Rahul T",
  "email": "rahul.updated@example.com",
  "age": 26,
  "dateOfJouning": "2024-06-01",
  "isActive": true,
  "salary": 60000,
  "role": "ADMIN"
}
```

---

#### 🟠 PATCH Update Employee (Partial Update)

```
PATCH http://localhost:8080/employees/1
Content-Type: application/json
```

```json
{
  "salary": 75000
}
```

> You can patch any one or more fields: `name`, `email`, `age`, `salary`, `isActive`, `role`, `dateOfJouning`

---

#### 🔴 DELETE Employee by ID

```
DELETE http://localhost:8080/employees/1
```

---

### 🏢 Department APIs — Base URL: `/department`

#### 🟢 GET Department by ID

```
GET http://localhost:8080/department/1
```

---

#### 🟢 GET All Departments

```
GET http://localhost:8080/department
```

---

#### 🔵 POST Create New Department

```
POST http://localhost:8080/department
Content-Type: application/json
```

```json
{
  "title": "Engineering",
  "isActive": true,
  "createAt": "2024-01-15",
  "number": 7,
  "password": "Admin@1234"
}
```

> ✅ **Validation Rules:**
> - `title` → must not be blank
> - `isActive` → must be `true`
> - `createAt` → past or present date
> - `number` → must be a **prime number** e.g. `2, 3, 5, 7, 11, 13...` (`@PrimeNumberValidation`)
> - `password` → uppercase + lowercase + digit + special character (`@PasswordValidation`)

---

#### 🟡 PUT Update Department (Full Update)

```
PUT http://localhost:8080/department/1
Content-Type: application/json
```

```json
{
  "title": "Human Resources",
  "isActive": true,
  "createAt": "2024-03-10",
  "number": 11,
  "password": "Admin@1234"
}
```

---

#### 🔴 DELETE Department by ID

```
DELETE http://localhost:8080/department/1
```

---

## 🧩 Code Examples

### 1. Employee Controller

```java
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeesById(
            @PathVariable(name = "employeeId") Long id) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeesById(id);
        return employeeDTO.map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee not found with id " + id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(
            @RequestParam(required = false, name = "inputAge") Integer age,
            @RequestParam(required = false) String name) {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(
            @RequestBody @Valid EmployeeDTO inputemployee) {
        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputemployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(
            @RequestBody @Valid EmployeeDTO employeeDTO,
            @PathVariable(name = "employeeId") Long employeeId) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeDTO, employeeId));
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(
            @RequestBody Map<String, Object> update,
            @PathVariable Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(employeeId, update);
        if (employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(
            @PathVariable(name = "employeeId") Long employeeId) {
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
}
```

### 2. Department Controller

```java
@RestController
@RequestMapping(path = "department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping(path = "{departmentId}")
    public ResponseEntity<DepartmentDTO> GetDepartmentById(
            @PathVariable(name = "departmentId") Long departmentId) {
        Optional<DepartmentDTO> departmentDTO = departmentService.GetDepartmentById(departmentId);
        return departmentDTO.map(ResponseEntity::ok)
                .orElseThrow(() -> new DepartmentNotFoundException(
                        "Department not found of this id"));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(
            @RequestBody @Valid DepartmentDTO inputDepartment) {
        DepartmentDTO saved = departmentService.createNewDepartment(inputDepartment);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping(path = "{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartment(
            @RequestBody @Valid DepartmentDTO inputDepartment,
            @PathVariable Long departmentId) {
        return ResponseEntity.ok(
                departmentService.updateDepartment(inputDepartment, departmentId));
    }

    @DeleteMapping("{departmentId}")
    public ResponseEntity<Boolean> DepartmentDelete(@PathVariable Long departmentId) {
        boolean gotDelete = departmentService.departmentDelete(departmentId);
        if (gotDelete) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
}
```

### 3. Employee DTO with Validations

```java
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "required field name must not be empty")
    @Size(min = 3, max = 10, message = "name must be in the range of [3,10]")
    private String name;

    @Email(message = "email should be valid email")
    private String email;

    @Max(value = 80, message = "the employee age must not be greater than 80")
    @Min(value = 18, message = "the employee age must not be smaller than 18")
    private Integer age;

    @PastOrPresent(message = "date of joining must be past or present")
    private LocalDate dateOfJouning;

    private Boolean isActive;

    @NotNull(message = "salary of employee not be null")
    @Positive(message = "salary of employee must be positive")
    private Integer salary;

    @EmployeeRoleValidation
    @NotBlank(message = "role of employee not be null")
    private String role; // ADMIN | USER
}
```

### 4. Department DTO with Custom Validations

```java
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "title must not be empty")
    private String title;

    @AssertTrue(message = "always need true")
    private Boolean isActive;

    @PastOrPresent(message = "date must be in past or present")
    private LocalDate createAt;

    @PrimeNumberValidation
    private Integer number;

    @PasswordValidation
    private String password;
}
```

### 5. Custom Validation — @PasswordValidation

```java
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordValidation {
    String message() default "Password must contain uppercase, lowercase, digit, and special character";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
```

### 6. Custom Validation — @PrimeNumberValidation

```java
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PrimeNumberValidator.class)
public @interface PrimeNumberValidation {
    String message() default "Number must be a prime number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation, Integer> {
    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext context) {
        if (number == null || number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
```

### 7. Custom Validation — @EmployeeRoleValidation

```java
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployeeRoleValidator.class)
public @interface EmployeeRoleValidation {
    String message() default "Role must be either ADMIN or USER";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
```

---

## 📚 Key Concepts Covered

### 1️⃣ Spring Boot Web MVC Architecture
Understanding the Model-View-Controller pattern and how Spring Boot implements it for building RESTful APIs.

### 2️⃣ Presentation Layer with DTOs
Using `EmployeeDTO` and `DepartmentDTO` to separate internal domain models from API contracts, ensuring clean data flow.

### 3️⃣ Persistence Layer with JPA
Leveraging Spring Data JPA for database operations, using repositories for CRUD operations and custom queries.

### 4️⃣ Service Layer Business Logic
Implementing business rules and transaction management in a dedicated service layer for better separation of concerns.

### 5️⃣ HTTP Method Mappings
Complete implementation of RESTful principles with GET, POST, PUT, PATCH, and DELETE operations across both Employee and Department resources.

### 6️⃣ Input Validation
Using Jakarta Validation API with built-in annotations (`@NotBlank`, `@Email`, `@Min`, `@Max`, `@Size`, `@Positive`, `@PastOrPresent`, `@AssertTrue`) and three custom validators (`@PasswordValidation`, `@PrimeNumberValidation`, `@EmployeeRoleValidation`).

### 7️⃣ Exception Handling
Implementing global exception handling with `@ControllerAdvice` for consistent error responses — `ResourceNotFoundException` for employees, `DepartmentNotFoundException` for departments.

### 8️⃣ API Response Transformation
Structuring API responses with proper HTTP status codes: `200 OK`, `201 CREATED`, `404 NOT FOUND`.

---

## 🔧 Configuration

### Application Properties

```properties
# Server Configuration
server.port=8080

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Logging
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate.SQL=DEBUG
```

---

## 🤝 Contributing

Contributions are always welcome! Here's how you can help:

1. 🍴 Fork the repository
2. 🌿 Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. 💾 Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. 📤 Push to the branch (`git push origin feature/AmazingFeature`)
5. 🔃 Open a Pull Request

---

## 📄 License

```
Copyright (c) 2024 rahulthakare04

This project and its source code are the exclusive property of the author.
Unauthorized copying, modification, distribution, or commercial use is strictly prohibited.
Limited use is granted for learning, reviewing, and non-commercial demonstration purposes only.
No warranties are provided; use at your own risk.
For permissions beyond this notice, contact the repository owner via GitHub.
```

---

## 🙏 Acknowledgments

* 🍃 **Spring Team** - For the incredible Spring Boot and Spring MVC frameworks
* 💾 **Hibernate Team** - For powerful ORM capabilities
* 🗄️ **H2 Database** - For the lightweight in-memory database
* 🌐 **Open Source Community** - For continuous inspiration and knowledge sharing
* 📚 **Spring Documentation** - For comprehensive guides and best practices
* 🎓 **Java Community** - For REST API design patterns and conventions
* 🛠️ **JetBrains** - For IntelliJ IDEA development environment

---

## 📞 Connect & Support

[![GitHub](https://img.shields.io/badge/GitHub-rahulthakare04-181717?style=flat-square&logo=github)](https://github.com/rahulthakare04)
[![Repository](https://img.shields.io/badge/Repository-03_Spring--MVC--Rest_API-blue?style=flat-square&logo=github)](https://github.com/rahulthakare04/03_Spring-MVC-Rest_API)

### 🌟 Star this repo if you find it helpful! ⭐

**Built with ❤️ by [rahulthakare04](https://github.com/rahulthakare04)**

---

**Happy Coding! 💻✨**

*"RESTful APIs are the bridges that connect applications - build them strong, build them right."*
