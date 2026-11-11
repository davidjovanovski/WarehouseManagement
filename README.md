# Warehouse Management System

REST API for managing a warehouse: articles, suppliers (companies), categories and purchase orders. Built with Java and Spring Boot as a practice project.

## Tech stack

- Java, Spring Boot
- Spring Data JPA / Hibernate
- Spring Security (session-based login, BCrypt password hashing)
- H2 in-memory database
- Gradle

## Features

- CRUD for articles, categories and companies
- Orders made of order items, each storing its own quantity and purchase price
- Dynamic order filtering by user, status and date range (JPA `Specification`)
- Authentication with a custom `UserDetails` and a registration endpoint
- DTOs for order input, `@Transactional` order creation, custom exceptions mapped to HTTP status codes

## Architecture

Layered structure: `web` → `service` → `repository` → `database`.
