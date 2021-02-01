package com.timb.stepdefinitions;

import com.timb.framework.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends DriverManager {

    @Before
    public void setup() {
        initializeLocalBrowser("chrome");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
