package com.timb.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@smoke",
        features = "./src/test/java/com/timb/features",
        glue = {"classpath:com.timb.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber"}
        )
public class TestRunner extends AbstractTestNGCucumberTests {

}
