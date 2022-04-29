# company-coordinator-app
App to coordinate and organise company relationships using an H2 Database.

Getting Started
---------------

These instructions will get you a copy of the project up and running on
your local machine for development and testing purposes.

### Prerequisites

Ensure you have Java 11 or higher installed on your machine. To check,
run the following on the command line:

`java --version`11

If you do not have Java installed, you should get a prompt to do so.
Once installed,

you should also have access to `javac`. You can check this by running:

`javac --version`11

### Up and Running Options

To run this locally, use this command in your terminal: `java -jar ./target/company-coordinator-app-0.0.1-SNAPSHOT.jar`

To run as a Docker image with Spring profiles ('prod') run: `docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 -t springio/gs-spring-boot-docker`

To run with docker-compose `docker-compose build && docker-compose up`

### API Calls

Your API should respond to the following API calls:
 
`GET /organizations`
`GET /organizations/{id}` 
`GET /organizations/{id}/applications`
 
The caller should be able to filter the endpoint: `/organizations/{id}/applications` 
query (a partial name)
sort=(column to sort on),(asc|desc)
 
For example:
`/organizations/3/applications?query=C` (returns the data with applications beginning with C)
`/organizations/3/applications?query=C&sort=name,desc` (returns the data with applications beginning with C and sorts in desc)

