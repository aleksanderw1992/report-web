# Reports application
Application runs on spring-boot. It allows to add finished tasks to database and retrieve all task in simple JSON format.

Endpoints:
- [POST] localhost:8080/reports 
- [DELETE] localhost:8080/reports/clear
- [GET] localhost:8080/report/all

For more clarity use:
##### Postman scripts:
Please import the following Postman collection to perform REST requests:
`/report-web/src/main/resources/postman/Reports.postman_collection.json` 
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

#### Manual process
```
mvn clean package
```
And then run SpringBoot application by running main class: com.alex.wojcik.reportweb.ReportWebApplication
#### Running in Intellij IDEA
Please use the following configurations in RunConfigurations menu:
- clean package test
- ReportWebApplication


The application will run at `localhost:8080` after the following log appears:
```
021-06-28 16:12:15.394  INFO 82251 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
```

## Acknowledgements
Assuming we can create a task with start date equals to end date.
