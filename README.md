# CharityTracker

A beginner-friendly Java console application to track charities and their donations.

## Features

- Add charities with a name, cause, and contact email
- View all charities and their donation totals
- Record donations for a selected charity
- View the donation history for each charity
- Display a summary of donations across all charities
- Basic input validation

## Concepts used

- Classes and objects
- Encapsulation (private fields and getters)
- ArrayList and List
- Loops and conditional statements
- Methods
- Scanner for user input
- Basic exception handling
- `LocalDate` for donation dates

## Requirements

- Java JDK 8 or later

## Run the application

1. Download or clone this repository.
2. Open a terminal in the project folder.
3. Compile the Java files:

   ```bash
   javac -d out src/*.java
   ```

4. Run the application:

   ```bash
   java -cp out CharityTrackerApp
   ```

## Notes

This is a simple learning project. Data is stored in memory, so charities and donations are cleared when the program exits. No real payments are processed.
