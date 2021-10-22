# Shool test project
<br>
<br>
<h3>Spring Boot + DB Docker</h3> <br>
<h4>Topic: School - Team 4</h4> <br>
Necessary classes: <br>

<br>
The idea for this project is to store and acess data about the students,teachers and classes of a school.The class students have a relation Many to one with the class Class and 
the class Teacher have an relationship Many to Many with the class Class.

<br>

Model: <br>
- Class
- Student
- Teacher

repository:
- ClassRepository
- StudentRepository
- TeacherRepository
<br>

service:
- ClassService
- StudentService
- TeacherService

<br>
controller:
- ClassController
- TeacherController
- StudentController

<br>
request:
- ClassCreationRequest
- StudentCreationRequest
- TeacherCreationRequest

<br>
return:
- ClassReturnResponse
- TeacherReturnResponse
- StudentReturnResponse
- TeacherClassReturnResponse
<br>

<br>
exception:
- ClassNotFound
- StudentNotFound
- TeacherNotFound
<br>

<br>
<br>



