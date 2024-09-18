# WordPress-Automation
Automation Test Suite of WP Dark Mode plugin in WordPress

# WordPress Automation Test Suite

## Overview

This project contains an automation test suite for managing and validating the "WP Dark Mode" plugin on a WordPress site.

## Requirements

- Java 11 or higher
- Maven
- ChromeDriver (other browser will require mvn commands e.g: mvn test -Dbrowsername = 'edge'
- TestNG
- Aquality
- Selenium
- Gson dependency
- dotenv-java dependency

## Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/Slyyoursenpai/Wordpress-Automation.git
    ```

2. Navigate to the project directory:
    ```bash
    cd wordpress-automation
    ```

3. Install dependencies:
    ```bash
    mvn install
    ```

4. Configure WebDriver:
    Ensure that `chromedriver` is in your system PATH, or specify its location in your code.

## Running Tests

Run the tests using Maven:
```bash
mvn test

