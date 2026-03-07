
# myMovieApp - Spring Boot Study Project

![Java CI with Maven](https://github.com/johanbriger/movieApp/actions/workflows/maven.yml/badge.svg)

A robust web application for managing a movie library, developed as a student assignment focusing on the Spring Boot framework. The application enables users to list, search, add, edit, and delete movies through a clean web interface.

## 🚀 Features

* **Movie Management (CRUD):** Full support for Creating, Reading, Updating, and Deleting movies.
* **Search Functionality:** Filter the movie list using search strings to find specific titles.
* **Pagination & Sorting:** Efficient handling of datasets using `Pageable` for pagination and automatic sorting by title.
* **Form Validation:** Uses `spring-boot-starter-validation` to ensure data integrity (e.g., mandatory fields, date formats).
* **DTO Pattern:** Implements Data Transfer Objects (`MovieDTO`, `CreateMovieDTO`, `UpdateMovieDTO`) to decouple database entities from the presentation layer.

## 🛠 Tech Stack

* **Java:** 25
* **Framework:** Spring Boot 4.0.3
* **Web:** Spring MVC & Thymeleaf (Template Engine)
* **Data:** Spring Data JPA
* **Database:** H2 Database (In-memory)
* **Tools:** Maven, Mockito, MockMvc

## 📋 Prerequisites

To run this project, you will need:
* **JDK 25** installed on your system.
* **Maven 3.9.x** or later.
* **IntelliJ IDEA** (Recommended).

## 🏃 Getting Started (IntelliJ IDEA)

1. **Clone or Open the project:**
    * Open IntelliJ IDEA and select **File > Open...** and select the project folder.

2. **Configure Java Version:**
    * Ensure your Project SDK is set to **Java 25**.

3. **Load Maven Project:**
    * Right-click on `pom.xml` and select **Maven > Reload Project** to ensure all dependencies are indexed.

4. **Run the application:**
    * Find the main class `MyMovieAppApplication.java` in `src/main/java/org/mymovieapp/`.
    * Click the **green play button**.

5. **Access the web interface:**
    * Open your browser and go to: `http://localhost:8080/movies`

## 🍿 Sample Data & Development Tools

The application is pre-configured with a `DataInitializer` that automatically populates the H2 database with a few classic movies upon startup, allowing for immediate testing of search and pagination.

### H2 Database Console
You can inspect the in-memory database at any time:
* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:testdb`
* **User:** `sa` (No password)

## 🧪 Testing

The project includes REST controller testing using `@WebMvcTest` and `MockMvc`.
* **To run tests:** Right-click the `src/test/java` folder in IntelliJ and select **Run 'All Tests'**.
* **Note:** This project uses `@MockitoBean` (available in Spring Boot 3.4+) for modern service mocking.

## 📁 Project Structure

* `src/main/java/org/mymovieapp/controller`: Handles HTTP requests and UI interaction.
* `src/main/java/org/mymovieapp/service`: Contains the business logic and orchestration.
* `src/main/java/org/mymovieapp/dto`: Data Transfer Objects for secure data communication.
* `src/main/resources/templates`: Thymeleaf templates for the front-end.

## 🤖 Continuous Integration (CI)

This project uses **GitHub Actions** to ensure code quality:
* **Automated Builds:** Every push to the `main` branch triggers a build using Maven and JDK 25.
* **Automated Testing:** All JUnit tests are executed in a clean Ubuntu environment.
* **Artifacts:** A runnable JAR file is created upon successful builds.

---
