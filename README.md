# VenueSnap Backend README
---
# Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Architecture](#architecture)
4. [Main Files](#main-files)
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

- **RESTServiceApplication.java**: The main entry point of the Spring Boot application.
- **WebConfig.java**: Configuration class for setting up CORS mappings to allow cross-origin requests from specified origins[1].
- **EventControllerTest.java**: Test class for the EventController, containing unit tests for various event-related operations[2].
- **AttendeeServiceTest.java**: Test class for the AttendeeService, containing unit tests for attendee management operations[3].

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

