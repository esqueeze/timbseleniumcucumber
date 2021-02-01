package com.timb.stepdefinitions;

import com.timb.framework.DriverManager;
import com.timb.pages.UserPage;
import io.cucumber.java.en.When;

public class WhenSteps extends DriverManager {
    @When("^I search for '(.*)'$")
    public void i_search_for(String username) {
        UserPage userPage = new UserPage(driver);
        userPage.clickNewMessageIcon();
        userPage = new UserPage(driver);
        userPage.enterValueNameSearchField(username);

    }
}
