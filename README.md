# **My Full Stack Project**
## **Overview**
This project is a Full Stack application built using **Java Spring Boot** following a **microservices architecture**. The backend comprises several services such as API Gateway, Discovery Service, Employee Service, Login Service, and Registration Service. The frontend is developed using **Angular**, with **JWT (JSON Web Token)** implemented for secure login. **Apache Kafka** is used for messaging between microservices, ensuring seamless and scalable communication.
## **Table of Contents**
1. [Prerequisites](#prerequisites)
2. [Installation](#installation)
3. [Running the Application](#running-the-application)
4. [Services](#services)
    - API Gateway Service
    - Discovery Service
    - Employee Service
    - Login Service
    - Registration Service

5. [Security](#security)
6. [Messaging](#messaging)

## **Prerequisites**
Ensure the following tools and dependencies are installed before setting up the project:
- **Java 17** or higher
- **Maven** (for dependency and build management)
- **Apache Kafka** (for messaging between microservices)
- **Podman** (for containerization)

## **Installation**
Follow these steps to set up the project on your local machine:
1. **Clone the Repository**
``` bash
   git clone https://github.com/user/my-fullstack-project.git
   cd my-fullstack-project
```
1. **Build the Services**
   Navigate into each service directory and build them using Maven:
``` bash
   mvn clean install
```
1. **Start Kafka Broker**
   Set up and start your Kafka broker for enabling message communication between services.
2. **Containerize**
   Use **Podman** to containerize the services and ensure all are running properly:
``` bash
   podman-compose up
```
3. Ensure all microservices are registered and communicating through the **Discovery Service**.

## **Services**
### **1. API Gateway Service**
- Acts as the central entry point for all incoming requests.
- Provides **routing, load balancing, and security**.

### **2. Discovery Service**
- Built using **Netflix Eureka**, enabling dynamic service discovery.
- Facilitates communication between microservices without hardcoding their addresses.

### **3. Employee Service**
- Responsible for managing employee data.
- Enables **CRUD operations** through REST APIs.

### **4. Login Service**
- Handles **user authentication** using **JWT**.
- Ensures secure login and token-based authorization.

### **5. Registration Service**
- Manages user **registration and onboarding processes**.

## **Security**
- **JSON Web Token (JWT)** is implemented for authorization and secure login workflows.
- Protect the secret key used in JWT to ensure data security and prevent unauthorized access.

## **Messaging**
- **Apache Kafka** is used to facilitate **asynchronous messaging** between microservices.
- Ensures reliable, scalable communication for managing workflows and event streams.


