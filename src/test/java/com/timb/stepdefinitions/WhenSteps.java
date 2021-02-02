package com.timb.stepdefinitions;

import com.timb.framework.DriverManager;
import com.timb.pages.MessagePage;
import com.timb.pages.ProfilePage;
import com.timb.pages.SearchResultsPage;
import com.timb.pages.UserPage;
import com.timb.stepdefinitions.Objects.TextElement;
import com.timb.stepdefinitions.Objects.UserDetails;
import io.cucumber.java.en.When;

public class WhenSteps extends DriverManager {

    private UserDetails userDetails;

    public WhenSteps(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @When("^I search for '(.*)'$")
    public void i_search_for(String username) {
        UserPage userPage = new UserPage(driver);
        userPage.enterSearchCriteria(username);
    }

    @When("^Send a message to '(.*)'$")
    public void send_a_message_to_him(String fullname) {
        userDetails.fullname = new TextElement(fullname);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, userDetails.fullname.getValue());
        searchResultsPage.clickNameLink();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickMessageButton();
        MessagePage messagePage = new MessagePage(driver);
        messagePage.sendMessage("“Hello, Kamaljeet. This is the auto message from Tim”");
    }

}
