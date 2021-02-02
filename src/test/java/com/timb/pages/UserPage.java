package com.timb.pages;

import com.timb.framework.LoadableHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserPage extends LoadableComponent<UserPage> implements LoadableHelpers {

    private WebDriver driver;

    private String overlayMessageLocator = "//h4[contains(@class,'msg-conversation-listitem__participant-names')][text()='%s']";

    @FindBy(css = ".search-global-typeahead__input")
    private WebElement globalSearchBox;

    @FindBy(xpath = "//span[text()='You are on the messaging overlay. Press enter to open the list of conversations.']/ancestor::button")
    private WebElement expandMessageOverlayButton;

    private WebElement getMessageFromOverlay(String name) {
        WebDriverWait wait = new WebDriverWait(driver, 10L);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(overlayMessageLocator, name))));
    }

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
        isLoaded(driver, globalSearchBox, this.getClass().getName());
    }

    public void enterSearchCriteria(String name) {
        globalSearchBox.sendKeys(name);
    }

    public void expandMessageOverlayButton() {
        globalSearchBox.click();
    }

    public void assertMessageSent(String name) {
        try {
            getMessageFromOverlay(name);
        } catch (TimeoutException ex) {
            System.out.println(ex);
            Assert.fail("Could not find the message sent to " + name);
        }
    }
}
