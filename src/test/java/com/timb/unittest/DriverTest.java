package com.timb.unittest;

import com.timb.framework.DriverManager;
import org.junit.Assert;
import org.junit.Test;

public class DriverTest extends DriverManager {

    @Test
    public void osSelectionWindows() {
        System.setProperty("os.name", "Windows");
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        setOsSpecificChromeDriver();
        Assert.assertEquals(String.format("Was expecting chromedriver.exe but got %s instead",
                System.getProperty("webdriver.chrome.driver")), System.getProperty("webdriver.chrome.driver"), "chromedriver.exe");
    }

    @Test
    public void osSelectionMac() {
        System.setProperty("os.name", "Mac OS X");
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        setOsSpecificChromeDriver();
        Assert.assertEquals(String.format("Was expecting chromedriver but got %s instead",
                System.getProperty("webdriver.chrome.driver")), System.getProperty("webdriver.chrome.driver"), "chromedriver");
    }
}
