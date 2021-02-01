package com.timb.pages;

import com.timb.framework.LoadableHelpers;
import com.timb.stepdefinitions.Objects.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPage extends LoadableComponent<LoginPage> implements LoadableHelpers {

    private Login login;
    private WebDriver driver;

    @FindBy(css = ".card-layout")
    private WebElement cardLayout;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement signInButton;

    public LoginPage(WebDriver driver, Login login) {
        this.driver = driver;
        this.login = login;
        this.load();
        this.isLoaded();
    }

    protected void load() {
        PageFactory.initElements( driver, this );
    }

    protected void isLoaded() throws Error {
        isLoaded(driver, cardLayout, this.getClass().getName());
    }

    public void login() {
        usernameField.sendKeys(login.username.getInputValue());
        passwordField.sendKeys(login.password.getInputValue());
        signInButton.click();
    }
}
