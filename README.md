# spring-cloud-miroservices
config server + eureka server + zuul api gateway + zipkin + slueth + feign client


## Project Objective 

 

Learn to create microservice, based on Spring cloud, on Netflix Eureka registry server and how other microservices (Eureka clients) use it to register and discover services to call their APIs. 

Its required to design and develop  Spring Boot based Spring Cloud API. Its recommending to  use Netflix Eureka server for building the service registry server and Eureka clients which will register themselves and discover other services to call REST APIs. 

## Task  Explanation 

 

As per the requirement its need to design and implement school student registration system , Main Entity are Student and Class . one student can be assigning to many classes while registration. Below operations should be able to operate via external REST Client.  

### CRUD operations for all Student and Classes 

### Assign Student to Classes by API operation. 

### Query all Student records and  Classes by API operation by REST Client. 

#### Student Entity  - studentId ,studentName,age 

#### Class Entity  - classID, className, description  

#### Enrollment Entity  - classID, studentId, updated 

 

 

## Design Diagram  

 
![picture alt](https://github.com/silwathge/spring-cloud-miroservices/blob/main/designdigram.PNG "Design Diagram")
 

 

 

## Development Tips  

 

* These all  services will be a rest based service and most importantly it will be a eureka client service, which will talk with eureka service to register itself in the service registry. 

* Service to service all API calls need to query via service registry . 

* As per design its required to have separate microservices for each entity and need to implement Basic CRUD operation (REST endpoints)  align with  REST industry standards best practices. 

* Eureka service need  implement as separate service and provide health service with monitoring facility. 

* Need to expose all endpoint via API Gateway to outside world within one specific  IP and port to access API via  generic REST Client. 

* Java 8 + JDK version  

* Data Stores – Use Mongo DB Document stores to entity data as JSON document 

* Service Register  – Recommended to use  Eureka with Spring boot configuration  

* API Gateway – Recommended to use  Zulu  with Spring boot configuration . 

* Need to implement Junit Test Cassese for all Service , Controller , DAO classes  using Easy Mock Framework 

* Testing should require some data to be pre provisioned on dependent microservices 

* Create tests to cover all scenarios 

* Data providers to reuse same test to cover multiple scenarios 

* Ability to perform different validations 

* Ability to run independent tests in parallel 

* Ability to update tests easily when updates are made to APIs 

* Project need to be configured on Gradle with required dependencies 

* Need to implement API validations using spring validation framework. 
