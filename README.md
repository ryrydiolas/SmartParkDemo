# SmartPark API

REST API application for managing parking lots and vehicles.

## Features

* Register parking lot
* Register vehicle
* Vehicle check-in
* Vehicle check-out
* View parking occupancy
* View parked vehicles

## Technology

* Java 8
* Spring Boot 2.6.15
* Spring Web
* Spring Data JPA
* Hibernate
* H2 Database
* Maven
* Lombok

## Project Setup

Created using **Spring Initializr**:

https://start.spring.io/

Dependencies:

* Spring Web
* Spring Data JPA
* H2 Database
* Validation
* Lombok

## Run Application

Build:

```bash
mvn clean install
```

Run:

```bash
mvn spring-boot:run
```

Application:

```
http://localhost:8080
```

## Database

Using H2 in-memory database.

H2 Console:

```
http://localhost:8080/h2-console
```

Connection:

```
JDBC URL:
jdbc:h2:mem:smartpark

Username:
sa

Password:
admin123
```

## Initial Data

Loaded from:

```
src/main/resources/data.sql
```

Sample:

```
LOT001 - MANILA - Capacity 10

ABC-123 - Car
XYZ-999 - Truck
```

## API Endpoints

| Method | Endpoint                            | Description          |
| ------ | ----------------------------------- | -------------------- |
| POST   | /api/lots                           | Register parking lot |
| POST   | /api/vehicles                       | Register vehicle     |
| POST   | /api/vehicles/{plate}/checkin/{lot} | Check-in             |
| POST   | /api/vehicles/{plate}/checkout      | Check-out            |
| GET    | /api/lots/{id}                      | View occupancy       |
| GET    | /api/lots/{id}/vehicles             | View parked vehicles |

## Rules Implemented

* Cannot park when lot is full
* Vehicle can only be parked in one lot
* Occupied spaces update automatically
* Available spaces calculated automatically
* Validation for:

  * License plate
  * Owner name
  * Vehicle type

## Testing

### Unit Test

JUnit tests included.

Run:

```bash
mvn test
```

Covered:

* Application startup
* License plate validation
* Owner name validation
* Vehicle type validation

### API Test

Postman collection included:

```
SmartPark.postman_collection.json
```

Tested:

* Register parking lot
* Register vehicle
* Check-in/check-out
* Validation errors
* Duplicate records
* Full parking lot scenario
