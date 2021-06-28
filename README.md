# Reports application
Application runs on spring-boot. It allows to add finished task to database and retrieve all task in simple JSON format.

Endpoints:
- localhost:8080/reports POST
- localhost:8080/reports/clear DELETE
- localhost:8080/report/all GET

For more clarity use:
##### Postman scripts: TODO
##### cURL scripts:
curl --location --request GET 'localhost:8080/report/all'
curl --location --request POST 'localhost:8080/report' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": "INT-1001",
    "startDate": "2021-05-10T12:00:00",
    "endDate": "2021-05-10T13:00:00"
}'
curl --location --request DELETE 'localhost:8080/report/clear'

## Installation
Prerequisites:
- Java (JDK>=16)
- Maven

Run:
```
mvn clean package
```
And then run SpringBoot application by running main class: ReportWebApplication

TODO runConfigurations
