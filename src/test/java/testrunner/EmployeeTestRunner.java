package testrunner;

import config.Setup;
import io.qameta.allure.Allure;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EmployeeInfo;
import pages.LoginPage;
import utils.Utils;

import java.io.IOException;

public class EmployeeTestRunner extends Setup {

    LoginPage loginPage;
    EmployeeInfo employeeInfo;

    @Test(priority = 1, description = "User try to login with wrong creds")
    public void userLoginWithWrongCreds() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        JSONArray empList = Utils.readJSONList("./src/test/resources/employees.json");
        JSONObject empObj = (JSONObject) empList.get(empList.size()-1);

        String username = (String) empObj.get("username");
        String password = "123";
        loginPage.doLogin(username,password);

        String textActual = driver.findElement(By.className("oxd-alert-content-text")).getText();
        Assert.assertTrue(textActual.contains("Invalid credentials"));
    }

    @Test(priority = 2, description = "User login successfully", groups = "smoke")
    public void userLogin() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        JSONArray empList = Utils.readJSONList("./src/test/resources/employees.json");
        JSONObject empObj = (JSONObject) empList.get(empList.size()-1);

        String username = (String) empObj.get("username");
        String password = (String) empObj.get("password");
        String firstName = (String) empObj.get("firstName");
        String lastName = (String) empObj.get("lastName");
        String fullName = firstName+" "+lastName;
        loginPage.doLogin(username,password);

        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.className("oxd-userdropdown-name")).getText(),fullName);
        softAssert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        softAssert.assertAll();

        Allure.description("User Login Successfully");
    }

    @Test(priority = 3, description = "Save gender & blood group o+")
    public void saveEmployeeInfo() throws InterruptedException {
        Utils.scroll(driver,0,500);
        employeeInfo =new EmployeeInfo(driver);
        employeeInfo.menuItems.get(2).click();
        employeeInfo.selectGender();
        Thread.sleep(2000);
        employeeInfo.selectBloodType();


        String textTitleExcepted = driver.findElement(By.xpath("//*[contains(text(),\"Personal Details\")]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(textTitleExcepted.contains("Personal Details"));
        softAssert.assertTrue(driver.findElement(By.className("oxd-toast-container")).getText().contains("Successfully Updated"));
        softAssert.assertAll();

        Allure.description("Gender & Blood group Save Successfully");
    }
    @Test(priority = 4, groups = "smoke", description = "Update the blood Group as AB-")
    public void updateEmployeeInfo() throws InterruptedException {
        Utils.scroll(driver,0,500);
        employeeInfo =new EmployeeInfo(driver);
        employeeInfo.menuItems.get(2).click();
        Thread.sleep(2000);
        employeeInfo.updateBloodType();

        String textTitleExcepted = driver.findElement(By.xpath("//*[contains(text(),\"Personal Details\")]")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(textTitleExcepted.contains("Personal Details"));
        String message =driver.findElements(By.className("oxd-select-text-input")).get(2).getText();
        softAssert.assertTrue(message.contains("AB-"));
        softAssert.assertAll();
        Allure.description("Blood group Updated Successfully");
    }
    @Test(priority = 5, groups = "smoke", description = "User successfully logs out")
    public void logout(){
        loginPage = new LoginPage(driver);
        loginPage.doLogout();
        String textActual = driver.findElement(By.className("orangehrm-login-title")).getText();
        String textExcepted ="Login";
        Assert.assertEquals(textActual,textExcepted);

        Allure.description("User Logs out Successfully");
    }
}
