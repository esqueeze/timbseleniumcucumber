package com.timb.stepdefinitions;

import com.timb.framework.DriverManager;
import com.timb.pages.UserPage;
import com.timb.stepdefinitions.Objects.UserDetails;
import io.cucumber.java.en.When;

public class ThenSteps extends DriverManager {

    private UserDetails userDetails;

    public ThenSteps(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @When("the message appears in my sent messages")
    public void send_a_message_to_him() {
        UserPage userPage = new UserPage(driver);
        userPage.expandMessageOverlayButton();
        userPage.assertMessageSent(userDetails.fullname.getValue());
    }
}
