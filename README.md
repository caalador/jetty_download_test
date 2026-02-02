# Jetty File Download Server

A simple Maven project with an embedded Jetty 12 server that serves a page with a file download link.

## Requirements

- Java 17+
- Maven 3.6+

## Project Structure

```
jetty/
├── pom.xml
├── README.md
└── src/main/
    ├── java/com/example/
    │   ├── App.java              # Main class, starts Jetty server
    │   ├── IndexServlet.java     # Serves HTML page with download link
    │   └── DownloadServlet.java  # Handles file download
    └── resources/static/
        └── sample%text.txt            # Sample file to download
```

## Usage

### Build and Run

```bash
mvn compile exec:java
```

### Access the Application

Open your browser and navigate to:

```
http://localhost:8080
```

Click the download link to download `sample%text.txt`.

This will fail with the error `HTTP ERROR 400 Ambiguous URI path encoding` when using jetty 12.0.14, but succeeded with 11.0.18

## Configuration

- **Port**: The server runs on port `8080` by default. Modify `App.java` to change it.
- **Download file**: Replace `src/main/resources/static/sample.txt` with your own file and update `DownloadServlet.java` accordingly.
