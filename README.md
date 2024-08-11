# VenueSnap Backend
---

# Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Architecture](#architecture)
4. [Main Files](#main-files)
   - [EventController.java](#eventcontrollerjava)
   - [Event.java](#eventjava)
   - [EventRepository.java](#eventrepositoryjava)
   - [EventService.java](#eventservicejava)
5. [Setup Instructions](#setup-instructions)
   - [Prerequisites](#prerequisites)
   - [Deployment Steps](#deployment-steps)
6. [API Endpoints](#api-endpoints)
7. [License](#license)
8. [Contact](#contact)

## Overview

VenueSnap is an event management platform backend, designed to facilitate the organization and management of events. It is built using Spring Boot and is containerized using Docker for deployment on an AWS EC2 instance. The application utilizes MySQL as its database, hosted on an Amazon RDS instance.

## Features

- **Event Management**: Create, update, delete, and retrieve events.
- **Attendee Management**: Manage event attendees with functionalities to create, update, and delete attendee records.
- **RESTful API**: Provides endpoints for managing events and attendees.

## Architecture

- **Backend**: Spring Boot application.
- **Database**: MySQL hosted on AWS RDS.
- **Containerization**: Docker image for deployment.
- **Hosting**: AWS EC2 instance.

## Main Files

# Main Files

1. **EventController.java**: This file defines the RESTful API endpoints for managing events. It includes operations such as:
   - **Get an event by ID**: Retrieve a specific event using its ID.
   - **Get all events**: Retrieve all events with optional filtering by `venueId` or `date`.
   - **Create a new event**: Add a new event to the database.
   - **Update an existing event**: Modify the details of an existing event.
   - **Delete an event by ID**: Remove an event from the database using its ID[1].

2. **Event.java**: This file represents the Event entity, mapped to the "events" table in the database. It includes fields such as:
   - `eventId`: Unique identifier for the event.
   - `eventName`: Name of the event.
   - `date`: Date of the event.
   - `venueId`: Identifier for the venue where the event is held.
   - `image`: URL or path to an image associated with the event.
   - It also contains the necessary getters and setters for these fields[2].

3. **EventRepository.java**: This file is an interface extending `JpaRepository`, providing methods for accessing event data. It includes custom query methods such as:
   - `findByVenueId(int venueId)`: Retrieve events based on the venue ID.
   - `findByDate(String date)`: Retrieve events occurring on a specific date[3].

4. **EventService.java**: This file contains the business logic for event management. It interacts with the `EventRepository` to perform operations such as:
   - `getEventById(int eventId)`: Retrieve a specific event by its ID.
   - `createEvent(Event newEvent)`: Save a new event to the database.
   - `getAllEvents()`: Retrieve all events.
   - `updateEvent(int eventId, Event updatedEvent)`: Update the details of an existing event.
   - `deleteEvent(int eventId)`: Delete an event by its ID.
   - `getEventsByVenueId(int venueId)`: Retrieve events based on the venue ID.
   - `getEventsByDate(String date)`: Retrieve events occurring on a specific date[4].

## Setup Instructions

### Prerequisites

- Java 11 or higher
- Docker
- AWS account with access to EC2 and RDS

### Deployment Steps

1. **Build the Docker Image**:
   - Navigate to the project directory.
   - Run the following command to build the Docker image:
     ```bash
     docker build -t venuesnap .
     ```

2. **Deploy on AWS EC2**:
   - Launch an EC2 instance and SSH into it.
   - Pull the Docker image from your Docker repository.
   - Run the Docker container:
     ```bash
     docker run -d -p 8080:8080 venuesnap
     ```

3. **Setup MySQL on RDS**:
   - Create a MySQL database on Amazon RDS.
   - Update the application properties file with the RDS endpoint and credentials.

4. **Access the Application**:
   - Open a web browser and navigate to `http://<EC2-Instance-IP>:8080/events` to access the event management API.

## API Endpoints

- **GET /events**: Retrieve all events.
- **GET /events/{id}**: Retrieve a specific event by ID.
- **POST /events**: Create a new event.
- **PUT /events/{id}**: Update an existing event.
- **DELETE /events/{id}**: Delete an event by ID.

## Contributors
- [Vanessa Rice](https://github.com/infuriated-mink)
- [Evan Harte](https://github.com/evanharte)
- [Dillon Regular](https://github.com/vapidsoup)
- [Ethan Miller](https://github.com/ethanmiller758)

## License

VenueSnap is licensed under the MIT License. See `LICENSE` for more information.

