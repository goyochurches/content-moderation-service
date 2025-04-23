<p align="center">
  <img src="./logo.png" alt="MP4 Conversion Hub logo" width="400"/>
</p>

[![OSV-Scanner](https://github.com/QADRAX/mp4-conversion-hub/actions/workflows/osv-scanner.yaml/badge.svg?branch=main)](https://github.com/QADRAX/mp4-conversion-hub/actions/workflows/osv-scanner.yaml)
[![CI Build](https://github.com/QADRAX/mp4-conversion-hub/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/QADRAX/mp4-conversion-hub/actions/workflows/ci.yml)

# MP4 Conversion Hub

A lightweight, Dockerized media processing hub designed for home servers like [CasaOS](https://www.casaos.io/). It watches folders, scans files for viruses using ClamAV, and converts videos to MP4 format with FFmpeg. Includes a web UI for monitoring, uploading, and managing jobs.

## Why MP4 Conversion Hub?

MP4 Conversion Hub is an ideal tool for home media servers where families or groups of friends want to share and consume video content easily.

Whether you're running Jellyfin, Plex, or a custom file server, one of the main challenges is ensuring that videos are in a format that can be streamed efficiently and universally. That’s where MP4 Conversion Hub fits in.

MP4 Conversion Hub is Dockerized and designed to work seamlessly with other containers by sharing volumes. On a home server setup (e.g., CasaOS, Portainer, or manual Docker Compose), it's easy to:

- Mount a common input folder from your SFTP server (where users drop videos).
- Let MP4 Conversion Hub scan and convert those files to MP4 in a shared output folder.
- Point Jellyfin directly to that output folder to serve optimized content to all users.

```
# structure:
📂 /src/main
├── 📂 client
├── 📂 controller
├── 📂 dto
├── 📂 service
├── 📂 utils

```

## 🚀 Features

- **User Flagging System** – Identifies users posting offensive or abusive messages.
- **Translation Service Integration** – Automatically translates messages to English for scoring.
- **Scoring Service Integration** – Assigns an offensiveness score to messages.
- **Caching** – Uses Caffeine for caching translations and scores to improve performance.
- **File Processing** – Handles large input files efficiently with streaming and caching.
- **REST API** – Exposes endpoints for uploading and processing files.
- **Modular Design** – Clean separation of concerns with dedicated layers for services, clients, and utilities.

## 📦 Installation (Maven)

### Prerequisites

- Java 21 or higher
- Maven 3.8.1 or higher

### Steps

1. Clone the repository:

```bash
git clone https://github.com/your-repo/user-flag-service.git
cd user-flag-service
```

2. Build the project:

```bash
mvn clean install
```

3. Run the application:

```bash
mvn spring-boot:run
```

## 📚 More Info

- **Caching**: Caffeine is used to cache translations and scores, reducing redundant calls to external services.
- **File Handling**: The application processes large files efficiently using streaming and modular file services.
- **REST API**: Simplified controllers delegate logic to service layers for better maintainability.
