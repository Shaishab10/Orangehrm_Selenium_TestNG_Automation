# <div align=center> Orangehrm_Selenium_TestNG_Automation </div>

### <div align=center> In this repository, Selenium WebDriver and TestNG framework are used to automate the Orange HRM website. Here I have covered folowing tasks as login, logout, create new user, search user & update user. A Allure report has been created based on test results & all test cases were written manually during testing.

### Tools & Technology used:
- Selenium Webdriver
- TestNG Framework
- Java
- Intellij idea
- Gradle
- Allure


### Prerequisites
- jdk
- gradle


### How to run this project:
- Clone this project
- Open ```terminal```
- Give this following command for smoke test: ```gradle clean test -Pfilesuite="SmokeMasterSuite.xml"```
- Give this following command for regression test: ```gradle clean test -Pfilesuite="RegressionMasterSuite.xml"```  
- For generating Allure Report use these commands: ```allure generate allure-results --clean -o allure-report``` & ```allure serve allure-results```

### Test Cases:

https://docs.google.com/spreadsheets/d/1tAeQgy25Tx5ztQi944unSPEnzpbkS51y/edit?usp=sharing&ouid=117120284960221469947&rtpof=true&sd=true

### Allure Report for Smoke Test:

![screencapture-192-168-0-152-12536-index-html-2023-10-03-12_05_48 (1)](https://github.com/Shaishab10/Orangehrm_Selenium_TestNG_Automation/assets/54171379/3ddeb329-31fa-4e92-89d6-b5132c065fcc)

![screencapture-192-168-0-152-12536-index-html-2023-10-03-12_08_40](https://github.com/Shaishab10/Orangehrm_Selenium_TestNG_Automation/assets/54171379/6812a5e0-7b22-4262-8868-383be78b3d52)


### Allure Report for Regression Test:
![screencapture-192-168-0-152-2128-index-html-2023-10-03-13_13_41](https://github.com/Shaishab10/Orangehrm_Selenium_TestNG_Automation/assets/54171379/abf59e73-f95b-498a-b70a-791d4f0dddef)

![screencapture-192-168-0-152-2128-index-html-2023-10-03-13_14_26](https://github.com/Shaishab10/Orangehrm_Selenium_TestNG_Automation/assets/54171379/a48dca77-0cf4-466c-9780-4656258eeadc)
