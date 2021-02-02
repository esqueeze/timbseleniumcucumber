package com.timb.pages;

import com.timb.framework.LoadableHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class SearchResultsPage extends LoadableComponent<SearchResultsPage> implements LoadableHelpers {

    private WebDriver driver;
    private String name;

    private String nameLinkLocator = "//span[text()='%s']/ancestor::a";

    public SearchResultsPage(WebDriver driver, String name) {
        this.driver = driver;
        this.name = name;
        load();
        isLoaded();
    }

    @Override
    protected void load() {
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void isLoaded() throws Error {
        isLoaded(driver, nameLink(name), this.getClass().getName());
    }

    private WebElement nameLink (String name) {
        return  driver.findElement(By.xpath(String.format(nameLinkLocator, name)));
    }

    public void clickNameLink() {
        nameLink(name).click();
    }
}
