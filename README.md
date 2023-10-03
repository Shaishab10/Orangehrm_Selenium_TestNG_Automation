# <div align=center> Orangehrm_Selenium_TestNG_Automation </div>

### <div align=center> In this repository, Selenium WebDriver and TestNG framework are used to automate the Orange HRM website. Here I have covered folowing tasks as login, logout, create new user, search user & update user. A Allure report has been created based on test results & all test cases were written manually during testing.

## Tools & Technology used:
- Selenium Webdriver
- TestNG Framework
- Java
- Intellij idea
- Gradle
- Allure


## Prerequisites
- jdk
- gradle


### How to run this project:
- Clone this project
- Open ```terminal```
- Give this following command for smoke test: ```gradle clean test -Pfilesuite="SmokeMasterSuite.xml"```
- Give this following command for regression test: ```gradle clean test -Pfilesuite="RegressionMasterSuite.xml"```  
- For generating Allure Report use these commands: ```allure generate allure-results --clean -o allure-report``` & ```allure serve allure-results```

