# 🎉 Event Management Application (Spring Boot)

## ℹ️ About
The **Event Management Application** is a backend system built with **Spring Boot 3.0.0** and **Java 17** that allows organizers to efficiently manage events, speakers, attendees, and tickets.  
It supports full **CRUD operations**, **validation**, and **error handling** to ensure reliable event management workflows.  
This project is ideal for learning how to build structured backend APIs with real-world use cases.

---

## 🚀 Features

- Manage **Events**: Create, read, update, delete events
- Manage **Event Schedule Details**: Set start/end times and location
- Manage **Speakers**: Create profiles, assign to events, track experience and event count
- Manage **Tickets**: Create tickets for events, assign to persons, filter by age
- Manage **Persons/Attendees**: Create and view attendee details
- **Validations**:
  - Event name: 3–50 characters
  - Speaker experience: minimum 0 years
  - Ticket price: must be positive
- **Error handling**:
  - Prevent duplicates
  - Handle missing IDs
  - Validation errors return meaningful messages

---

## 🔗 Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/event/{id}` | Get event by ID |
| GET | `/event/all` | Get all events |
| POST | `/event/save` | Create a new event |
| PUT | `/event/update` | Update an event by ID |
| DELETE | `/event/delete/{id}` | Delete an event |
| GET | `/speaker/{id}` | Get speaker by ID |
| GET | `/speaker/all` | Get all speakers |
| POST | `/speaker/save` | Create a new speaker |
| POST | `/speaker/id/{speakerId}/eventId/{eventId}` | Assign speaker to event |
| GET | `/ticket/{id}` | Get ticket by ID |
| GET | `/ticket/all` | Get all tickets |
| POST | `/ticket/save` | Create a new ticket |
| GET | `/ticket/allByAge/{age}` | Get tickets filtered by age |
| GET | `/person/{id}` | Get person by ID |
| GET | `/person/all` | Get all persons |
| GET | `/eventScheduleDetail/{id}` | Get event schedule detail by ID |
| GET | `/eventScheduleDetail/all` | Get all event schedule details |
| POST | `/eventScheduleDetail/save` | Create a new event schedule detail |

---

## 🛠️ Tech Stack

- Java 17  
- Spring Boot 3.0.0  
- Spring Web  
- Jakarta Validation API  
- H2 Database (or in-memory storage with List + Map)  
- Maven  

---

## ▶️ Running the Application

Clone this repository:

```bash
git clone https://github.com/yourusername/event-management-app.git
