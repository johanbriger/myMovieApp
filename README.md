
# myMovieApp - Spring Boot Study Project

![Java CI with Maven](https://github.com/johanbriger/myMovieApp/actions/workflows/maven.yml/badge.svg)

A robust web application for managing a movie library, developed as a student assignment focusing on the Spring Boot framework. The application enables users to list, search, add, edit, and delete movies through a clean web interface.

## ⚖️ Requirements(Laboration 1)

### Core Features 
* **CRUD:** Full support for Movies.
* **Architecture:** Clear separation between Controller -> Service -> Repository.
* **DTO Pattern:** Separate DTOs for Create, Update, and View actions.
* **Validation:** Bean Validation (Jakarta) used in both Entities and DTOs.
* **Custom Error Handling:** Implements `ResourceNotFoundException` and `@ControllerAdvice`.

### Advanced Features
* **Search/Filter:** Search functionality implemented via Repository queries.
* **Pagination:** Server-side pagination using `Pageable` and `Page`.
* **Database Migrations:** Flyway used for schema versioning.

### Testing
* **Service Tests:** Unit tests for business logic.
* **Mapper Tests:** Unit tests for Entity-DTO conversion.
* **Web Tests:** `MockMvc` tests for controllers and view resolution.


## 🛠 Tech Stack

* **Java:** 25
* **Framework:** Spring Boot 4.0.3
* **Web:** Spring MVC & Thymeleaf (Template Engine)
* **Frontend UI:** **Bootstrap 5**
* **Data:** Spring Data JPA & Flyway
* **Database:** **PostgreSQL 15 (via Docker)**
* **Tools:** Maven, Docker, Mockito

## 📋 Prerequisites

To run this project, you will need:
* **JDK 25** installed on your system.
* **Docker & Docker Compose** installed and running.
* **Maven 3.9.x** or later.

## 🏃 Getting Started

### 1. Start the Database (Docker)
The application requires a PostgreSQL database. Start it using the provided Docker Compose file:
```bash
docker-compose up -d
```

This will start a Postgres container in the background and map it to port 5432.

### 2. Run the Application
You can run the app via IntelliJ or the terminal:

**Via IntelliJ:**
* Open the project and ensure Project SDK is set to **Java 25**.
* Run `MyMovieAppApplication.java`.

**Via Terminal:**
```bash
mvn spring-boot:run
```
### 3. Access the web interface
Open your browser and go to:

* **Main Application:** [http://localhost:8080/movies](http://localhost:8080/movies)

## 🍿 Sample Data & Migrations
* **Flyway:** On startup, Flyway automatically runs all migration scripts found in `src/main/resources/db/migration` to set up your tables.
* **DataInitializer:** The application is pre-configured with a `DataInitializer` that populates the database with sample movies if the database is empty.

## 🧪 Testing
The project includes REST controller testing using `@WebMvcTest` and `MockMvc`.

* **To run tests:** `mvn test`
* **Note:** This project uses `@MockitoBean` (available in Spring Boot 3.4+) for modern service mocking.

## 📁 Project Structure
* `src/main/java/org/mymovieapp/controller`: Handles HTTP requests and UI interaction.
* `src/main/java/org/mymovieapp/service`: Contains the business logic and orchestration.
* `src/main/resources/db/migration`: SQL scripts for database versioning.
* `docker-compose.yml`: Configuration for the PostgreSQL container.

## 🤖 Continuous Integration (CI)
This project uses **GitHub Actions** to ensure code quality:

* **Automated Builds:** Every push to the `main` branch triggers a build using Maven and JDK 25.
* **Automated Testing:** All JUnit tests are executed in a clean environment.
