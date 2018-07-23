## # Lesson-SpringJDBC-Demo ##
---


#### What is it? ####
A short project for teaching the new batch of students, Spring Demo as part of the training under [Accolite University](http://accolite.com/career.html#AccoliteUniversity), where I work!

#### What does it contain ####
Each branch within the project represents the next set of assignments. Students are welcome to checkout to the next branch in case they're having trouble with the task

---

#### What are the list of branches ####
Branch | Description
------------ | -------------
master | Contains the initial scaffolding with all dependencies necessary. Students have to make sure the project runs successfully.
java-jdbc | Implement a simple java mysql connector to connect to table with the below mentioned properties
spring-jdbc | Use Spring's JdbcTemplate to implement the query and make sure the results are similar to that obtained from java-jdbc


#### For the sake of completeness, we'll be using configurable properties and not the hardcoded values in order to capture the essence of Spring. Students are welcome to use any key/value pair. A sample pair that's recommended is shown below ####

#### Feel free to edit the connection properties according to your local instance ####

Parameter | Description
------------ | -------------
simpleJdbc.driver | com.mysql.jdbc.Driver
simpleJdbc.db | hk_db
simpleJdbc.table  | doctor
simpleJdbc.user | <username> Remote: User
simpleJdbc.pass | <mysqlPassword> Empty
simpleJdbc.url | jdbc:mysql://localhost:3306/hk_db


#### But.. But? Where's the SQL ####
The SQL containing the schema is located at ***/src/main/resources/schema.sql.***
Create a database connection in your local MySQL instance with the above schema. 
Take care that the connection parameters should reflect the ones stored in your property file for spring to work.

#### Okay. But what port does it run on? ####
Check for yourself at ***/src/main/resources/application.properties***.
If a port is blocked, change the ***server.port*** field and restart.

