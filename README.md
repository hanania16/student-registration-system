# 🎓 Student Registration System (CLI)

## 📌 Team Members
- Hanania Meseret
- Lielt Leul
- Martha Habtamu
- Yeabsira Mitiku

---

## 📖 Overview
This is a **console-based Java application** that allows **students** to register for, drop, and view courses, while **admins** can manage course offerings.

The system supports:
- Role-based login (Student / Admin)
- Course management
- Student registration management
- Database persistence with PostgreSQL
- File logging for activity tracking
- Exception handling for better reliability

---

## ✨ Features

### **For Admins**
- Login with admin credentials
- View all available courses
- Add a new course
- Delete a course
- View all registered students
- Delete a student

### **For Students**
- Login with student credentials
- View available courses
- View registered courses
- Register for a course
- Drop a course

---

## 🛠 Technologies Used

- **Java** (Object-Oriented Programming)
- **JDBC** for database operations
- **PostgreSQL** (recommended) or SQLite
- **File I/O** (BufferedWriter, FileReader) for logging
- **Collections**: List, Set, Map
- **Custom Exceptions** for better error handling

---

## 📂 Project Structure
src/
│
├── Abstract/ # Abstract base classes
├── dao/ # Data Access Objects (JDBC)
├── exception/ # Custom exceptions
├── model/ # Data models (User, Student, Admin, Course)
├── service/ # Business logic
├── ui/ # CLI menu classes
├── util/ # Utility classes (Database connection, Config)
└── Main.java # Entry point

## How to Run

1. Compile
javac -cp "lib/*;src" -d out src/Abstract/*.java src/dao/*.java src/model/*.java src/ui/*.java src/util/*.java src/service/*.java src/Main.java

2. Run
java -cp "lib/*;out" Main

## 🔑 Login Information
Admin Login
Username: admin1
Password: adminpass

Student Login
Username: john
Password: studpass

## 📌 Usage Instructions
<prev>
Admin Menu
    === Admin Menu ===
    1. View All Courses
    2. Add Course
    3. Delete Course
    4. View All Students
    5. Delete Student
    6. Logout

Student Menu
    === Student Menu ===
    1. View Available Courses
    2. View My Courses
    3. Register for a Course
    4. Drop a Course
    5. Logout
