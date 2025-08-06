# 🎓 Student Registration System (CLI)

## 👥 Team Members
- Hanania Meseret 
- Lielt Leul 
- Martha Habtamu 
- Yeabsira Mitiku 

---

## 📖 Project Overview
The Student Registration System is a console-based Java application designed to allow students to register for, drop, and view courses, while admins can manage course offerings and students.

The system includes:
- Role-based login (Student / Admin)
- Course management by admins
- Student course registration
- Database persistence with PostgreSQL
- File logging for activity tracking
- Custom exception handling for robust execution

---

## ✨ Features

### 🔹 Admin
- Login with admin credentials
- View all available courses
- Add new courses
- Delete courses
- View all registered students
- Delete students

### 🔹 Student
- Login with student credentials
- View available courses
- View registered courses
- Register for a course
- Drop a course

> 📝 **Note:** There is **no feature to add departments via the application**.  
> Departments are already pre-inserted in the database.  
> During registration, the student must choose from one of the existing department IDs and names:

```sql
id |          name
----+------------------------
 1  | Computer Science
 2  | Information Technology
 3  | Electrical Engineering

## 📂 Project Structure
src/
│
├── Abstract/ # Abstract base classes
├── dao/ # Data Access Objects (JDBC queries)
├── exception/ # Custom exception classes
├── model/ # Data models (User, Student, Admin, Course)
├── service/ # Business logic
├── ui/ # CLI menus for Admin & Student
├── util/ # Database connection and configuration
└── Main.java # Entry point
lib/ # JDBC driver (.jar)
out/ # Compiled .class files

<pre> ```

## 🗄 Database Tables
The system requires the following PostgreSQL tables:

-- Departments table
CREATE TABLE departments (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Users table (admins and students)
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(20) NOT NULL, -- 'ADMIN' or 'STUDENT'
    department_id INT REFERENCES departments(id)
);

-- Students table (linked to users)
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    course_id INT REFERENCES courses(id) ON DELETE SET NULL
);

-- Courses table
CREATE TABLE courses (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    capacity INT NOT NULL,
    department_id INT REFERENCES departments(id)
);

    CREATE TABLE registrations (
    id SERIAL PRIMARY KEY,
    student_id INT NOT NULL REFERENCES students(id) ON DELETE CASCADE,
    course_id INT NOT NULL REFERENCES courses(id) ON DELETE CASCADE,
    registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```</pre>



🚀 Setup & Execution

1️⃣ Clone the repository
git clone https://github.com/hanania16/student-registration-system.git

cd student-registration-system

2️⃣ Add PostgreSQL JDBC driver
Download from:
PostgreSQL JDBC Driver
Place it in the lib/ folder.

3️⃣ Configure database connection
Edit your Database.java or db.properties file:

properties
db.driver=org.postgresql.Driver
db.url=jdbc:postgresql://localhost:5432/Student_RegistrationDB
db.username=postgres
db.password=1234567

4️⃣ Compile
javac -cp "lib/*;src" -d out src/Abstract/*.java src/dao/*.java src/model/*.java src/ui/*.java src/util/*.java src/service/*.java src/Main.java

5️⃣ Run
java -cp "lib/*;out" Main
🔑 Default Login Credentials

Admin
Username: admin1
Password: adminpass

Student
Username: john
Password: studpass

📌 Menu Navigation
<prev>
Admin Menu
=== Admin Menu ===
1. View All Courses
2. Add Course
3. Delete Course
4. View All Students
5. Delete Student
6. Logout
</prev>

Student Menu
<prev>
=== Student Menu ===
1. View Available Courses
2. View My Courses
3. Register for a Course
4. Drop a Course
5. Logout
</prev>

📜 Team Contributions

Hanania Meseret – Implemented authentication, PostgreSQL integration, and business logic,1 classe from model.

Lielt Leul – Designed DAO classes, handled SQL queries, and database schema.

Martha Habtamu – Implementing the RegistrationService class, Creating and using custom exceptions,2 classes from model.

Yeabsira Mitiku – uilt UI menus, handled input/output, and connected menus to services.
anaged logging system, and, exception handling.
