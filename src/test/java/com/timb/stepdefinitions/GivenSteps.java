package com.timb.stepdefinitions;


import com.timb.pages.HomePage;
import com.timb.pages.LoginPage;
import com.timb.stepdefinitions.Objects.Login;
import com.timb.stepdefinitions.Objects.TextInputField;
import com.timb.framework.DriverManager;
import io.cucumber.java.en.Given;

public class GivenSteps extends DriverManager {

    private Login login;

    public GivenSteps(Login login) {
        this.login = login;
    }

    @Given("I log into LinkedIn")
    public void i_log_into_linked_in() {
        login.username = new TextInputField("esqueeze@gmail.com");
        login.password = new TextInputField("nf01th02");
        HomePage homePage = new HomePage(driver);
        homePage.login();
        LoginPage loginPage = new LoginPage(driver, login);
        loginPage.login();
    }
}
