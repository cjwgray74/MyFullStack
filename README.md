# Java Full Stack Experiential Learning
Welcome to the IBM BR CIC Java Full Stack Experiential Learning.  The experiential learning is designed for practitioners
seeking to enrich their Full Stack skills.  The learning leverages the technologies in high demand by our clients.  
These technologies are not limited too but include Java, Spring Boot, Spring Cloud, Docker, Docker Compose, Kubernetes, 
Angular, and React.  Upon successfully implementing the entire learning, there are eight components (containers) that 
should be running simultaneously:  

- Two UIs (Angular and React) running in parallel 
- Four Spring Boot Applications
- Two Databases (SQL or NoSQL).  

The ultimate goal is the Journey to the Cloud which is accomplished by deploying the application to a cloud platform of the your choice:  AWS, Azure, IBM Cloud, Google Cloud, or Red Hat OpenShift.



# Projects in this Repository

|Projects                 |Description                                          |
|-------------------------|-----------------------------------------------------|
|angular-ui               |`Angular UI Project`                                 |
|api-gateway              |`Spring Boot Zuul API Gateway Service`               |
|discovery-service        |`Spring Boot Eureka Discovery Service`               |
|employee-db-docker-image |`Contains Dockerfile for building MySQL Employee DB` |
|employee-service         |`Spring Boot Employee Service`                       |
|login-db-docker-image    |`Contains Dockerfile for building MySQL Login DB`    |
|login-service            |`Spring Boot Login Service`                          |
|registration-service     |`Spring Boot Employee Registration `                 |
|react-ui                 |`React UI`                                           |

# Before You Get Started
> 1. Install [JDK 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) or later.
> 2. Install [Node JS](https://nodejs.org/en/download/)
> 3. Install [Docker Desktop](https://www.docker.com/products/docker-desktop)
> 4. Preferred IDEs.  However, feel free to use the IDE of your choice.
>   * [Spring Tool Suite (STS)](https://spring.io/tools) (Eclipse)
>   * [Visual Studio Code](https://code.visualstudio.com/download)
>   * [IntelliJ Community](https://www.jetbrains.com/idea/download/)
> 5. Create a [Docker Hub Account](https://hub.docker.com/)
> 6. Create an [IBM Cloud Account](https://cloud.ibm.com)
> 7. Create an [IBM GitHub Account](https://github.ibm.com/)
> 8. **Fork** the Git repository to make a copy in your repository.


# Prerequisite Courses (Optional)
If you need a refresher before you start, click the Udemy courses below or a tutorial of your choice.
1. [The Complete Java Development Bootcamp](https://ibm-learning.udemy.com/course/the-complete-java-development-bootcamp/) or a tutorial of your choice.
2. [The Complete Spring Boot Development Bootcamp](https://ibm-learning.udemy.com/course/the-complete-spring-boot-development-bootcamp/) or a tutorial of your choice.
3. [JavaScript Basics for Beginners](https://ibm-learning.udemy.com/course/javascript-basics-for-beginners/) or a tutorial of your choice.
4. [Git for Geeks: Quick Git Training for Developers](https://ibm-learning.udemy.com/course/git-for-geeks/) or a tutorial of your choice.


# Deliverables
The coding challenge should be completed in 4 to 6 weeks.  Code snippets are included in the projects to speed along your progress.  However, you must implement the missing code.


## Activity 1 - Docker Containterization and Spring Cloud 
> #### Udemy Courses
> - [Master Microservices with Java, Spring, Docker, Kubernetes](https://ibm-learning.udemy.com/course/master-microservices-with-spring-docker-kubernetes/) - 24 hours

> #### Tasks
> - Create MySQL Docker Images (Login and Employee Databases).
> - Complete Login Service and Containerize.
> - Complete Employee Service and Containerize.
> - Run images using Docker Compose.
> - Test with Postman and MySQL WorkBench.

## Activity 2 - Spring Cloud Continued
> #### Udemy Courses
> - [Master Microservices with Java, Spring, Docker, Kubernetes](https://ibm-learning.udemy.com/course/master-microservices-with-spring-docker-kubernetes/)  (continued)

> #### Tasks
> - Implement Eureka Discovery and Zuul API Gateway Services.
> - Validate Eureka Discover Service identified:  Login, Employee, and API Gateway Services.
> - Implement Security:  oAuth, JWT, etc.
> - Run using Docker Compose.
> - Test Services via Zuul API Gateway.
> - Start Kafka Training

## Activity 3 - Apache Kafka
> #### Udemy Courses
> - [Kafka & Kafka Stream With Java Spring Boot - Hands-on Coding](https://ibm-learning.udemy.com/course/apache-kafka-with-java-spring-boot-theory-hands-on-coding/) - 20 hours
    
> #### Tasks
> - Implement Kafka Server using Docker Compose.
> - Implement Zookeeper using Docker Compose.
> - Implement APHQ/KafkaHQ using Docker Compose `(optional)`.
> - Implement Kafka DB (NoSQL) using Docker Compose.
> - Implement Kafka Service using Docker Compose.
> - Run Kafka module using Docker Compose.
> - Test Kafka Services and AKHQ/KafkaHQ `(optional)`.
> - Run using Docker Compose.
> - Test with Postman.

## Activity 4 - Journey to the Cloud I

> #### Tasks
> - Deploy backend on Minikube using Kubernetes.
> - Deploy the application on a Cloud platform using Kubernetes.
> - Cloud Platforms:  IBM Cloud, AWS, Azure, GCP, or Red Hat Open Shift
> - Test Services via Zuul API Gateway using Postman.


## Backend Demonstration
> - Services must be running on a Cloud platform implemented using Kubernetes.
> - Be prepared to discuss each service component.


## Activity 5 - Angular &amp; React
> #### Udemy Courses
> - [Full Stack:  Angular and Spring Boot](https://ibm-learning.udemy.com/course/full-stack-application-development-with-spring-boot-and-angular/) - 12.5 hours
> - [Go Java Full Stack with Spring Boot and React](https://ibm-learning.udemy.com/course/full-stack-application-with-spring-boot-and-react/) - 11.5 hours
    
> #### Tasks
> - Implement and Containerize Angular UI. 
> - Ensure screen requirements are implemented.
> - Test Angular UI against service components.
> - Repeat above steps for the React UI.
> - Run using Docker Compose.

## Activity 6 - Journey to the Cloud II
> #### Udemy Courses
> - [Master Microservices with Java, Spring, Docker, Kubernetes](https://ibm-learning.udemy.com/course/master-microservices-with-spring-docker-kubernetes/)  (continued)
    
> #### Tasks
> - Deploy frontend and backend on Minikube.
> - Deploy the application on a Cloud platform using Kubernetes.
> - Cloud Platforms:  IBM Cloud, AWS, Azure, GCP, or Red Hat Open Shift
> - Test application via frontend.  Angular and React frontends should be running in parallel.


## Complete Application Demonstration
> - Deploy UI and  Backend Services on  Minikube.
> - UI and Service components must be running on a Cloud platform using Kubernetes.
> - Be prepared to discuss each application component.
> - Both UIs must run in parallel
> - Test services via UIs.


# Sequence Diagrams

## Login
> #
> ![Login Sequence Diagram](./fscc_sd1.png)
> #

## Add and Edit Employees
> #
> ![Add and Edit Employee Sequence Diagram](./fscc_sd2.png)
> #
