package com.timb.pages;

import com.timb.framework.LoadableHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ProfilePage extends LoadableComponent<ProfilePage> implements LoadableHelpers {

    @FindBy(xpath = "//a[text()='Message']")
    private WebElement messageButton;

    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        load();
        isLoaded();
    }

    @Override
    protected void load() {
        PageFactory.initElements( driver, this );
    }

    @Override
    protected void isLoaded() throws Error {
        isLoaded(driver, messageButton, this.getClass().getName());
    }

    public void clickMessageButton() {
        messageButton.click();
    }
}
