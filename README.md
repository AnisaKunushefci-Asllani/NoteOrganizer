# Note Organizer Console Application

A simple Java 17 console application to manage notes with user authentication.  
Users can register, log in, and perform CRUD (Create, Read, Update, Delete) operations on their notes.

---

## Features

- User Registration and Login
- Create, View, Update, and Delete Notes
- Notes include Title, Content, and Tags
- Data persistence via file-based repository (can be extended to database)
- Simple console menu-driven interface

---

## Prerequisites

- Java 17 JDK installed
- Gradle (optional, recommended for building the project)
- An IDE like IntelliJ IDEA, Eclipse, or VS Code (optional)

---

## Project Structure

src/main/java/org/example/noteorganizer/
   ConsoleApp.java # Main console application with menu and entry point
   entity/
     -Note.java # Note entity class
     -User.java # User entity class
   repository/
     -NoteRepository.java # Note repository interface
     -NoteFileRepository.java # File-based implementation for notes
     -UserRepository.java # User repository interface
     -UserFileRepository.java # File-based implementation for users
   service/
     -NoteService.java # Note business logic and operations
     -UserService.java # User business logic and operations

---


## How to Build and Run

### 1. Using Gradle

```bash
./gradlew build       # Compiles the project
./gradlew run         # Runs the ConsoleApp

Or open the ConsoleApp.java and run the application directly using youe IDE

---

==== Note Organizer ====

1. Register
2. Login
3. Exit
Choose: 1
Username: Hera
Password: ****
User registered.

==== Note Organizer ====

1. Register
2. Login
3. Exit
Choose: 2
Username: Hera
Password: ****
Login successful.

1. Create Note
2. View All Notes
3. Update Note
4. Delete Note
5. Logout
Choose: 1
Title: Homework
Content: Homework requierments
Tags: deadline, requirements
Note created.

Choose: 2
ID: 1
Title: Homework
Content: Homework requirements
Tags: deadline, requirements
----

