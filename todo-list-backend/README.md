# Todo List - Backend

A simple RESTful backend for a Todo List application built with Spring Boot.

This repository contains a Spring Boot (Java 17) application that exposes CRUD endpoints for managing Todo items and uses JPA to persist data (MySQL in production, H2 for tests).

Quick facts
- Java: 17
- Spring Boot: 3.x
- Build: Maven
- Persistence: JPA (MySQL runtime, H2 for tests)
- API docs: OpenAPI (springdoc)

Table of contents
- About
- Prerequisites
- Configuration
- Build & Run
- API Endpoints
- Data models
- Examples (curl)
- Tests
- Notes & next steps

About
This service exposes a minimal set of endpoints under /todos to create, list, update and delete Todo items. It also ships with OpenAPI/Swagger UI to explore the API.

Prerequisites
- Java 17 (or a compatible JDK)
- Maven (optional: the repository includes the Maven wrapper so you can use the included scripts)
- MySQL (or another JDBC-compatible database)

Configuration
The application reads Spring Boot properties from src/main/resources/application.properties. Example properties used in development (do NOT commit secrets or production credentials):

spring.datasource.url=jdbc:mysql://127.0.0.1:3307/todolist
spring.datasource.username=root
spring.datasource.password=<your-db-password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

Recommended: avoid committing secrets. Instead set environment variables or use a profile-specific properties file. For example, to run with custom credentials, set environment variables before launching the app or update application.properties (not recommended for production):

On Windows cmd.exe (example):

set SPRING_DATASOURCE_URL=jdbc:mysql://127.0.0.1:3307/todolist
set SPRING_DATASOURCE_USERNAME=root
set SPRING_DATASOURCE_PASSWORD=your_db_password

Build & Run
From the project root you can build and run the app with the included Maven wrapper.

Windows (cmd.exe):

mvnw.cmd clean package
mvnw.cmd spring-boot:run

Or use the packaged jar:

mvnw.cmd clean package
java -jar target/todo-list-backend-0.0.1-SNAPSHOT.jar

The application will start on the default Spring Boot port (8080) unless overridden.

API Endpoints
All endpoints are rooted at /todos (see `src/main/java/.../controller/TodoController.java`).

- POST /todos
  - Description: Create a new todo item.
  - Request body: a Todo JSON (title required)
  - Response: List<Todo> — the service returns the current list of todos after the operation.

- GET /todos
  - Description: Get the list of todos.
  - Response: List<Todo>

- PUT /todos
  - Description: Update an existing todo. The request body should contain a Todo object (including its id).
  - Response: List<Todo> — the service returns the current list of todos after the operation.

- DELETE /todos/{id}
  - Description: Delete the todo with the given id.
  - Response: List<Todo> — the service returns the current list of todos after the operation.

Note: The controller currently returns the full list after each mutating operation.

Data models
Entity: Todo (src/main/java/.../domain/entity/Todo.java)
- id: Long (generated)
- title: String (required)
- description: String
- status: TodoStatus (enum)
- priority: TodoPriority (enum)

DTO: TodoDTO (src/main/java/.../dto/TodoDTO.java)
- id: Long
- title: String
- description: String
- status: TodoStatus
- priority: TodoPriority
- priorityWeight: int (derived from priority)

Enum helpers
Check src/main/java/.../domain/enums for TodoStatus and TodoPriority values (these control allowed status and priority values and their weights).

Examples (curl)
Below are example requests you can try once the server is running.

Create a new Todo
curl -X POST http://localhost:8080/todos -H "Content-Type: application/json" -d "{\"title\": \"Buy groceries\", \"description\": \"Milk, Bread\", \"status\": \"TODO\", \"priority\": \"MEDIUM\" }"

Get todos
curl http://localhost:8080/todos

Update a todo (include id)
curl -X PUT http://localhost:8080/todos -H "Content-Type: application/json" -d "{\"id\": 1, \"title\": \"Buy groceries and fruits\", \"description\": \"Milk, Bread, Apples\", \"status\": \"IN_PROGRESS\", \"priority\": \"HIGH\" }"

Delete a todo
curl -X DELETE http://localhost:8080/todos/1

API docs (OpenAPI / Swagger)
This project includes springdoc. Once the application is running, open the Swagger UI to explore the API:

http://localhost:8080/swagger-ui/index.html

Tests
There is a test skeleton in src/test. To run tests:

mvnw.cmd test

Notes & next steps
- Credentials: remove any hard-coded passwords from committed properties files. Use environment variables or an externalized configuration provider for production.
- Validation: controller uses @Valid for POST; consider adding consistent validation and error responses for all endpoints.
- Return payloads: consider returning DTOs or response objects instead of returning the entity list directly.
- Pagination & filtering: add support for pagination and filtering for large todo lists.

Contributing
If you'd like to contribute, open an issue or a pull request with a clear description of the change.

License
This project does not include a license file. Add one if you plan to open-source it.

