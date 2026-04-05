# Finance Data Processing and Access Control Backend

## Overview

This project is a backend system for a finance dashboard that manages financial records, user roles, and summary analytics.

It is built using Spring Boot and demonstrates clean backend architecture, API design, data handling, and role-based access control.

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database (in-memory)
* Maven

---

## Architecture

The project follows a layered architecture:

Controller → Service → Repository → Database

* Controller: Handles API requests
* Service: Contains business logic
* Repository: Handles database operations

---

## Role-Based Access Control

Roles supported:

* ADMIN → Full access (create records)
* VIEWER / ANALYST → Read-only access

Access control is implemented in the service layer.

---

## Features

### Financial Records Management

* Create records
* Fetch all records
* Filter records by type and category

### Dashboard Summary APIs

* Total Income
* Total Expense
* Net Balance

### Validation and Error Handling

* Input validation using annotations
* Global exception handling for clean error responses

---

## API Endpoints

### Create Record (ADMIN only)

POST /records

Headers:
role: ADMIN

Body:
{
"amount": 5000,
"type": "INCOME",
"category": "Salary",
"date": "2026-04-05"
}

---

### Get All Records

GET /records

---

### Filter Records

GET /records/filter?type=INCOME&category=Salary

---

### Dashboard APIs

GET /records/summary/income
GET /records/summary/expense
GET /records/summary/net

---

## How to Run

1. Clone the repository:
   git clone <your-repo-link>

2. Navigate to project folder:
   cd financeapp

3. Run the application:
   mvn spring-boot:run

Or run directly from IntelliJ

4. Server starts at:
   http://localhost:8080

---

## Testing

You can test APIs using:

* Postman
* Curl
* Browser (for GET requests)

---

## Assumptions

* Role is passed via request header for simplicity
* H2 database is used for quick setup
* Authentication (JWT) is not implemented

---

## Future Improvements

* JWT-based authentication
* Pagination and search
* Persistent database (MySQL/PostgreSQL)
* Advanced filtering and analytics

---

## Conclusion

This project demonstrates backend development fundamentals including API design, data modeling, validation, and role-based access control using a clean and maintainable structure.
