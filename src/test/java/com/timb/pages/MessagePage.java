package com.timb.pages;

import com.timb.framework.LoadableHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MessagePage extends LoadableComponent<MessagePage> implements LoadableHelpers {

    private WebDriver driver;

    @FindBy(xpath = "//h4[text()='New message']")
    private WebElement newMessageHeader;

    public MessagePage(WebDriver driver) {
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
        isLoaded(driver, newMessageHeader, this.getClass().getName());
    }
}
