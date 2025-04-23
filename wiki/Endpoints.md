# Endpoints

### POST `/api/user-flag/process`

- **Description**: Processes a CSV file containing user messages and returns a downloadable CSV report.
- **Request**: Multipart file upload (`file` parameter).
- **Response**: CSV file with columns `user_id`, `total_messages`, and `avg_score`.
