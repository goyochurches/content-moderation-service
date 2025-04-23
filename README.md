🛡️ Content Moderation System
This project implements a Content Moderation Application for a social network, aimed at identifying users who post offensive or abusive messages in the comments section. The application analyzes messages, translates them to English if needed, assigns an offensiveness score, and generates a per-user report.

📌 Features
📄 Input: CSV file with columns user_id and message.

🌐 Simulated external services:

Translation Service: Translates messages to English.

Scoring Service: Assigns an offensiveness score between 0.0 and 1.0.

⚙️ Output: CSV file with columns:

user_id

total_messages

avg_score

🧠 Optimized processing:

Caching for repeated messages.

Concurrent processing for high performance on large datasets.

🔁 External services are idempotent, allowing redundant calls to be safely avoided.

🧪 Includes unit test coverage.

🚀 How to Run
Clone the repository:

bash
Copiar
Editar
git clone https://github.com/your-username/content-moderation-system.git
cd content-moderation-system
Build the project (using Maven):

bash
Copiar
Editar
mvn clean install
Run the application:

bash
Copiar
Editar
java -jar target/content-moderation-system.jar input.csv output.csv
Where:

input.csv is the input file with user messages.

output.csv is the output report file.

📁 Project Structure
Copiar
Editar
src/
├── main/
│ ├── java/
│ │ └── com.example.moderation/
│ │ ├── ModerationApp.java
│ │ ├── service/
│ │ ├── model/
│ │ └── util/
│ └── resources/
├── test/
│ └── java/
│ └── com.example.moderation/
🧪 Testing
To run the unit tests:

bash
Copiar
Editar
mvn test
✅ Requirements
Java 11+

Maven 3.6+
