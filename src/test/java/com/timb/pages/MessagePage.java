package com.timb.pages;

import com.timb.framework.LoadableHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MessagePage extends LoadableComponent<MessagePage> implements LoadableHelpers {

    private WebDriver driver;

    @FindBy(xpath = "//div[@aria-label='Write a message…']")
    private WebElement messageBox;

    @FindBy(css = "button.msg-form__send-button")
    private WebElement sendMessageButton;

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
        isLoaded(driver, messageBox, this.getClass().getName());
    }

    public void sendMessage(String messageText) {
        messageBox.sendKeys(messageText);
        sendMessageButton.click();
    }
}
