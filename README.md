# Event Management System

A **Java Spring Boot** backend application for managing events, speakers, tickets, and schedules. This project demonstrates the use of RESTful APIs, entity relationships, exception handling, and database operations with MySQL.

---

## Features

- **Event Management**
  - Create, update, delete, and view events.
  - Associate events with schedules and speakers.

- **Speaker Management**
  - Add, view, and manage speakers.
  - Assign speakers to events.
  - Filter speakers by experience and event count.

- **Ticket Management**
  - Create and view tickets.
  - Filter tickets by customer age.
  - Associate tickets with events and persons.

- **Event Schedule Management**
  - Define event start and end times.
  - Assign locations to events.

- **Person Management**
  - Manage attendee information.

- **Exception Handling**
  - Custom exceptions: `NotFoundException`, `InvalidInputException`, `ElementAlreadyExistException`.
  
- **Postman Collection**
  - Pre-defined API requests for testing endpoints.

---

## Tech Stack

- **Backend:** Java 17, Spring Boot, Spring Data JPA, Hibernate  
- **Database:** MySQL  
- **Testing:** Postman  
- **Build Tool:** Maven  

---

## Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL
- Postman (for testing APIs)

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/Kurdekar1101/event-management.git
