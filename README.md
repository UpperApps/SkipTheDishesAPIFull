# SkipTheDishesAPIFull

This API project was created to the Skip the Dishes challenge in the VanHackathon Fair in São Paulo, Brazil.
This repository maintains the full code developed according to the chellange proposed.

The project was developed using the Spring Boot Framework and the MySQL Database. To reproduce de database import the Skip the Dishes.mwb (model) file into the MySQL Workbench (https://www.mysql.com/products/workbench/) and then proceed the forward engineering to create the database. To execute the project just clone this repository and import the project into the NetBeans IDE (to use in Eclipse will be required some adjustments), then execute the project as a Spring Boot Application (NB Spring Boot plugin is required: https://github.com/AlexFalappa/nb-springboot/wiki).

The project uses Swagger for documentation, so when the project is running you can use the following link to see the documentation and to test the API: http://localhost:8080/swagger-ui.html

** Enjoy! **

## Further works

- Add an authentication/authorization process with a database persistence.
- Add authorization control in the resources.
- Add the cancel opperation to Orders.
- Add the get Order status opperation .
- Improve the error handling.
- And much, much more... The sky is the limit. :smile:

## P.S.: It was included a basic authentication process to the API using JSON Web Token (JWT).
So, in order to login and take an authorization token is necessary to access the uri /login with the follow heather payload:

```
{"username":"admin", "password":"password"}
```