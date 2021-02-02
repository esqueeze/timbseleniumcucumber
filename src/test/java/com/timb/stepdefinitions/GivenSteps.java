package com.timb.stepdefinitions;


import com.timb.framework.DriverManager;
import com.timb.pages.HomePage;
import com.timb.pages.LoginPage;
import com.timb.stepdefinitions.Objects.Login;
import com.timb.stepdefinitions.Objects.TextInputField;
import io.cucumber.java.en.Given;
import org.testng.Reporter;
import org.testng.xml.XmlTest;

public class GivenSteps extends DriverManager {

    private Login login;

    public GivenSteps(Login login) {
        this.login = login;
    }

    @Given("I log into LinkedIn")
    public void i_log_into_linked_in() {
        XmlTest xmlTest = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
        login.username = new TextInputField(xmlTest.getParameter("username"));
        login.password = new TextInputField(xmlTest.getParameter("password"));
        HomePage homePage = new HomePage(driver);
        homePage.login();
        LoginPage loginPage = new LoginPage(driver, login);
        loginPage.login();
    }
}
