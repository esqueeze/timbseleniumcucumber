package com.timb.pages;

import com.timb.framework.LoadableHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class UserPage extends LoadableComponent<UserPage> implements LoadableHelpers {

    private WebDriver driver;

    @FindBy(xpath = "//li-icon[@type='compose-icon']/ancestor::button[contains(.,'Compose')]")
    private WebElement newMessageIcon;

    @FindBy(xpath = "//input[contains(@id, '-search-field')]")
    private WebElement nameSearchField;

    public UserPage(WebDriver driver) {
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
        isLoaded(driver, newMessageIcon, this.getClass().getName());
    }

    public void clickNewMessageIcon() {
        newMessageIcon.click();
    }

    public void enterValueNameSearchField(String value) {
        nameSearchField.sendKeys(value);
    }

}
