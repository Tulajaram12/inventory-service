# Inventory Service

Inventory microservice for the e-commerce application.

## Technology

- Java 21
- Spring Boot
- Maven
- PostgreSQL
- Docker
- Jenkins
- Kubernetes
- Amazon EKS

## Port

8085

## APIs

### Create Inventory

POST

/api/inventory

Example request:

{
    "productId": 101,
    "quantity": 50
}

### Get All Inventory

GET

/api/inventory

### Get Inventory By ID

GET

/api/inventory/{id}

Example:

/api/inventory/1

### Get Inventory By Product

GET

/api/inventory/product/{productId}

Example:

/api/inventory/product/101

### Update Quantity

PATCH

/api/inventory/product/{productId}?quantity=100

### Reduce Stock

PATCH

/api/inventory/product/{productId}/reduce?quantity=5

### Delete Inventory

DELETE

/api/inventory/{id}

## Run Locally

Make sure PostgreSQL is running.

Database:

ecommerce

Username:

postgres

Password:

postgres

Then run:

mvn spring-boot:run

Application will start on:

http://localhost:8085
