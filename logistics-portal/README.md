# Logistics Pickup Request Portal (Spring Boot)

## Overview
A minimal Spring Boot application to manage pickup requests for campus/office logistics. Includes entities, repos, services and REST controllers.

## Requirements
1. JDK 17
2. Maven 3.8+
3. PostgreSQL (create database `logisticsdb`) — pgAdmin can be used to manage the DB
4. (Optional) Thunder Client or Postman for API calls

## Setup
1. Clone or unzip the project.
2. Update `src/main/resources/application.properties` with your PostgreSQL username/password and DB name.
3. Create the database in PostgreSQL (example):
   - Connect via pgAdmin and run: `CREATE DATABASE logisticsdb;`
4. Build and run:
   ```bash
   mvn clean package
   mvn spring-boot:run
   ```
   The app runs on http://localhost:8080 by default.

## Endpoints (examples)
- `POST /api/users` — register user
- `GET /api/users` — list users
- `POST /api/pickuprequests` — create pickup request
- `GET /api/pickuprequests/{id}` — get request
- `GET /api/pickuprequests/user/{id}` — requests by user
- `POST /api/pickuprequests/{id}/assign` — assign staff (`{ "staffUserId": 2, "remarks": "..." }`)
- `POST /api/pickuprequests/{id}/status` — update status (`{ "status": "Completed", "remarks": "..." }`)
- `GET /api/pickuplogs/request/{id}` — logs for a request
- `GET /api/reports/pendingrequests` — pending
- `GET /api/reports/completedrequests` — completed

## Notes & Extensions
- This project uses Lombok — enable Lombok support in your IDE.
- No authentication included — for production add role-based auth (Spring Security + JWT).
- Addresses are validated minimally; you can extend using a geolocation API.
