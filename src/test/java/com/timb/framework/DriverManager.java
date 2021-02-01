package com.timb.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverManager {
    public static WebDriver driver;
    public static int DEFAULT_IMPLICIT_WAIT = 30;

    protected DriverManager() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
    }

    private static String getOS() {
        return System.getProperty("os.name");
    }

    public static void initializeLocalBrowser(String type) {
        if (type.equalsIgnoreCase("chrome")) {
            setOsSpecificChromeDriver();
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.MILLISECONDS);
    }

    protected static void setOsSpecificChromeDriver() {
        System.out.println("Using System Property: " + getOS());
        if (getOS().equals("Mac OS X") == false) {
            System.setProperty("webdriver.chrome.driver", String.format("%s.exe", System.getProperty("webdriver.chrome.driver")));
        }
    }
}
