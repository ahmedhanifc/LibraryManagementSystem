# LibraryManagementSystem
## **Overview**

This **Library Management System** is a Java-based application designed to manage library items such as books, DVDs, and journals. The program provides functionalities for searching, reserving, checking out, and returning items. It demonstrates core programming concepts such as **object-oriented programming**, **functional programming with streams**, and **error handling**.

---

## **Features**

- **Manage Library Items**: Add, remove, or display library items including books, DVDs, and journals.
- **Search by Genre**: Filter items by genre using Java Streams.
- **Reserve and Loan Items**: Reserve or check out items while enforcing borrowing rules.
- **Overdue Management**: Display due dates and notify users about overdue items.
- **Dynamic Filtering**: Use lambda expressions to group, sort, and count items.
- **Modular Design**: Includes interfaces (`Reservable`, `Loanable`) to enhance scalability.

---

## **Technologies Used**

- **Java 8+**: Core programming language.
- **Java Streams and Lambdas**: For filtering, sorting, and aggregations.
- **Object-Oriented Programming (OOP)**: Abstract classes, inheritance, and polymorphism.

---

## **How to Run**

1. **Requirements**:
   - Java Development Kit (JDK) 8 or higher.
   - Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or VS Code.

2. **Steps to Execute**:
   - Clone or download the project files.
   - Open the project in your preferred IDE.
   - Compile and run the `MainLibrary` class.
   - Follow the on-screen menu to interact with the program.

---

## **Usage**

### **Command-Line Interface**
The program provides a user-friendly CLI for operations:
- Search items by genre or author.
- Reserve or check out library items.
- Return borrowed items.
- List all items sorted by category.

## **Code Structure**

- **LibraryManagement.java**:
  Core logic for managing library items, including methods for adding, removing, and searching items.

- **LibraryItem.java**:
  Abstract base class representing a library item with common attributes like title, author, and genre.

- **Book.java, DVD.java, Journal.java**:
  Subclasses of `LibraryItem`, representing specific item types with additional attributes.

- **MainLibrary.java**:
  Entry point of the application with CLI logic.

---

## **Sample Queries**

1. **Find Items by Genre**:
   - Input a genre to display all items of that type, sorted alphabetically.

2. **Reserve or Loan Items**:
   - Input a title to reserve or borrow an item.

3. **List Checked-Out Items**:
   - Displays all borrowed items and their due dates.

4. **Find Longest Book**:
   - Identifies the book with the most pages.

---

## **Future Enhancements**

- Implement a database for persistent storage of library items.
- Add advanced GUI features using **JavaFX**.
- Include user authentication for personalized borrowing history.
- Provide reports and analytics on library usage.

---
