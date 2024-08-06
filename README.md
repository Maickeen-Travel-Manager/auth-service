# Auth Service

The Auth Service is a key component of the Travel Management System, responsible for user authentication and authorization. It manages user registration, login, profile management, and generates JWT tokens for secure communication between microservices.

## Features

- **User Registration**: Allows new users to register an account.
- **User Login**: Provides endpoint for user login and authentication.
- **Profile Management**: Allows users to view and update their profile information.
- **JWT Authentication**: Implements JWT for secure authentication and authorization.

## Endpoints

- **Registration**
    - `POST /auth/register`: Registers a new user.
- **Login**
    - `POST /auth/login`: Authenticates a user and returns a JWT.
- **Profile Management**
    - `GET /auth/profile`: Retrieves the authenticated user's profile.
    - `PUT /auth/profile`: Updates the authenticated user's profile.

## Technologies

- **Java 21**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **PostgreSQL**

## Getting Started

### Prerequisites

- Java 21+
- Maven
- Docker (for containerization)

### Running the Service Locally

1. **Clone the repository**:
   ```sh
   git clone https://github.com/yourusername/auth-service.git
   cd auth-service
2. **Build the project**:
    ```sh
   mvn clean install
3. **Run the application**:
    ```sh
   mvn spring-boot:run
### Running with Docker
1. **Build Docker image**:
    ```sh
   docker build -t auth-service:latest .
2. **Run Docker container**:
    ```sh
   docker run -p 8080:8080 auth-service:latest


### Running PostgreSQL with Docker
1. **Run PostgreSQL container**:
    ```sh
   docker run --name travel-manager -e POSTGRES_USER=tmuser -e POSTGRES_PASSWORD=tmpassword -e POSTGRES_DB=authdb -p 5432:5432 -d postgres

## License
This project is licensed under the MIT License. See the LICENSE file for details.
