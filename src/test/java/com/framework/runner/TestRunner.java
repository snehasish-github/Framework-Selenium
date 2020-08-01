package com.framework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin =  {"html:target/cucumber","json:target/cucumber.json","junit:target/cucumber.xml"},
        features ={"src/test/java/com/framework/features"},
        glue={"com.framework.stepDef"}
        )
public class TestRunner {
}
