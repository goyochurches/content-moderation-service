# User Flag Service 🚩

## Description 📄

The User Flag Service is a Spring Boot application designed to process user messages, calculate offensiveness scores, and generate reports in CSV format. It includes features like validation, caching, and exception handling.

## Features ✨

- 📂 Process user messages from uploaded CSV files.
- 📊 Calculate offensiveness scores using external APIs.
- 📝 Generate reports with user statistics (e.g., total messages, average score).
- 🚨 Exception handling for invalid inputs and server errors.
- ⚡ In-memory caching for improved performance.

## Dependencies 📦

The project uses the following dependencies:

- **Spring Boot Starter Actuator**: Provides production-ready features like monitoring and metrics.
- **Spring Boot Starter Web**: Enables building RESTful web services.
- **Spring Boot Starter Test**: Provides testing utilities for unit and integration tests.
- **Apache Commons CSV**: Facilitates reading and writing CSV files.
- **Lombok**: Reduces boilerplate code with annotations for getters, setters, etc.
- **Caffeine**: Provides high-performance caching.
- **Jakarta Validation API**: Enables validation annotations for request inputs.
- **Hibernate Validator**: Implements Jakarta Bean Validation.

## Requirements 🛠️

- **Java 21**
- **Maven**

## Setup Instructions 🚀

1. Clone the repository:

   ```bash
   git clone <repository-url>
   cd ravenpack-userflag-service-exercise
   ```

2. Build the project:

   ```bash
   ./mvnw clean install
   ```

3. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

4. Access the application at `http://localhost:8080`.

## Testing 🧪

Run all tests using:

```bash
./mvnw test
```

## Endpoints 🌐

### POST `/api/user-flag/process`

- **Description**: Processes a CSV file containing user messages and returns a downloadable CSV report.
- **Request**: Multipart file upload (`file` parameter).
- **Response**: CSV file with columns `user_id`, `total_messages`, and `avg_score`.

## API Documentation 📖

The User Flag Service includes API documentation generated using Swagger. You can access the Swagger UI to explore and test the available endpoints.

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

This provides an interactive interface to view the API documentation and test the endpoints directly.

## Project Structure 🗂️

The workspace is organized as follows:

```
📂 src
├── 📂 main
│   ├── 📂 java
│   │   └── 📂 com
│   │       └── 📂 user
│   │           └── 📂 flag
│   │               ├── 📂 client
│   │               ├── 📂 config
│   │               ├── 📂 controller
│   │               ├── 📂 dto
│   │               ├── 📂 enums
│   │               ├── 📂 service
│   │               └── 📂 utils
│   └── 📂 resources
│       ├── 📄 application.properties
├── 📂 test
│   ├── 📂 java
│   │   └── 📂 com
│   │       └── 📂 user
│   │           └── 📂 flag
│   │               ├── 📂 client
│   │               ├── 📂 controller
│   │               ├── 📂 service
│   │               └── 📂 utils
```

## License 📜

This project is licensed under the MIT License.
