# Solution to the Programming Challenge

## Overview

This solution implements the required tasks of the eXXcellent Programming Challenge:

1. **Weather Analysis**: Identify the day with the smallest temperature spread from a weather dataset.
2. **Football Analysis**: Find the team with the smallest goal difference from football statistics.

The solution is designed to be modular, robust, and maintainable, focusing on code readability and extensibility.

---

## Architecture and Design

The project follows a modular architecture to achieve **Separation of Concerns** (SoC):

- **Analyzer**: Implements the business logic to calculate the results for weather and football datasets.
- **Reader**: Handles reading data from different sources, e.g., CSV files.
- **Parser**: Converts raw CSV lines into domain-specific objects (e.g., WeatherRecord, FootballTeam).

### Design Decisions:

1. **Generic Interfaces**:
    - The `Analyzer<T, R>` interface allows the calculation logic to be extended for additional datasets.
    - The `DataReader<T>` and `CsvParser<T>` interfaces enable flexibility in reading and parsing different file types
      or formats.
2. **Separation of Responsibilities**:
    - Parsers and analyzers operate independently, making each component easier to test and maintain.

---

## Process and Decisions

### Why Generic Interfaces?

- To ensure reusability across different datasets (e.g., weather, football).
- To allow the integration of new data types or formats with minimal changes.

### Why Custom CSV Parsing?

- A custom implementation avoids the overhead of dependencies.
- It ensures precise handling of the specific requirements of the challenge datasets.

---

## Challenges and Solutions

### Challenge 1: Differing CSV Formats

- **Problem**: The weather and football datasets had different column structures.
- **Solution**: Specialized parsers (`WeatherCsvParser`, `FootballCsvParser`) were created, inheriting from a
  generic `CsvParser<T>` interface.

### Challenge 2: Handling Invalid Data

- **Problem**: CSV files might contain empty or invalid rows.
- **Solution**: The `parse` method was made robust to ignore malformed rows without interrupting the process.

### Challenge 3: Modularity

- **Problem**: Ensuring each module has a single responsibility.
- **Solution**: Business logic, file reading, and parsing were separated into distinct components.

---

## CI Pipeline

A Continuous Integration (CI) pipeline has been set up using GitHub Actions to automate the following tasks:

* **Build and Test**:
  The pipeline builds the project using Maven and runs all tests.
  Ensures that every code change does not break the build.

On every push to the challenge-weatherdata branch.
On pull requests targeting the challenge-weatherdata branch.
