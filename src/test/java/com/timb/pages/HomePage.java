package com.timb.pages;

import com.timb.framework.LoadableHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;


public class HomePage extends LoadableComponent<HomePage> implements LoadableHelpers {

    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Sign in']")
    WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://linkedin.com");
        this.load();
        this.isLoaded();
    }

    @Override
    protected void isLoaded() throws Error {
        isLoaded(driver, loginButton, this.getClass().getName());
    }

    @Override
    protected void load() {
        PageFactory.initElements( driver, this );
    }

    public void login() {
        loginButton.click();
    }

}
