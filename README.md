"# templateRestFulOauth2" 
Spring Boot + Oauth2 + RestFul

Require
Java 8
Maven
MY-SQL

how to run :
$mvn clean
$mvn install
$cd target
$java -jar templateRestFulOauth2--SNAPSHOT.jar

Open PostMan APP
POST >> http://localhost:8081/templateRestFulOauth2/oauth/token?grant_type=password&username=user&password=user
username:q
password:q

GET >> http://localhost:8081/templateRestFulOauth2/private?access_token=72f349e2-0753-4e91-948b-e37c033394be

