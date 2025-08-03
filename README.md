# URL Shortener Application

A simple URL Shortener built using **Spring Boot** and **H2 Database**. It allows users to convert long URLs into short ones and redirect back using the generated short link.

## Features
- Generate short URL for any valid long URL
- Redirect to original URL using the short version
- RESTful API endpoints
- In-memory H2 database for fast testing and development

## Tech Stack
- Java
- Spring Boot
- H2 Database

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/url-shortener.git
   cd url-shortener
2. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
3. Access API endpoints via:
   ```cpp
   http://localhost:8080
4. Access H2 Console:
   ```bash
   http://localhost:8080/h2-console
   ```
   - JDBC URL: jdbc:h2:mem:urlshortener
   - Username: sa
   - Password:


## API Endpoints

| Method | Endpoint     | Description              |
|--------|--------------|--------------------------|
| POST   | `/shorten`   | Create a short URL       |
| GET    | `/redirect/{key}`| Redirect to original URL |

