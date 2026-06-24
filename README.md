# SmartPark API

## Overview

SmartPark is a REST API application for managing parking lots and vehicles.

Features:

* Register parking lot
* Register vehicle
* Check-in vehicle
* Check-out vehicle
* View parking occupancy
* View parked vehicles

## Technology Used

* Java 8
* Spring Boot 2.6.15
* Spring Web
* Spring Data JPA
* Hibernate
* H2 Database
* Maven
* Lombok

## Project Creation

Created using Spring Initializr:

https://start.spring.io/

Dependencies added:

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

Application URL:

```
http://localhost:8080
```

## Database

Using H2 In-Memory Database.

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

## Preloaded Data

Initial data is loaded using:

```
src/main/resources/data.sql
```

Sample:

Parking Lot:

```
LOT001
Location: MANILA
Capacity: 10
```

Vehicles:

```
ABC-123 - Car
XYZ-999 - Truck
```

## API Endpoints

### Register Parking Lot

POST

```
/api/lots
```

Example:

```json
{
  "lotId":"LOT002",
  "location":"MAKATI",
  "capacity":5
}
```

### Register Vehicle

POST

```
/api/vehicles
```

### Check-in Vehicle

POST

```
/api/vehicles/{plate}/checkin/{lot}
```

### Check-out Vehicle

POST

```
/api/vehicles/{plate}/checkout
```

### View Parking Lot

GET

```
/api/lots/{id}
```

### View Vehicles in Lot

GET

```
/api/lots/{id}/vehicles
```

## Business Rules Implemented

* Cannot park when lot is full
* Vehicle can only be parked in one lot
* Occupied spaces update during check-in/check-out
* Available spaces are calculated automatically
* Validation for license plate, owner name, and vehicle type

## Testing

APIs tested using Postman.

Tested:

* Successful requests
* Validation errors
* Duplicate records
* Full parking lot
* Check-in/check-out flow
