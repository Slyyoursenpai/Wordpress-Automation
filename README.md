# WordPress-Automation
Automation Test Suite of WP Dark Mode plugin in WordPress

# WordPress Automation Test Suite

## Overview

This project contains an automation test suite for managing and validating the "WP Dark Mode" plugin on a WordPress site.

Site URL: 

Admin:  http://wppool-test.000.pe/wp-login.php 

User(Frontend): http://wppool-test.000.pe/

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
    Ensure that `chromedriver` is in your system PATH. (To explicitly call in code, the user has to edit code to call web driver in BaseTest)

4. For remote hosting, use url http://wppool-test.000.pe/wp-admin/ in prod.json. (Website while being hosted shows some problem e.g save button does not work)

5. For local hosting, set up your own WordPress Site and install WP Dark Mode plugin. Use the Local app to create a WordPress site name it demo-site and make sure it has the URL: demo-site.local/dashboard
 You can use your own name and url but url has to be changed in the code in prod.json as mentioned below. Keeping Dark Mode plugin uninstalled or inactive will make the test script check for install/activate it.
Also, login credentials are the username or password you will set during the setup of your website. My login credentials were set up with the Local app as well.

## Running Tests

Run the tests using Maven:
```bash
mvn test
```
or run the WordpressTest class through the IDE

##

**Note:**
While running the steps for selecting multiple switch options and saving them each time, the save button may occasionally fail to appear causing the test to fail as the save button needs to be pressed to proceed, a rerun of the test will fix this. 


Aquality Selenium was used to automate this suite as well as a PageObjectModel Design Pattern was followed.

models folder contains environment variable, in Env.java and JSON variable to be used as env for wait and URL, in envData.java

pages folder contains page classes for the web pages that are in interaction with the test

tests folder contains test classes for the main test and base test (pre and post-test operations)

utils folder contains utility classes for formatting and use of JSON and env values

resources folder contains env.json which has key-value pair for wait time and the site url to be used by webdriver. settings.json contains values for various web driver settings. (can be accessed or implemented via maven -DbrowserName = 'edge' to change web driver browser.

The WordpressTest class is the main test driver required to run the tests. The credentials for logging in to the dashboard (username and password) are accessed through environmental variables or .env files. An .env.example is included, which contains instructions for using the variables and a .env file.

## Scenario

Pre-Conditions:
Browser opens URL: http://wppool-test.000.pe/wp-login.php (hosted on the internet) 

or for local access, go to prod.json and change the site value to your own local URL. 

Example: My local site url was, http://demo-site.local/wp-admin/ . I generated using the Local app when creating the WordPress site. 
Test Steps: 

-Log in to WordPress site.

-Check whether the “WP Dark Mode” Plugin is Active or not.

-If Active, navigate to the WP Dark Mode & continue. Otherwise, Install the Plugin and Activate it.

-Enable Admin Dashboard Dark Mode from Controls → Admin Panel Dark Mode.

-Validate whether the dark mode is working or not on the Admin Dashboard.

-Navigate to the WP Dark Mode.

-From Customization → Switch Settings → Change the “Floating Switch Style” from the default selections (Select any one from the available options, except the default selected one).

-From Customization → Switch Settings → Switch Customization - Select Custom Switch size & Scale it to 220.

-From Customization → Switch Settings - Change the Floating Switch Position (Left).

-Disable the Keyboard Shortcut from the Accessibility Settings.

-From Customization → Site Animation → “Enable Page-Transition Animation” & change the Animation Effect from the default selections.

-Validate whether the dark mode is working or not from the front end.







