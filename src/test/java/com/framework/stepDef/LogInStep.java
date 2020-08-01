package com.framework.stepDef;

import com.framework.base.DriverManager;
import com.framework.base.UiOperator;
import com.framework.pages.LogInPage;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class LogInStep {
    private DriverManager driverManager;
    private UiOperator uiOperator;
    private Scenario scenario;

    public LogInStep(DriverManager driverManager, UiOperator uiOperator)
    {
        this.driverManager=driverManager;
        this.uiOperator=uiOperator;
    }

    @Before
    public void before(Scenario scenario){
        this.scenario=scenario;
        driverManager.getDriver();
        String Url=driverManager.getProperty("appURL");
        driverManager.driver.get(Url);
    }

    @Given("User Login to application")
    public void user_Login_to_application() {
        try{
            LogInPage logInPage=new LogInPage(driverManager.driver);
            uiOperator.click(logInPage.getbtn_SignIn());
            uiOperator.enterText(logInPage.getTxt_email(),"test.test123@gmail.com");
            uiOperator.enterText(logInPage.getTxt_password(),"Test@123");
            uiOperator.click(logInPage.getBtn_logIn());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

//    @After
//    public void tearDown(){
//        driverManager.driver.quit();
//    }

}
