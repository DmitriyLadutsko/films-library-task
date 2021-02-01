# films-library-task

## Godel Java Mastery 2021 test task

### Application for searching the database for information about directors and films created by them.

The application provides the ability to search by the following criteria:
- last names of the director (can use the first letters)
- the time period during which the films were released

The following endpoints have also been created but not yet implemented on the UI: 
- adding/updating a director
- adding/updating a film

#### The following technologies were used for the development:
- JDK 11
- Maven 3.6.1
- Spring Boot 2.4.2 (Spring Web, Spring Data JPA, PostgreSQL Driver, Flyway Migration, Lombok)
- PosgreSQL 10.15 DB
________________________

**_Before building and running the app:_**

- Clone the repository with the app by following [link](https://github.com/DmitriyLadutsko/films-library-task.git) to the local directory or download the ZIP archive from the same link
- Сreate a new database and a new user in PostgreSQL from psql console:
 ```
   CREATE DATABASE movies;
   CREATE USER director WITH ENCRYPTED PASSWORD '1234';
   GRANT ALL PRIVILEGES ON DATABASE movies TO director;
```
**_Build and launch the app:_**

- run a *cmd* from the root directory of the application and enter the following command: ```mvnw package```
- after building the application, you need to run the jar-file created in the directory *target/* :
```java -jar target/films-library-0.0.1-SNAPSHOT.jar```

The app is running. 

Migration sql-scripts automatically populate the created movies database with the initial values. (Their physical location: *films-library/src/main/resources/db.migration)*

You can try it out at the address in the browser: ```http//localhost:8070/filmslibrary-api```

