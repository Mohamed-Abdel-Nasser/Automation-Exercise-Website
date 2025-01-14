# AutoFramework_1
## Table of Contents

1. [Introduction](#introduction)
2. [Project Overview](#project-overview)
    - [Project Name](#project-name)
    - [Project Description](#project-description)
    - [Release Notes](#release-notes)
3. [Project Design](#project-design)
    - [Page Object Model (POM)](#page-object-model-pom)
4. [Project Structure](#project-structure)
5. [Tools and Technologies](#tools-and-technologies)
6. [Contributing](#contributing)
---
## Project Name:
### Automation Exercise Website

---
## Project Description:
(Automation Exercise Website) is an highly modular, and scalable test automation framework specifically engineered for comprehensive end-to-end web application testing. Developed using Selenium WebDriver.
it offers a robust foundation for creating clean, maintainable, and reusable automated test cases.
Its modular design ensures flexibility, enabling seamless integration with various tools and technologies, while maintaining high standards of performance, reliability, and test coverage.

---
# Release Notes
## Version 1.0
This marks the first release of the AutoFramework-2 project.
I am committed to continually enhancing and evolving this framework to ensure it remains updated, robust, and professional.
With each iteration, the project will integrate modern features, improved functionality, and industry best practices to meet the dynamic needs of test automation.

Future updates will focus on:
- Adding advanced automation features.
- Enhancing performance and efficiency.
- Ensuring compatibility with emerging tools and technologies.
- Maintaining alignment with industry standards to deliver a consistently professional and dependable solution.

---
### Project Design:
- Page Object Model (POM)

---
## Project Structure

```
Automation-Exercise-Website/
├── src/main/java/Data/                  # Data handling (e.g., JSON readers, data classes)
├── src/main/java/Pages/                 # Page Object Model (POM) classes
├── src/main/java/Utilities/             # Utility functions (e.g., actions, browser setup, wait handling)
├── src/test/java/Pages_TC/              # Test cases for each page
├── src/test/java/EndToEndTest/          # End-to-end test scenarios
├── src/test/java/TestBase/              # Base test setup and configurations
├── src/test/resources/TestData/         # Test data and configuration files
├── pom.xml                              # Maven configuration
└── README.md                            # Project documentation
```


---
## Tools and Technologies
- **Java**: Programming language
    - java 23.0.1 2024-10-15
- **Selenium WebDriver**: For browser automation
    - Selenium 4.27.1
- **IntelliJ IDEA**: A powerful IDE for efficient Java development with advanced features and intelligent code assistance.
    - IntelliJ IDEA 2024.3 (Community Edition)
- **Maven Dependencies**: For dependency management
    - **Selenium Java**: For web automation and browser interaction.
    - **TestNG**: For test execution and reporting.
    - **JSON Simple**: For parsing and generating JSON data.
    - **Commons IO**: Provides utility classes for input/output operations.
    - **Allure TestNG**: For generating interactive test reports with Allure.
    - **AspectJ Weaver**: For aspect-oriented programming (AOP) and weaving aspects into the code.
    - **Jackson Databind**: For converting Java objects to/from JSON.
    - **Log4j**: A flexible logging framework for debugging and monitoring.
        - **log4j-core**: Core module for logging implementation.
        - **log4j-api**: Provides logging functionality API.

---
## Contributing
Contributions are welcome!
We welcome contributions from QA Automation Testing Engineers! To contribute:

1. Fork the repository and clone it to your local machine.
2. Create a new branch for your test enhancements or fixes (`git checkout -b test-enhancement-name`).
3. Write clear, maintainable test scripts and ensure thorough test coverage.
4. Run all tests and confirm they pass successfully.
5. Commit your changes with meaningful messages (`git commit -m 'Add new test or fix'`).
6. Push your branch to your fork (`git push origin test-enhancement-name`).
7. Open a pull request, including a description of your improvements or fixes.

We look forward to your contributions and appreciate your attention to quality!

---
