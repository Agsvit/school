# School test project
<br>
<br>
<h3>Spring Boot + DB Docker</h3> <br>
<h4>Topic: School - Team 4</h4> <br>
Necessary classes: <br>

<br>
The idea for this project is to store and acess data about the students,teachers and classes of a school.The class students have a relation Many to one with the class Class and 
the class Teacher have an relationship Many to Many with the class Class. Basic CRUD will be created for each model.

# Instructions
In order to get the api running you need to install docker https://docs.docker.com/get-docker/ 

create and acount https://hub.docker.com/ 

if you're using intellij IDEA install docker plugin on it

When oppening the project you need to run the project path in terminal 

``` docker-compose -f src\main\resources\docker\docker-compose.yml up ```
``` docker ps ``` --> to check if u r in the right place 
and run the project
``` mvn spring-boot:run ```



