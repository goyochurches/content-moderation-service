# User Flag Service

## Description

The User Flag Service is a Spring Boot application designed to process user messages, calculate offensiveness scores, and generate reports in CSV format. It uses OpenFeign for external API communication and includes features like validation, caching, and exception handling.

## Features

- Process user messages from uploaded CSV files.
- Calculate offensiveness scores using external APIs.
- Generate reports with user statistics (e.g., total messages, average score).
- Exception handling for invalid inputs and server errors.
- In-memory caching for improved performance.

## Dependencies

The project uses the following dependencies:

- **Spring Boot Starter Actuator**: Provides production-ready features like monitoring and metrics.
- **Spring Boot Starter Web**: Enables building RESTful web services.
- **Spring Cloud Starter OpenFeign**: Simplifies HTTP client calls to external APIs.
- **Spring Boot Starter Test**: Provides testing utilities for unit and integration tests.
- **Apache Commons CSV**: Facilitates reading and writing CSV files.
- **Lombok**: Reduces boilerplate code with annotations for getters, setters, etc.
- **Caffeine**: Provides high-performance caching.
- **Jakarta Validation API**: Enables validation annotations for request inputs.
- **Hibernate Validator**: Implements Jakarta Bean Validation.

## Requirements

- **Java 21**
- **Maven**

## Setup Instructions

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

## Testing

Run all tests using:

```bash
./mvnw test
```

## Endpoints

### POST `/api/user-flag/process`

- **Description**: Processes a CSV file containing user messages and returns a downloadable CSV report.
- **Request**: Multipart file upload (`file` parameter).
- **Response**: CSV file with columns `user_id`, `total_messages`, and `avg_score`.

## Project Structure

The workspace is organized as follows:

```
📂 src
├── 📂 main
│   ├── 📂 java
│   │   └── 📂 com
│   │       └── 📂 user
│   │           └── 📂 flag
│   │               ├── 📂 client
│   │               │   ├── 📄 ScoringClient.java
│   │               │   └── 📄 TranslationClient.java
│   │               ├── 📂 config
│   │               │   └── 📄 AppConfig.java
│   │               ├── 📂 controller
│   │               │   ├── 📄 GlobalExceptionHandler.java
│   │               │   └── 📄 UserFlagController.java
│   │               ├── 📂 dto
│   │               │   └── 📄 UserStats.java
│   │               ├── 📂 enums
│   │               │   └── 📄 LanguageType.java
│   │               ├── 📂 service
│   │               │   ├── 📄 FileService.java
│   │               │   └── 📄 UserFlagService.java
│   │               └── 📂 utils
│   │                   ├── 📄 FileNotEmptyValidator.java
│   │                   ├── 📄 FileWriterUtil.java
│   │                   └── 📄 UserStatsUtil.java
│   └── 📂 resources
│       ├── 📄 application.properties
│       ├── 📂 static
│       └── 📂 templates
├── 📂 test
│   ├── 📂 java
│   │   └── 📂 com
│   │       └── 📂 user
│   │           └── 📂 flag
│   │               ├── 📂 client
│   │               ├── 📂 controller
│   │               ├── 📂 service
│   │               └── 📂 utils
│   └── 📂 resources
│       └── 📄 test.csv
```

## License

This project is licensed under the MIT License.
