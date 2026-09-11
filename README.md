# Student Placement Management System

A Java-based Student Placement Management System built using OOP, DSA concepts and MySQL.

## Features
- Add and manage student records
- Add and manage company records
- Check student eligibility using percentage/CGPA
- Search students by name
- Sort students by percentage
- Track placement status
- MySQL database schema included
- Simple console-based interface for easy demonstration

## Tech Stack
- Java
- OOP
- ArrayList and Comparator (DSA/data handling concepts)
- MySQL
- JDBC
- Maven

## How to Run
1. Install Java 17+ and Maven.
2. Create a MySQL database using `database/schema.sql`.
3. Update the MySQL username/password in `src/main/java/com/abhishek/placement/DatabaseConnection.java` if you want database connectivity.
4. Run:

```bash
mvn compile
mvn exec:java
```

The application can also demonstrate core features using sample in-memory data when MySQL is not configured.

## Author
Abhishek Meena
CSE-AIML | Oriental Institute of Science & Technology, Bhopal
