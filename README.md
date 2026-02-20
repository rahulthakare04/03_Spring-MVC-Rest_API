🌐 Spring Boot Web MVC & REST API
Visitor Badge GitHub issues Spring Boot Spring MVC JPA H2 Database Maven Java License

"REST APIs are the universal language of modern web applications - master them, and you master the web."

📖 Overview
A comprehensive Spring Boot Web MVC & RESTful API project that demonstrates professional API development practices. This project covers everything from basic MVC architecture to advanced topics like custom validation annotations, global exception handling, and structured API responses. Built with industry-standard patterns and backed by an in-memory H2 database for seamless CRUD operations.

🎯 What You'll Learn
🏗️ MVC Architecture - Understanding Model-View-Controller design pattern
🎮 RESTful Controllers - Building robust API endpoints with proper HTTP methods
💾 JPA & Hibernate - Database persistence with Spring Data JPA
🔧 Service Layer - Implementing clean business logic separation
✅ Input Validation - Using built-in and custom validation annotations
🚨 Exception Handling - Global error handling with @ControllerAdvice
📦 API Response Transformation - Structuring consistent API responses with DTOs
🗄️ H2 Database - In-memory database for rapid development
✨ Features
🌐 Complete REST API - Full CRUD operations with GET, POST, PUT, PATCH, and DELETE
🎯 Path Variables & Request Params - Multiple ways to accept client input
📝 DTO Pattern - Clean data transfer between layers
🔐 Custom Validators - @ValidPassword and @ValidPrimeNo annotations
🛡️ Global Exception Handling - Centralized error management
📊 Structured API Responses - Consistent response format with metadata
💽 H2 Console Integration - Easy database inspection and testing
🧪 Production-Ready - Following Spring Boot best practices
📚 Layered Architecture - Separation of concerns with Controller → Service → Repository
⚡ Fast Development - In-memory database with zero configuration
🛠️ Technologies
Technology	Version	Purpose
☕ Java	21	Core Programming Language
🍃 Spring Boot	3.x	Application Framework
🌐 Spring Web MVC	Latest	RESTful API Development
💾 Spring Data JPA	Latest	Database Abstraction Layer
🗄️ Hibernate	Latest	ORM Implementation
🔵 H2 Database	Latest	In-Memory Database
📦 Maven	3.8+	Build & Dependency Management
✅ Jakarta Validation	Latest	Input Validation
🛠️ Lombok	Latest	Boilerplate Code Reduction
💻 IntelliJ IDEA	Latest	Development IDE
🏗️ Project Architecture
┌─────────────────────────────────────────────────────┐
│                  Client Layer                        │
│            (Postman / Browser / App)                 │
└─────────────────────┬───────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────┐
│              Controller Layer                        │
│        (@RestController, @RequestMapping)            │
│     • Handle HTTP Requests                           │
│     • Input Validation                               │
│     • Response Transformation                        │
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
📸 Project Screenshots
#	Screenshot	Description
1	Get Request (Path Variable)	GET Request - Path Variable
2	Get Request (Request Param)	GET Request - Query Parameter
3	GET with API Response	GET - Structured API Response
4	POST Request	POST Request - Request Body
5	POST with API Response	POST - Structured API Response
6	PATCH with API Response	PATCH - Partial Update Response
7	PUT with API Response	PUT - Full Update Response
8	DELETE with API Response	DELETE - Deletion Confirmation
9	Custom Validation - Password	@ValidPassword - Custom Validator
10	Custom Validation - Prime Numbers	@ValidPrimeNo - Custom Validator
11	API Response with Date	API Response - Formatted Date
12	H2 Database Console	H2 Console - Database View
📥 Installation
Prerequisites
Java JDK 21 or higher
Maven 3.8+
IntelliJ IDEA (or any Java IDE)
Postman (for API testing)
Clone the Repository
git clone https://github.com/rahulthakare04/03_Spring-MVC-Rest_API.git
cd 03_Spring-MVC-Rest_API
Build the Project
mvn clean install
Run the Application
mvn spring-boot:run
Or run directly from IDE:

java -jar target/spring-mvc-rest-api-1.0.0.jar
Access H2 Database Console
Navigate to: http://localhost:8080/h2-console

Connection Details:

JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave blank)
🎯 Usage
API Endpoints Overview
🟢 GET Requests
# Path Variable
GET http://localhost:8080/api/users/{id}

# Query Parameter
GET http://localhost:8080/api/users?name=John&age=25
🔵 POST Request
POST http://localhost:8080/api/users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "SecureP@ss123",
  "age": 25
}
🟡 PUT Request (Full Update)
PUT http://localhost:8080/api/users/{id}
Content-Type: application/json

{
  "name": "John Updated",
  "email": "john.updated@example.com",
  "password": "NewP@ss456",
  "age": 26
}
🟠 PATCH Request (Partial Update)
PATCH http://localhost:8080/api/users/{id}
Content-Type: application/json

{
  "email": "newemail@example.com"
}
🔴 DELETE Request
DELETE http://localhost:8080/api/users/{id}
🧩 Code Examples
1. Controller Layer - REST Endpoints
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> getUserById(@PathVariable Long id) {
        UserDTO user = userService.findById(id);
        return ResponseEntity.ok(
            ApiResponse.success(user, "User retrieved successfully")
        );
    }
    
    @PostMapping
    public ResponseEntity<ApiResponse<UserDTO>> createUser(
            @Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ApiResponse.success(createdUser, "User created successfully"));
    }
}
2. Custom Validation Annotation - @ValidPassword
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidPassword {
    String message() default "Password must contain uppercase, lowercase, digit, and special character";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

// Validator Implementation
public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    
    private static final String PASSWORD_PATTERN = 
        "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return password != null && password.matches(PASSWORD_PATTERN);
    }
}
3. Custom Validation Annotation - @ValidPrimeNo
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PrimeNumberValidator.class)
public @interface ValidPrimeNo {
    String message() default "Number must be a prime number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

// Validator Implementation
public class PrimeNumberValidator implements ConstraintValidator<ValidPrimeNo, Integer> {
    
    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext context) {
        if (number == null || number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
4. Global Exception Handler
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(
            ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(ApiResponse.error(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationErrors(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ApiResponse.error("Validation failed", errors));
    }
}
5. API Response Wrapper
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private LocalDateTime timestamp;
    private Integer statusCode;
    
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(true, message, data, 
            LocalDateTime.now(), HttpStatus.OK.value());
    }
    
    public static <T> ApiResponse<T> error(String message, Integer statusCode) {
        return new ApiResponse<>(false, message, null, 
            LocalDateTime.now(), statusCode);
    }
}
6. Service Layer Implementation
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }
    
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return modelMapper.map(user, UserDTO.class);
    }
    
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        
        modelMapper.map(userDTO, existingUser);
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDTO.class);
    }
    
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
7. JPA Repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    
    List<User> findByAgeGreaterThan(Integer age);
    
    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    List<User> searchByName(@Param("name") String name);
    
    boolean existsByEmail(String email);
}
📚 Key Concepts Covered
1️⃣ Spring Boot Web MVC Architecture
Understanding the Model-View-Controller pattern and how Spring Boot implements it for building RESTful APIs.

2️⃣ Presentation Layer with DTOs
Using Data Transfer Objects to separate internal domain models from API contracts, ensuring clean data flow.

3️⃣ Persistence Layer with JPA
Leveraging Spring Data JPA for database operations, using repositories for CRUD operations and custom queries.

4️⃣ Service Layer Business Logic
Implementing business rules and transaction management in a dedicated service layer for better separation of concerns.

5️⃣ HTTP Method Mappings
Complete implementation of RESTful principles with GET, POST, PUT, PATCH, and DELETE operations.

6️⃣ Input Validation
Using Jakarta Validation API with built-in annotations and creating custom validators for complex validation rules.

7️⃣ Exception Handling
Implementing global exception handling with @ControllerAdvice for consistent error responses across the application.

8️⃣ API Response Transformation
Structuring API responses with metadata including success status, messages, timestamps, and status codes.

🔧 Configuration
Application Properties
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
🤝 Contributing
Contributions are always welcome! Here's how you can help:

🍴 Fork the repository
🌿 Create a feature branch (git checkout -b feature/AmazingFeature)
💾 Commit your changes (git commit -m 'Add some AmazingFeature')
📤 Push to the branch (git push origin feature/AmazingFeature)
🔃 Open a Pull Request
Code of Conduct
Please be respectful and constructive in all interactions.

📄 License
Copyright (c) 2024 rahulthakare04

This project and its source code are the exclusive property of the author.
Unauthorized copying, modification, distribution, or commercial use is strictly prohibited.
Limited use is granted for learning, reviewing, and non-commercial demonstration purposes only.
No warranties are provided; use at your own risk.
For permissions beyond this notice, contact the repository owner via GitHub.
🙏 Acknowledgments
🍃 Spring Team - For the incredible Spring Boot and Spring MVC frameworks
💾 Hibernate Team - For powerful ORM capabilities
🗄️ H2 Database - For the lightweight in-memory database
🌐 Open Source Community - For continuous inspiration and knowledge sharing
📚 Spring Documentation - For comprehensive guides and best practices
🎓 Java Community - For REST API design patterns and conventions
🛠️ JetBrains - For IntelliJ IDEA development environment
📞 Connect & Support
GitHub Repository: https://github.com/rahulthakare04/03_Spring-MVC-Rest_API

🌟 Star this repo if you find it helpful! ⭐
Built with ❤️ by rahulthakare04

Happy Coding! 💻✨

"RESTful APIs are the bridges that connect applications - build them strong, build them right."
