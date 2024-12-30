# Real Software Development (real-software-dev)

This repository contains practical exercises, code examples, and projects inspired by the book **"Desenvolvimento Real de Software"** by Raoul Gabriel Urma and Richard Warburton, published by O'Reilly and Alta Books Editora. The purpose is to practice and apply real-world software development principles.

## Project Overview
The repository focuses on developing software using clean code, testing practices, and modern Java features. It includes code implementations, tests, and additional examples for concepts covered in the book.

### Key Features:
- Parsing and processing CSV files with Java.
- Unit testing using JUnit.
- Functional programming with Streams.
- Handling exceptions like `DateTimeParseException` and `NumberFormatException`.
- Custom utility classes for validating and processing data.
- Working with Git for version control.

## Contents

### Current Implementations
- **CSV Parsing:**
  - Parsing bank transaction data from CSV files.
  - Validating date formats and numeric values.
- **Business Logic:**
  - Calculating the maximum debit within a date range.
  - Finding the largest negative (debit) transaction.
- **Testing:**
  - Unit tests using JUnit for all critical methods.
  - Examples of exception handling in tests.

### Future Plans
- Adding Maven for dependency management.
- Expanding examples with more real-world scenarios.
- Adding integration tests.

## Development Setup

### Prerequisites
- Java Development Kit (JDK) 11 or higher.
- Git for version control.
- IntelliJ IDEA or any Java IDE of your choice.

### Getting Started

1. **Clone the Repository:**
   ```bash
   git clone git@github.com:ViniciusRio/real-software-dev.git
   cd real-software-dev
   ```

2. **Build the Project:**
   If Maven is added in future updates:
   ```bash
   mvn clean install
   ```

3. **Run Tests:**
   ```bash
   mvn test
   ```
   (JUnit is already set up for unit testing.)

4. **Run the Application:**
   Main class examples are located under `src/main/java`. Run them directly using your IDE or from the terminal.

### Folder Structure
```
real-software-dev/
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.bank.statement.analyst
│   │   │       ├── BankStatementCSVParser.java
│   │   │       ├── BankTransaction.java
│   │   │       └── UtilityClasses.java
│   │   └── resources
│   │       └── bank-data.csv
│   └── test
│       └── java
│           └── com.bank.statement.analyst
│               └── BankStatementCSVParserTest.java
├── .gitignore
├── README.md
└── pom.xml (future update)
```

## Git Workflow
1. Make changes in a new branch:
   ```bash
   git checkout -b feature/branch-name
   ```
2. Stage and commit changes:
   ```bash
   git add .
   git commit -m "Description of changes"
   ```
3. Push changes:
   ```bash
   git push -u origin feature/branch-name
   ```
4. Open a pull request on GitHub.

## Contributing
Feel free to fork this repository and open pull requests to contribute additional examples, fix bugs, or enhance the project.

## License
This project is open-source and is available under the MIT License.

