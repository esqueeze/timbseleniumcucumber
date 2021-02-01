package com.timb.framework;

import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public interface LoadableHelpers {
    default void isLoaded(WebDriver driver, WebElement element, String pageName) {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        boolean loaded = false;
        if ( !(element == null ) ) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 10L);
                wait.until(ExpectedConditions.visibilityOf(element));
                if ( element.isDisplayed() ) {
                    loaded = true;
                }
            } catch ( ElementNotVisibleException e ) {

            }
        }
        Assert.assertTrue( "The " + pageName + "page didn't load", loaded );
    }
}
