package com.framework.stepDefs;

import com.framework.base.DriverManager;
import com.framework.base.UiOperator;
import com.framework.pages.LogInPage;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class LogInStep {
    private DriverManager driverManager;
    private UiOperator uiOperator;
    private Scenario scenario;
    LogInPage logInPage;

    public LogInStep(DriverManager driverManager, UiOperator uiOperator)
    {
        this.driverManager=driverManager;
        this.uiOperator=uiOperator;
    }

   /* @Before

    public void before(Scenario scenario)
    {
        this.scenario=scenario;
        driverManager.getDriver();
        System.out.println("Hashcode in step"+driverManager.hashCode());
        String Url=driverManager.getProperty("appURL");
        driverManager.driver.get(Url);

    }*/

    @Given("User Login to application with {string},{string}")
    public void user_Login_to_application_with(String userName, String password) {
        try{
            logInPage=new LogInPage(driverManager.driver,uiOperator);
            logInPage.singIn(userName,password);
//            final byte[] screenshot = ((TakesScreenshot) driverManager.driver).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshot,"image/png");
            uiOperator.takeScreenshot(scenario);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Given("User serach for dress")
    public void user_serach_for_dress() {
        try{
            logInPage=new LogInPage(driverManager.driver,uiOperator);
            logInPage.searchProduct("Dress");
            uiOperator.takeScreenshot(scenario);
            FluentWait wait=new FluentWait(driverManager.driver);
            wait.withTimeout(Duration.ofSeconds(20));
            wait.pollingEvery(Duration.ofSeconds(5));
            wait.ignoring(NoSuchElementException.class);
            Function<WebDriver,Boolean> fn=(webdriver)->{
                List<WebElement> allEle= webdriver.findElements(By.name("foo"));
                List allText= new ArrayList<>();
                for(WebElement e: allEle)
                {
                    String textEle= e.getText();
                    if(textEle.equals("SomeData"))
                        allText.add(textEle);
                    if(allText.size()==10)
                    {
                        return true;
                    }
                }
                return false;
            };
            wait.until(fn);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


   /* @After
    public void tearDown(){
        driverManager.driver.quit();
    }*/

}
