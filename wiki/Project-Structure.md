# Project Structure

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
