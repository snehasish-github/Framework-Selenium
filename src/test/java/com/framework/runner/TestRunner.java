package com.framework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin =  {"html:target/cucumber","json:target/cucumber.json","junit:target/cucumber.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features ={"src/test/java/com/framework/features"},
        tags = {"@Register-PositiveFlow"},
        dryRun = true,
        monochrome = true,
        glue={"com.framework.stepDefs"}
        )
public class TestRunner {
}
