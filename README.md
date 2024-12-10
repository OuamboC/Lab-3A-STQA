# BMICalculator & Calculator Project

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Testing](#testing)
- [Contact](#contact)

## Introduction
Welcome to the BMICalculator & Calculator project! This project consists of two main components:
1. A class to calculate and classify Body Mass Index (BMI).
2. A class to perform integer division.

## Features
- **BMICalculator:**
  - Calculates BMI given weight in kilograms and height in meters.
  - Classifies BMI into categories: Underweight, Normal weight, Overweight, and Obese.

- **Calculator:**
  - Performs integer division of two numbers.

## Prerequisites
- Java 22 or higher.

## Installation
1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourusername/bmi-calculator.git
    cd bmi-calculator
    ```

2. **Compile the project:**
    ```sh
    javac src/main/java/com/example/*.java
    ```

## Usage
- **BMICalculator:**
    ```java
    BMICalculator bmiCalculator = new BMICalculator();
    double bmi = bmiCalculator.calculateBMI(70, 1.75);
    System.out.println("BMI: " + bmi);
    String classification = bmiCalculator.classifyBMI(bmi);
    System.out.println("Classification: " + classification);
    ```

- **Calculator:**
    ```java
    Calculator calculator = new Calculator();
    int result = calculator.division(10, 2);
    System.out.println("Division Result: " + result);
    ```

## Testing
1. **Compile the test classes:**
    ```sh
    javac -cp .:junit-5.8.1.jar src/test/java/com/example/*.java
    ```

2. **Run the tests:**
    ```sh
    java -cp .:junit-5.8.1.jar org.junit.jupiter.api.TestEngine src/test/java/com/example/*.java
    ```

## Testing Files
- **BMICalculator Test Data:**
    - Tests included for various BMI calculations and classifications.
    - Boundary values tested using `@ParameterizedTest` and `@CsvSource`.

- **Calculator Test Data:**
    - Tests included for division operations and exception handling for division by zero.

## Contact
If you have any questions or feedback, feel free to reach out to me at ouambocanis@gmail.com.
