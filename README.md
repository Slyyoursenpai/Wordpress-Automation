# WordPress-Automation
Automation Test Suite of WP Dark Mode plugin in WordPress

# WordPress Automation Test Suite

## Overview

This project contains an automation test suite for managing and validating the "WP Dark Mode" plugin on a WordPress site.

## Requirements

- Java 11 or higher
- Maven
- ChromeDriver set as default (other browser will require mvn commands e.g: mvn test -DbrowserName = 'edge')
- TestNG
- Aquality
- Selenium
- Gson dependency
- dotenv-java dependency
= lombok dependency
- awaitility dependency

## Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/Slyyoursenpai/Wordpress-Automation.git
    ```
    or

   Download zip

2. Add all dependencies and libraries mentioned in requirements ( pom.xml already has them)

3. Configure WebDriver:
    Ensure that `chromedriver` is in your system PATH. (To explicitly call in code, user has to edit code to call web driver in BaseTest) 

## Running Tests

Run the tests using Maven:
```bash
mvn test
```
or run the WordpressTest class through the IDE

##

Aquality Selenium was used to automate this suite as well as a PageObjectModel Design Pattern was followed.

models folder contains environment variable, in Env.java and JSON variable to be used as env for wait and URL, in envData.java

pages folder contains page classes for the web pages that are in interaction with the test

tests folder contains test classes for the main test and base test (pre and post-test operations)

utils folder contains utility classes for formatting and use of JSON and env values

resources folder contains env.json which has key-value pair for wait time and the site url to be used by webdriver. settings.json contains values for various web driver settings. (can be accessed or implemented via maven -DbrowserName = 'edge' to change web driver browser.

The WordpressTest class is the main test driver required to run the tests. The credentials for logging in to the dashboard (username and password) are accessed through environmental variables or .env files. An .env.example is included, which contains instructions for using the variables and a .env file.







