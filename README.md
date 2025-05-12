# Library Manager

## Overview
Library Manager is a web-based application built with **Java 17**, **Spring Boot**, **Thymeleaf**, and an in-memory **H2 Database**. It enables library administrators to efficiently manage a collection of books with support for uploading cover images, searching, editing, and deleting entries.

## Features
- 📖 List all books in the system.
- ➕ Add new books with cover images.
- 🔍 Search books by title, author, or publisher.
- 📝 Update book details via a form.
- 🗑️ Delete books from the catalog.
- 🖼️ Display book cover images directly on the web page.

## Tech Stack & Prerequisites

This project is built with the following technologies, and requires the following tools to be installed:

### Prerequisites
- **Java 17 or higher**
- **Maven** (for building and running the project)

### Tech Stack
- **Spring Boot Web** – for building RESTful web services
- **Spring Data JDBC** – for database interaction
- **Thymeleaf** – as the template engine for views
- **H2 Database** – in-memory database used at runtime
- **Spring Boot Test** – for unit and integration testing

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/RobisonTorres/Library_Manager.git
   cd Library_Manager

2. **Build the project using Maven**
    ```bash
    mvn clean install

3. **Run the application**
    ```bash
    mvn spring-boot:run

4. **Access in browser**
    ```bash
    http://localhost:8080/books

## Controller Endpoints

| HTTP Method | Endpoint              | Description                              |
|-------------|-----------------------|------------------------------------------|
| GET         | `/books`              | List all books                           |
| GET         | `/books/new`          | Show form to create a new book           |
| POST        | `/create_book`        | Save a new book with cover image         |
| GET         | `/books/{id}/cover`   | Display book cover image (binary data)   |
| GET         | `/search_book`        | Search books by title, author, publisher |
| GET         | `/update_book/{id}`   | Show form to edit an existing book       |
| POST        | `/update_book/{id}`   | Submit edits to a book                   |
| POST        | `/delete/{id}`        | Delete a book                            |

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.