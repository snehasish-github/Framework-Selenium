package com.framework.stepDefs;

import com.framework.base.DriverManager;
import com.framework.base.UiOperator;
import com.framework.pages.LogInPage;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CreateUser {
    private DriverManager driverManager;
    private UiOperator uiOperator;
    private Scenario scenario;
    LogInPage logInPage;

    public CreateUser(DriverManager driverManager, UiOperator uiOperator)
    {
        this.driverManager=driverManager;
        this.uiOperator=uiOperator;
    }

    @Before
    public void before(Scenario scenario)
    {
        this.scenario=scenario;
    }

    @Given("User has valid emailId to create an account {string}")
    public void user_has_valid_emailId_to_create_an_account(String emailId) {
        try{
            logInPage=new LogInPage(driverManager.driver,uiOperator);
            logInPage.clickSignIn();
            logInPage.createAccount(emailId);
            uiOperator.takeScreenshot(scenario);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @When("user provide vaild data in create an acccount page with {string},{string},{string},{string},{string},")
    public void user_provide_vaild_data_in_create_an_acccount_page_with(String string, String string2, String string3, String string4, String string5) {

    }



}
