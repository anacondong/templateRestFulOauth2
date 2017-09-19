"# templateRestFulOauth2" 
Spring Boot + Oauth2 + RestFul <br/>

Require<br/>
Java 8<br/>
Maven<br/>
MY-SQL<br/>

how to run :<br/>
$mvn clean<br/>
$mvn install<br/>
$cd target<br/>
$java -jar templateRestFulOauth2--SNAPSHOT.jar<br/>
OR
$mvn spring-boot:run<br/>

Open PostMan APP
POST >> http://localhost:8081/templateRestFulOauth2/oauth/token?grant_type=password&username=user&password=user
username:root
password:q
POST >> http://localhost:8081/templateRestFulOauth2/oauth/token?grant_type=password&username=user&password=user<br/>
username:root<br/>
password:q<br/>

And then <br/>
GET >> http://localhost:8081/templateRestFulOauth2/private?access_token=72f349e2-0753-4e91-948b-e37c033394be<br/>

